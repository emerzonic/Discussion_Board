<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Discussion Board</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/font-awesome.min.css"/>">
<!-- <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/styles.css"/>">

</head>
<body>
	<div class="header-image card bg-dark text-white text-center">
		<img class="card-img"
			src="<c:url value="/resources/images/header_background.jpg"/>"
			alt="Card image">
		<div class="card-img-overlay d-flex flex-column justify-content-center">
			<h1 class="display-4">The Discussion Board</h1>
			<p class="lead">A place where everyone can express and exchange their views.</p>
			<hr class="my-1 text-primary">
			<a class="btn btn-primary btn-lg w-25 mx-auto" href="post/list" role="button">Join
				The Conversation</a>

		</div>
	</div>
</body>
</html>