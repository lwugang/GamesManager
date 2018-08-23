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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/games")
public class GameListServlet extends HttpServlet {

  private static final long serialVersionUID = -225836733891271748L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AVQuery<AVObject> avQuery = new AVQuery<>("Games");
    try {
      avQuery.include("icon");
      avQuery.include("imgs");
      avQuery.include("imgs1");
      avQuery.include("imgs2");
      avQuery.include("apkFile");
      List<AVObject> avObjects = avQuery.find();
      List<Game> games = new ArrayList<>();
      Game game = null;
      for (int i = 0; i < avObjects.size(); i++) {
        AVObject avObject = avObjects.get(i);
        game = new Game();
        if(avObject.getAVFile("apkFile")==null)
          continue;
        game.apkFile = avObject.getAVFile("apkFile").getUrl();
        game.icon = avObject.getAVFile("icon").getUrl();
        game.imgs = avObject.getAVFile("imgs").getUrl();
        game.imgs1 = avObject.getAVFile("imgs1").getUrl();
        game.imgs2 = avObject.getAVFile("imgs2").getUrl();
        game.name = avObject.getString("name");
        game.desc = avObject.getString("desc");
        games.add(game);
      }
      req.setAttribute("games",games);
      req.getRequestDispatcher("/game_list.jsp").forward(req,resp);
    } catch (AVException e) {
      e.printStackTrace();
    }
  }
}
