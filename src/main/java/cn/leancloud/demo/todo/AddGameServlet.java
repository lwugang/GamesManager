package cn.leancloud.demo.todo;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/addGame")
@MultipartConfig
public class AddGameServlet extends HttpServlet {

    private static final long serialVersionUID = -225836733891271748L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part namePart = req.getPart("name");
        Game game = new Game();
        game.name = readPart(namePart,true).toString();
        game.desc = readPart(req.getPart("desc"), true).toString();
        game.icon = readPart(req.getPart("icon"),false);
        game.imgs = readPart(req.getPart("imgs"), false);
        game.imgs1 = readPart(req.getPart("imgs1"),false);
        game.imgs2 = readPart(req.getPart("imgs2"), false);
        game.apkFile = readPart(req.getPart("apkfile"),false);
        AVObject avObject = new AVObject("Games");
        game.saveInBackground(avObject,new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e!=null){
                    e.printStackTrace();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    //game.saveInBackground(avObject,this);
                }
            }
        });
        resp.sendRedirect("/games");
    }

    private Object readPart(Part part, boolean isFormField) throws IOException {
        InputStream inputStream = part.getInputStream();
        if (inputStream.available() < 0)
            return null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
        }
        baos.flush();
        if(!isFormField){
            AVFile avFile = new AVFile(part.getSubmittedFileName(),baos.toByteArray());
            baos.close();
            avFile.saveInBackground();
            return avFile;
        }else {
            return baos.toString("UTF-8");
        }
    }
}
