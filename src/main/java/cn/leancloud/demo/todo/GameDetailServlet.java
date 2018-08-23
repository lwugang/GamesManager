package cn.leancloud.demo.todo;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detail")
public class GameDetailServlet extends HttpServlet {

    private static final long serialVersionUID = -225836733891271748L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        AVQuery avQuery = new AVQuery("Games");
        try {
            avQuery.include("icon");
            avQuery.include("imgs");
            avQuery.include("imgs1");
            avQuery.include("imgs2");
            avQuery.include("apkFile");
            AVObject avObject = avQuery.whereContains("name", name).getFirst();

            Game game = new Game();
            game.apkFile = avObject.getAVFile("apkFile").getUrl();
            game.icon = avObject.getAVFile("icon").getUrl();
            game.imgs = avObject.getAVFile("imgs").getUrl();
            game.imgs1 = avObject.getAVFile("imgs1").getUrl();
            game.imgs2 = avObject.getAVFile("imgs2").getUrl();
            game.name = avObject.getString("name");
            game.desc = avObject.getString("desc");
            req.setAttribute("game", game);
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);
        } catch (AVException e) {
            e.printStackTrace();
            resp.getOutputStream().write("网络异常".getBytes("UTF-8"));
        }
    }
}