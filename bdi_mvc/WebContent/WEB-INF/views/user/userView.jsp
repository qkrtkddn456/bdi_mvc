<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>유저번호</th>
				<td>${user.uino}</td>
			</tr>
			<tr>
				<th>유저이름</th>
				<td>${user.uiname}</td>
			</tr>
			<tr>
				<th>유저아이디</th>
				<td>${user.uiid}</td>
			</tr>
			<tr>
				<th>유저 설명</th>
				<td>${user.uidesc}</td>
			</tr>
			<tr>
				<th>유저 나이</th>
				<td>${user.uiage}</td>
			</tr>
			<tr>
				<th>부서 번호</th>
				<td>${user.dino}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<form action="/user/userDelete" method="post">
						<button type="button" data-page='/user/userList' >리스트가기</button>
						<button type="button" data-page='/user/userUpdate?uiNo=${user.uino}'>메이커수정</button>
						<button>삭제</button>
						<input type="hidden" name="uiNo" value="${user.uino}">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>