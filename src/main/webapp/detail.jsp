<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 2018/8/23
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${game.name}</title>
    <style type="text/css">
        li {
            padding: 20px;
            list-style-type: none;
            align-content: center;
            text-align: center;
            margin-right: 20px;
            box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2), 0 2px 5px 0 rgba(0, 0, 0, 0.19);
        }

        li span {
            line-height: 35px;
        }

        .button {
            display: inline-block;
            outline: none;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            font: 16px/100% 'Microsoft yahei', Arial, Helvetica, sans-serif;
            padding: .5em 2em .55em;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
            -webkit-border-radius: .5em;
            -moz-border-radius: .5em;
            border-radius: .5em;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
        }

        .button:hover {
            text-decoration: none;
        }

        .button:active {
            position: relative;
            top: 1px;
        }

        .blue {
            color: #d9eef7;
            border: solid 1px #0076a3;
            background: #0095cd;
            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
            background: -moz-linear-gradient(top, #00adee, #0078a5);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');
        }

        .blue:hover {
            background: #007ead;
            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
            background: -moz-linear-gradient(top, #0095cc, #00678e);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e');
        }

        .blue:active {
            color: #80bed6;
            background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee));
            background: -moz-linear-gradient(top, #0078a5, #00adee);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee');
        }

    </style>

</head>
<body>
<div style="width: 60%; margin: 0 auto;text-align: center;">
    <li>
        <img src="${game.icon}"/><br/><br/>
        <span style="font-weight: bold">${game.name}</span><br/><br/>
        <span class="desc">${game.desc}</span><br/>
        <a href="${game.imgs}"><img src="${game.imgs}" width="200" height="400"/></a>
        <a href="${game.imgs1}"><img src="${game.imgs1}" width="200" height="400"/></a>
        <a href="${game.imgs2}"><img src="${game.imgs2}" width="200" height="400"/></a>
        <br/><br/><br/><br/><br/><br/>
        <div>
            <div class="button blue" onclick="javascript:history.back()" style="">返回</div>
            <div class="button blue" onclick="javascript:location.href='${game.apkFile}'">下载</div>
        </div>
    </li>

</div>
</body>
</html>
