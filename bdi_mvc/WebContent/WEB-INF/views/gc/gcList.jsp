<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div class="container">
		<h4>게임 차트</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>등록번호</th>
					<th>게임명</th>
					<th>가격</th>
					<th>제작사</th>
					<th>순위</th>
					<th>설명</th>
					<th>이미지</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="g">
					<tr>
						<td>${g.gcnum}</td>
						<td><a href="/gc/gcView?gcNum=${g.gcnum}">${g.gcname}</a></td>
						<td>${g.gcprice}</td>
						<td>${g.gcvendor}</td>
						<td>${g.gcorder}</td>
						<td>${g.gcdesc}</td>
						<td>${g.gcimg}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button data-page="/views/gc/gcInsert">부서등록</button>
	</div>
</body>
</html>