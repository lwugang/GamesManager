<%@ page import="com.alibaba.fastjson.JSON" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>游戏中心</title>
    <style type="text/css">
        h1{
            margin-bottom: 30px;
            color: white;
            padding: 10px;
        }
        li{
            padding: 20px;
            width: 20%;
            list-style-type: none;
            float: left;
            display: inline;
            align-content: center;
            text-align: center;
            margin-right: 20px;
            box-shadow: 0 2px 4px 0 rgba(0,0,0,0.2), 0 2px 5px 0 rgba(0,0,0,0.19);
        }
        .desc{
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 5;
            overflow: hidden;
        }
    </style>
</head>
<body>
<div style="width: 80%;margin: 0 auto; ">
    <h1 style="text-align: center;background: #8489ff">游戏中心</h1>
    <ul style="width: 80%;margin: 0 auto;">
        <c:forEach items="${games}" var="game">
            <li>
                <a href="/detail?name=${game.name}"><img src="${game.icon}"/><br/><br/></a>
                <a href="/detail?name=${game.name}"><span style="font-weight: bold">${game.name}</span><br/><br/></a>
                <a href="/detail?name=${game.name}" style="text-decoration: none"><span class="desc">${game.desc}</span></a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
