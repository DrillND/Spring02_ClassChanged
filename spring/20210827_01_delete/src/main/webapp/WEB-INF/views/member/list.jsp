<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 태그라이브러리 forEach문 사용하기 위한 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table, tr {
	border: 1px solid black;
}

td {
	padding: 3px;
}

a {
	background-color: #aaa;
	padding: 3px;
	border-radius: 5px;
	text-decoration: none;
	color: #ddd;
}

a:visited {
	color: #ddd;
}
</style>


<!-- 제이쿼리 라이브러리 가져옴 w3school에서 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$('document').ready(function() {
		/*alert('출력');*/

		//$('update').on('click', function(){ alert('수정누름'); }) /* 업데이트를 클릭했을 때 실행해라 */
		//$('delete').on('click', function(){ alert('삭제누름'); })	
	}); /*문서가 완성이 되면 펑션 안에것 실행 해라  */
</script>

</head>
<body>
	<h1>list</h1>
	<%-- <br> ${aa}
	<br> ${alist}
	<br>

	<c:forEach items="${alist}" var="dto">
	${dto}<br>
	</c:forEach>
	<br> --%>
<!-- 절대 경로 /org5/memberlist  -->
<!--
/org5/memberlist 
<a href='memberupdatefrom'>update</a>
memberupdatefrom -> /org5/memberupdateform
  -->
<div style="margin-bottom: 30px;"><a href="/org5">home</a></div> 
<!-- org5주소 끝에 보면 나오는데 이거는 톰켓서버 들어가보면 루트가 나옴  -->
	<div>
		<table>
			<tr>
				<th>idx</th>
				<th>id</th>
				<th>pw</th>
				<th>age</th>
				<th>gender</th>
				<th>gender</th>
			</tr>
			<c:forEach items="${alist}" var="dto">
				<tr>
					<td>${dto.idx}</td>
					<td>${dto.id}</td>
					<td>${dto.pw}</td>
					<!-- getpw 가 숨겨져 있다.  -->
					<td>${dto.age}</td>
					<td>${dto.gender}</td>
					<!-- jstl 문법 jstl jar 파일에 이미 포함  -->


					<td><a href="memberupdateform?idx=${dto.idx}">수정</a></td>
					<!-- <td><button id="update">수정</button></td> -->
					<td><a href="memberdelete?idx=${dto.idx}">삭제</a></td>
					<!-- <td><button id="delete">삭제</button></td> -->
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>