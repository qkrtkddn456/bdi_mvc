<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		빅데이터 MVC 첫 페이지
		<div class="left"></div>
		<div class="right">
			<jsp:include page="/WEB-INF/views/user/userList.jsp"/>
		</div>
		
	</div>
</body>
</html>