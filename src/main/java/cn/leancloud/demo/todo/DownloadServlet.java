package cn.leancloud.demo.todo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = -225836733891271748L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String apkFile = req.getParameter("apkFile");
        File file = new File(URLDecoder.decode(apkFile));
        FileInputStream fis = new FileInputStream(req.getServletContext().getRealPath(apkFile));
        String filename = URLEncoder.encode(file.getName(), "utf-8"); //解决中文文件名下载后乱码的问题
        byte[] b = new byte[fis.available()];
        fis.read(b);
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Disposition", "attachment; filename=" + filename + "");
        //获取响应报文输出流对象
        ServletOutputStream out = resp.getOutputStream();
        //输出
        out.write(b);
        out.flush();
        out.close();
    }
}