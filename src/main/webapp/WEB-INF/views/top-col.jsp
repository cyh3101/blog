<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<div id="top-col">
        <div class="navbar navbar-inverse" style="margin-bottom: inherit;background: #575757;border: none">
            <div class="navbar-header">
                <a href="javascript:void(0)" class="navbar-brand">song</a>
            </div>
                <div style="float: right">
                    <ul class="nav navbar-nav">
                        <li><a href="${ctx}/user/login">登录</a></li>
                        <li><a href="${ctx}/user/register">注册</a></li>
                    </ul>
                </div>
                <div style="float: right">
                    <ul class="nav navbar-nav">
                        <li><a href="javascript:void(0)"></a></li>
                        <li><a href="javascript:void(0)">我的信息</a></li>
                        <li class="dropdown">
                            <a href="##" data-toggle="dropdown" class="dropdown-toggle">设置<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${ctx}/user/setting/>">设置个人信息</a>
                                </li>
                                <li><a href="javascript:void(0)">修改密码</a></li>
                                <li><a href="${ctx}/user/logout">登出</a></li>
                            </ul>
                        </li>
                            <li class="dropdown">
                                <a href="##" data-toggle="dropdown" class="dropdown-toggle">我的控制<span
                                        class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="${ctx}/admin">控制</a></li>
                                    <li><a href="${ctx}/blog/write">写文章</a></li>
                                </ul>
                            </li>
                    </ul>
                </div>
        </div>
    </div>
