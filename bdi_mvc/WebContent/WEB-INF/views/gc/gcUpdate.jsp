<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
	<script>
		alert('${rMap.msg}');
		if(${rMap.cnt}==1){
			location.href="/gc/gcList";
		}
	</script>
</c:if>
<body>
	<div class="container">
		<form action=/gc/gcUpdate method="post">
			<table class="table table-bordered table-hover">
					<tr>
						<th>등록번호</th>
						<td>${gc.gcnum }</td>
					</tr>
					<tr>
						<th>게임명</th>
						<td><input type="text" name="gcName" value="${gc.gcname }"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="number" name="gcPrice" value="${gc.gcprice }"></td>
					</tr>
					<tr>
						<th>제작사</th>
						<td><input type="text" name="gcVendor" value="${gc.gcvendor }"></td>
					</tr>
					<tr>
						<th>순위</th>
						<td><input type="number" name="gcOrder" value="${gc.gcorder }"></td>
					</tr>
					<tr>
						<th>설명</th>
						<td><input type="text" name="gcDesc" value="${gc.gcdesc }"></td>
					</tr>
					<tr>
						<th>이미지</th>
						<td><input type="text" name="gcImg" value="${gc.gcimg }"></td>
					</tr>
					<tr>
						<td colspan="2"><button>게임 수정</button></td>
					</tr>
			</table>
				<input type="hidden" name="gcNum" value="${gc.gcnum}">
		</form>
	</div>
</body>
</html>