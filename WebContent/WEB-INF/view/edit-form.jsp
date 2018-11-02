
<%@ include file="tags.jsp" %>

<!DOCTYPE html>
<html>

<%@ include file="head.jsp" %>
<body>
	
<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="content">
					<div>
						<h3>Edit Post Form</h3>
					</div>
					<form:form action="update" modelAttribute="post" method="POST">
						<form:hidden   path="id"/>
 						<c:url var="detail" value="/post/detail">
							<c:param name="postId" value="${post.id}"/>
						</c:url>
 						<div class="form-group">
						    <label for="exampleInputText">Post Title</label>
						    <form:input type="text" class="form-control" id="exampleInputText" aria-describedby="textHelp" path="title" value="${post.title}"/>
						    <small id="textHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						</div>
						 <div class="form-group">
						    <label for="exampleFormControlTextarea1">Details</label>
						    <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="6" path="text" value="${post.text}"/>
						  </div>
						  <a href="${detail}"><button type="button" class="btn btn-secondary btn-lg">Cancel</button></a>
						 <button type="submit" class="btn btn-primary btn-lg">Submit Post</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>

</body>
</html>