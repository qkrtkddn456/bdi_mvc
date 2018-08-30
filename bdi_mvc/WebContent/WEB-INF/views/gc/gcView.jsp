<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
			<table class="table table-bordered table-hover">
					<tr>
						<th>등록번호</th>
						<td>${gc.gcnum }</td>
					</tr>
					<tr>
						<th>게임명</th>
						<td>${gc.gcname }</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${gc.gcprice }</td>
					</tr>
					<tr>
						<th>제작사</th>
						<td>${gc.gcvendor }</td>
					</tr>
					<tr>
						<th>순위</th>
						<td>${gc.gcorder }</td>
					</tr>
					<tr>
						<th>설명</th>
						<td>${gc.gcdesc }</td>
					</tr>
					<tr>
						<th>이미지</th>
						<td>${gc.gcimg }</td>
					</tr>
					<tr>
					<td colspan="2">
						<form action="/gc/gcDelete" method="post">
							<button data-page="/gc/gcUpdate?gcNum=${gc.gcnum}">수정</button>
							<button>삭제</button>
							<input type="hidden" name="gcNum" value="${gc.gcnum}">
						</form>
					</td>
				</tr>
			</table>
	</div>
</body>
</html>