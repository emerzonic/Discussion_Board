
<%@ include file="tags.jsp" %>

<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-xl-10 col-lg-10 col-md-10 col-sm-12 mx-auto">
				<div class="content mx-auto border p-5 mb-5 rounded shadow-sm">
					<div class="pb-0 border-bottom">
						<h3>New Post Form</h3>
					</div>
					<div class="new-post-content mt-2">
					<c:url var="add" value="/post/addPost"/>
					<form:form action="${add}" modelAttribute="post" method="POST">
						<div class="form-group">
						    <label for="exampleInputText">Post Title</label>
						    <form:input 
						    	type="text" 
						    	class="form-control post-title-input rounded-0" 
						    	id="postTitleInput" 
						    	aria-describedby="textHelp" 
						    	placeholder="Please provide a title for your post..." 
						    	path="title"/>
						    <small id="textHelp" class="form-text text-muted"></small>
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
						  			class="btn btn-lg cancel-button pl-0 mr-0">Cancel</button></a>
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