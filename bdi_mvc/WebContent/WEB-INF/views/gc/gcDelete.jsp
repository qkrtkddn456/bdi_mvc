<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap }">
	<script>
		alert('${rMap.msg}');
		if(${rMap.cnt}==1){
			location.href="/gc/gcList";
		}else{
			history.back();
		}
	</script>
</c:if>