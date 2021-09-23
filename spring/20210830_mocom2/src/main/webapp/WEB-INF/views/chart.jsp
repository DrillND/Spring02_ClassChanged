
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/mocom/resources/index.css">
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
svg {
	width: 320px;
	height: 240px;
	border: 1px solid black;
	margin-left: 20px;
}

.bar {
	fill: blue;
}
</style>
</head>
<body>

	<!--
0~1
0.0000000000001*300 = 0 + 1 = 1
0.9999999999999*300 = 300 + 1 = 301


d3.js
csv 파일 가져와서 출력해보기
json 파일 가져와서 출력해보기
mysql 내용 가져와서 그래프로 출력해보기
동그란 그래프 만들기
  -->
	<form action="loginchk" method="post">
		<div>${sessionScope.dto.id}님 환영합니다.</div>
		<div id="root">
			<div class="container">
				<div class="left_panel"
					style="padding-top: 30px; padding-left: 10px;">
					<h1>데이터에 따른 그래프 표시</h1>
					<svg id="myGraph"></svg>
					<div>
						<button type="button" id="testBtn">update</button>
					</div>
					<!-- <script src="/mocom/resources/d3/sample01.js"></script> -->
					<script src="/mocom/resources/d3/sample03.js"></script>
				</div>
				<div class="right_panel">
					<div class="right_panel_main">piechart</div>
				</div>
			</div>

		</div>
	</form>
</body>
</html>