package cn.leancloud.demo.todo;

import com.avos.avoscloud.AVException;
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
        game.name = readPart(namePart, null,true);
        game.desc = readPart(req.getPart("desc"), game.name,true);
        game.icon = readPart(req.getPart("icon"),game.name, false);
        game.imgs = readPart(req.getPart("imgs"), game.name,false);
        game.imgs1 = readPart(req.getPart("imgs1"), game.name,false);
        game.imgs2 = readPart(req.getPart("imgs2"), game.name,false);
        game.apkFile = readPart(req.getPart("apkfile"), game.name,false);
        AVObject avObject = new AVObject("Games");
        game.saveInBackground(avObject,new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e!=null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    game.saveInBackground(avObject,this);
                }
            }
        });
        resp.sendRedirect("/games");
    }

    private String readPart(Part part,String name, boolean isFormField) throws IOException {
        InputStream inputStream = part.getInputStream();
        if (inputStream.available() < 0)
            return null;
        File file = null;
        FileOutputStream fos = null;
        if (!isFormField) {
            file = new File(getServletContext().getRealPath("/upload")+"/"+name);
            if(!file.exists()){
                file.mkdirs();
            }
            fos = new FileOutputStream(new File(file,part.getSubmittedFileName()));
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            if (isFormField) {
                baos.write(buffer, 0, len);
            } else {
                fos.write(buffer, 0, len);
            }
        }
        if (isFormField) {
            return baos.toString("UTF-8");
        }
        return "/upload/"+name+"/"+part.getSubmittedFileName();
    }
}
