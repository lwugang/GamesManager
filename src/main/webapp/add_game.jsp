<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2018/8/23
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加游戏</title>
</head>
<style>
    ul li {
        line-height: 45px;
        list-style-type: none;
    }
</style>
<body>
<div style="width: 400px; margin: 0 auto;">
    <form action="/addGame" method="post" enctype="multipart/form-data">
        <ul>
            <li>游戏名称：<input name="name"/><br/></li>
            <li>apk文件：<input name="apkfile" type="file"/><br/></li>
            <li>游戏图标：<input name="icon" type="file"/><br/></li>
            <li>游戏描述：<textarea name="desc" style="width: 400px; height: 100px;"></textarea>
            <li>游戏截图：<input name="imgs" type="file"/><br/></li>
            <li>游戏截图：<input name="imgs1" type="file"/><br/></li>
            <li>游戏截图：<input name="imgs2" type="file"/><br/></li>
            <br/>
            <li><input style="width: 80px; margin: 0 auto;display: block" type="submit" value="保存"/></li>
        </ul>
    </form>
</div>
</body>
</html>
