<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--
 옛날 레이아웃배치
 1.postion
 2.float:left overflow:hidden
 최근 레이아웃배치 ie 10이하에서는 적용 안됨 -> 국가기간홈페이지...
 1.flex
 2.grid

  -->

<style type="text/css">
.root {
	float: right;
	width: 100%; height : 200px; position : relative; /* absolute의 기준 */
	background-color: green;
	overflow: hidden;
	position: relative;
	height: 200px;
}

.suba {
	right: 0; position : absolute;
	height: 100px;
	width: 100px;
	background-color: red;
	position: absolute;
}

.subb {
	position: absolute;
	background-color: blue;
	width: 100px;
	height: 100px;
}
</style>
</head>
<body>
	<div class="root">
		<div class="suba"></div>
		<div class="subb"></div>
	</div>
</body>
</html>