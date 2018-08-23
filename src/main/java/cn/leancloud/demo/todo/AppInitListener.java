package cn.leancloud.demo.todo;

import cn.leancloud.LeanEngine;
import com.avos.avoscloud.AVOSCloud;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitListener implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {}

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    // 参数依次为 AppId、AppKey、MasterKey
    LeanEngine.initialize("yh79bSy3uFuqMIdnJoIiVUpm-gzGzoHsz","EnGUx3v6Y46nGep35RV9EbYb","TuY0nUwqnNo1UL4QJIErl2Cl");
    AVOSCloud.initialize("yh79bSy3uFuqMIdnJoIiVUpm-gzGzoHsz","EnGUx3v6Y46nGep35RV9EbYb","TuY0nUwqnNo1UL4QJIErl2Cl");
  }
}
