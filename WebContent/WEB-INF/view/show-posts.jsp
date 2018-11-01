<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>The Discussion Board</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles.css"/>">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">DB</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="newPost"> Start a Conversation<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Post Analytics</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Profile</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search topics">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Join The Discussion</h1>
    <p class="lead">Spring MVC and Hibernate Web Application.</p>
  </div>
</div>
<div class="container">
	<div class="row">
			<div class="col">
					<div class="content">
						<c:forEach var="post" items="${posts}">
						<c:url var="readMore" value="/post/detail">
							<c:param name="postId" value="${post.id}"/>
						</c:url>
						<c:set var="str" value="${fn:substring(post.text,1,200)}"/>
								<div class="media">
									<div class="media-body">
										<div>
											<h5 class="mt-0 mb-1">${ post.title }</h5>
										</div>
										<div>
											<h5 class="mt-0 mb-1">${ post.author }  ${ post.date }</h5>
										</div>
										<div>
											<p class="post-detail">${str}...</p>
										</div>
											
										<a href="${readMore}"><button type="button" class="btn btn-success">Read More</button></a>
									</div>
								</div>
						</c:forEach>
				</div>
			</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/app.js"/>"
		type="text/javascript"></script>
</body>
</html>