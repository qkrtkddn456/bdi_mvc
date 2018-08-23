<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>메이커명</th>
			<td><input type="text" id="mName"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="number" id="mPrice"></td>
		</tr>
		<tr>
			<th>수량</th>
			<td><input type="number" id="mCnt"></td>
		</tr>
		<tr>
			<th>메이커 설명</th>
			<td><textarea id="mDesc"></textarea></td>
		</tr>
		<tr>
			<th colspan="2"><button onclick="insertMaker()">등록</button><button onclick="goPage()">취소</button></th>
		</tr>
	</table>
</div>
<script>
	function insertMaker(){
		var objs = document.querySelectorAll('input');
		var pram = '?';
		for(var i=0; i<objs.length; i++){
			pram += objs[i].id + '=' + objs[i].value + '&';
		}
		objs = document.querySelector('textarea');
		pram += objs[i].id + '=' + objs[i].value + '&';
		location.href='/maker/makerInsert' + pram;
	}
</script>
</body>
</html>