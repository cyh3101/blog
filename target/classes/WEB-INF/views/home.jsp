<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${ctx}/css/main.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap-markdown.min.css" rel="stylesheet">
<link href="${ctx}/css/pagination.css" rel="stylesheet">

<script type="text/javascript" src="${ctx}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap.js"></script> 
<script type="text/javascript" src="${ctx}/js/bootstrap-markdown.js"></script>
</head>
<body>
	<%@ include file="top-col.jsp" %>
	<%@ include file="left-col.jsp" %>
	
	
	<div id="container">
	    <div id="mid-col">
	    	<div class="body-wrap">
	    		<c:forEach items="${blogs}" var="blog" >
					<div class="article-inner ${blog.title}">
	                    <header class="article-header">
	                        <h2>${blog.title}</h2>
	                    </header>
	                    <div class="details">
	                        <p class="text-left"></p>
	                    </div>
	                </div>
				</c:forEach>
	    	</div>
	    </div>
	</div>
</body>
</html>