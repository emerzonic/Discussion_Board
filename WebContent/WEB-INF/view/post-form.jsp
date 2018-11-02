
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
						<h3>New Post Form</h3>
					</div>
					<form:form action="addPost" modelAttribute="post" method="POST">
						<div class="form-group">
						    <label for="exampleInputText">Post Title</label>
						    <form:input type="text" class="form-control" id="exampleInputText" aria-describedby="textHelp" placeholder="Please provide a title for your post" path="title"/>
						    <small id="textHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						</div>
						 <div class="form-group">
						    <label for="exampleFormControlTextarea1">Details</label>
						    <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="6" path="text"/>
						  </div>
						  <a href="${pageContext.request.contextPath}/post/list"><button type="button" class="btn btn-secondary btn-lg">Cancel</button></a>
						 <button type="submit" class="btn btn-primary btn-lg">Submit Post</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>

</body>
</html>