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
/********************************************************************************
 * 기      능   	:  페이징 처리
 * @param obj	:
 * @return  	:
 ********************************************************************************/
 var fn_linkPage = function(pageIndex){
	 var f = document.searchFrm;
	 f.pageIndex.value = pageIndex;
	 f.action = "/main/main";
	 f.submit();
 };
 
 /********************************************************************************
  * 기      능   	:  파일다운로드 처리
  * @param obj	:
  * @return  	:
  ********************************************************************************/
 var file_down = function(fileName) {
 	location.href="/file/download";
 }
 
</script>
</head>
<body>
<div>
<span onclick="file_down(2); return false;" onkeypress="file_down(2); return false;" style="cursor: pointer;"><a href="#">다운로드</a></span>
</div>
<div class="wrapper">  
	<div class="header">
		<div class="main_title">메인</div>
		<div class="login">
			<form method="post" action="/login/login">
				<input type="text" size="15" name="id" id="id">
				<input type="password" size="15" name="pasword" id="password">
				<input type="submit" id="submit" value="로그인">
				<div><input type="checkbox" id="id_save"><span class="id_save">아이디 저장</span></div>
			</form>
		</div>
	</div> 
	<div class="sidebar"></div>
	<div class="content">
		<div style="background-color:#C4FDFF; width: 40%;">
		
			<form name="noticeInsert" id="noticeInsert" method="post" enctype="multipart/form-data" action="/main/noticeInsert">
				<input type="text" size="15" name="title" id="title">
				<input type="text" size="15" name="content" id="content">
				<input type="file" size="15" name="file" id="file">
				<input type="file" size="15" name="file1" id="file1">
				<input type="submit" id="submit" value="등록">
			</form>
			
			<div>
				<table summary="순번, 제목, 내용" >
					<caption>메인 공지사항</caption>
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="*" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"><label>순번</label></th>
							<th scope="col"><label>제목</label></th>
							<th scope="col"><label>내용</label></th>
						</tr>
					</thead>
					<tbody>
	                    <c:forEach var="list" items="${noticeList}" varStatus="status">
							<tr id="nooticeList_${status.index}">
								<td><a href="/main/noticeView?seq=${list.seq}">
									<c:out value="${noticeTotalCount + 1 - ((pageIndex-1) * 10 + status.count)}"/>
								</a></td>
								<td>${list.title}</td>
								<td>${list.content}</td>
							</tr>
						</c:forEach>
						<c:if test="${empty noticeList}">
							<tr>
								<td colspan="3">검색결과가 없습니다.</td>
							</tr>
						</c:if>
			        </tbody>
				</table>
		   	</div>
		   	<!-- paging -->
			<paging:page link="#" 
						 linkMethod="fn_linkPage"	
						 page="${pageIndex}" 
						 totalCount="${noticeTotalCount}" 
						 listPerPage="10" 
						 beginLabel="../images/btn/btn_larrow.gif"
						 prevLabel="../images/btn/btn_llarrow.gif"
						 endLabel="../images/btn/btn_rrarrow.gif"
						 nextLabel="../images//btn/btn_rarrow.gif"
						 pageGroupSize="5" 
						 linkType="script" />
			<!-- //paging -->
		</div>
		<br />
		<!-- 검색영역  -->
		<div>
		<form name="searchFrm" action="/main/main" method="get">
			<select name="keyword" id="keyword" title="검색분류 선택" style="width:100px;">
				<option value="ALL" selected="selected">전체</option>
				<c:forEach var="codeList" items="${codeList}" varStatus="status">
						<option value="${codeList.VALUE}" <c:if test="${keyword == codeList.VALUE}"> selected="selected"</c:if> > ${codeList.DATA}</option>
				</c:forEach>
			</select>
			<input type="text" name="txt_search" value="${txt_search}" />
			<input type="hidden" name="pageIndex" value="${pageIndex}" />
			<input type="submit" value="검색"  />
		</form>
		
		</div>
		
	</div>
	<div class="footer"></div>
</div>

</body>
</html>