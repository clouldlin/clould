<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="paging" uri="/WEB-INF/tld/paging-taglib.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="stylesheet" type="text/css" href="/css/main/main.css" />
<script src="/js/common.js"></script>
<script src="/js/login/login.js"></script>
<script src="/js/main/main.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div>
</div>
<div class="wrapper">  
	<div class="header">
	</div> 
	<div class="sidebar"></div>
	<div class="content">
		<p>${noticeView.SEQ}</p>
		<p>${noticeView.CONTENT}</p>
		<p>${noticeView.TITLE}</p>
	</div>
	<p><a href="/main/main">목록으로</a></p>
	<div class="footer"></div>
</div>

</body>
</html>