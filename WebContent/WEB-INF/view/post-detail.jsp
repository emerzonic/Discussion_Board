<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Discussion Board</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles.css"/>">
	
</head>
<body>
<!-- 	NAVBAR STARTS -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">DB</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="showPostForm"> Start a Conversation<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Post
						Analytics</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search topics">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<!-- NAVBAR ENDS -->
	
	<!-- HEADER STARTS -->	
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Join The Discussion</h1>
			<p class="lead">Spring MVC and Hibernate Web Application.</p>
		</div>
	</div>
	<!-- HEADER ENDS -->
	
	<!-- MAIN CONTENT STARTS -->
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="content">
					<!-- set up edit link for post -->
					<c:url var="addCommentLink" value="/comment/new">
						<c:param name="postId" value="${post.id}" />
					</c:url>
					<c:url var="editPostLink" value="/post/edit">
						<c:param name="postId" value="${post.id}" />
					</c:url>
					<!-- set up delete link for post -->
					<c:url var="deletePostLink" value="/post/delete">
						<c:param name="postId" value="${post.id}" />
					</c:url>

					<!--POST DETAIL DISPLAYS BELOW-->
					<div class="card border-info mb-3">
						<div class="card-header">Post Detail</div>
						<div class="card-body text-info">
							<h3 class="card-title">${post.title}</h3>
							<span class="card-title">By ${post.author}</span> <span>
								Last Updated: ${post.date}</span>
							<hr>
							<p class="card-text">${post.text}</p>
							<hr>
							<a href="${pageContext.request.contextPath}/post/list"><button
									type="button" class="btn btn-secondary btn-sm">Back To
									Posts</button></a> <a href="${addCommentLink}"><button type="button"
									class="btn btn-primary btn-sm">Add Comment</button></a> <a
								href="${deletePostLink}"><button type="button"
									class="btn btn-danger btn-sm">Delete</button></a> <a
								href="${editPostLink}"><button type="button"
									class="btn btn-warning btn-sm">Edit</button></a>
							<c:set var="commentNumber" value="${fn:length(post.comments)}" />
							<span>${commentNumber}</span>
						</div>
					</div>
					<div>
					
						<!--NEW COMMENT FORM BELOW-->
						<form:form class="comment-form" action="addComment" method="POST">
							<div class="form-group">
								<textarea class="form-control" id="exampleFormControlTextarea1"
									rows="3"></textarea>
							</div>
							<a href="${pageContext.request.contextPath}/post/list"><button
									type="button" class="btn btn-secondary btn-sm">Cancel</button></a>
							<button type="submit" class="btn btn-primary btn-sm">Submit Post</button>
						</form:form>
					</div>
					<div>
					
					<!-- ALL COMMENTS DISPLAY BELOW -->
						<c:set var="comments" value="${post.comments}" />
						<c:if test="${not empty comments}">
							<c:forEach var="comment" items="${comments}">
								<c:url var="readMore" value="/post/detail">
									<c:param name="postId" value="${post.id}" />
								</c:url>
								<div class="media">
									<div class="media-body">
										<div>
											<h5 class="mt-0 mb-1">${comment.author}${ comment.date }</h5>
										</div>
										<div>
											<p class="post-detail">${comment.text}</p>
										</div>
										<hr>
										<a href="${readMore}"><button type="button"
												class="btn btn-success">Read More</button></a>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MAIN CONTENT ENDS -->
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/resources/app.js"/>"
		type="text/javascript"></script>

</body>
</html>