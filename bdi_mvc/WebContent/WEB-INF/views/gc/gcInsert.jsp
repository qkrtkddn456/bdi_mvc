<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap }">
	<script>
		alert('${rMap.msg}');
		if(${rMap.cnt}==1){
			location.href="/gc/gcList";
		}
	</script>
</c:if>
<body>
	<div class="container">
		<form action="/gc/gcInsert" method="post">
			<table class="table table-bordered table-hover">
					<tr>
						<th>게임명</th>
						<td><input type="text" name="gcName"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="number" name="gcPrice"></td>
					</tr>
					<tr>
						<th>제작사</th>
						<td><input type="text" name="gcVendor"></td>
					</tr>
					<tr>
						<th>순위</th>
						<td><input type="number" name="gcOrder"></td>
					</tr>
					<tr>
						<th>설명</th>
						<td><input type="text" name="gcDesc"></td>
					</tr>
					<tr>
						<th>이미지</th>
						<td><input type="text" name="gcImg"></td>
					</tr>
					<tr>
						<td colspan="2"><button>게임 등록</button></td>
					</tr>
			</table>
		</form>
	</div>
</body>
</html>