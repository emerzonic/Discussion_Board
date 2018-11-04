
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
					<div class="new-post-content">
					<hr>
					<form:form action="addPost" modelAttribute="post" method="POST">
						<div class="form-group">
						    <label for="exampleInputText">Post Title</label>
						    <form:input 
						    	type="text" 
						    	class="form-control post-title-input rounded-0" 
						    	id="postTitleInput" 
						    	aria-describedby="textHelp" 
						    	placeholder="Please provide a title for your post..." 
						    	path="title"/>
						    <small id="textHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						</div>
						 <div class="form-group">
						    <label for="exampleFormControlTextarea1">Details</label>
						    <form:textarea 
						    	class="form-control post-text-input rounded-0" 
						    	id="postTextInput" path="text" 
						    	placeholder="Enter post detail here..."/>
						  </div>
						 	<a href="${pageContext.request.contextPath}/post/list">
						  	<button type="button" 
						  			class="btn btn-lg cancel-button">Cancel</button></a>
						 <button type="submit" class="btn btn-primary btn-lg">Submit Post</button>
					</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>

</body>
</html>