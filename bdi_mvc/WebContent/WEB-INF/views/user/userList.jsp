<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<h4>유저 리스트</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>유저번호</th>
					<th>유저이름</th>
					<th>유저아이디</th>
					<th>유저설명</th>
					<th>유저나이</th>
					<th>부서번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="ul">
					<tr>
						<td>${ul.uino}</td>
						<td><a href="/user/userView?uiNo=${ul.uino}">${ul.uiname}</a></td>
						<td>${ul.uiid}</td>
						<td>${ul.uidesc}</td>
						<td>${ul.uiage}</td>
						<td>${ul.dino}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button data-page='/views/user/userInsert'>유저 등록</button>
	</div>
</body>
</html>