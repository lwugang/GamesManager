package cn.leancloud.demo.todo;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import org.json.JSONObject;

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
      List<AVObject> avObjects = avQuery.find();
      List<Game> games = new ArrayList<>();
      for (int i = 0; i < avObjects.size(); i++) {
        JSONObject jsonObject = avObjects.get(i).toJSONObject();
        games.add(JSON.parseObject(jsonObject.toString(),Game.class));
      }
      System.out.println(games);
      req.setAttribute("games",games);
      req.getRequestDispatcher("/game_list.jsp").forward(req,resp);
    } catch (AVException e) {
      e.printStackTrace();
    }
  }
}
