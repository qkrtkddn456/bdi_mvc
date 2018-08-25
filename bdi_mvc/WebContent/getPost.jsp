<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<form action="/test">
	이름 : <input type="text" name="name">
	<button>get 전송 </button>
</form>
<form action="/test" method="post">
	이름 : <input type="text" name="name">
	<button>post 전송 </button>
</form>
</body>
</html>