<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/mocom/resources/index.css">
</head>
<body>
	<!--css파일은 webapp 밑에 resources 안에 넣는다. 바꾸고 싶으면 servel-context에서 수정하면 된다.  -->
	<form action="loginchk" method="post">
		<div id="root">
			<div class="container">
				<div class="left_panel">
					<img src="/mocom/resources/images/main.jpg">
				</div>
				<div class="right_panel">
					<div class="right_panel_main">
						<div>
							<h3>로그인</h3>
						</div>
						<div>
							<h5>아이디</h5>
						</div>
						<div>
							<input type="text" name="id">
						</div>
						<div>
							<h5>비밀번호</h5>
						</div>
						<div>
							<input type="text" name="pw">
						</div>
						<div>
							<input type="submit" value="로그인">
						</div>
						<div>${text}</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>