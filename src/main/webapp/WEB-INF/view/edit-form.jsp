
<%@ include file="tags.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>	
<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-xl-10 col-lg-10 col-md-10 col-sm-12 mx-auto border rounded">
				<div class="content p-xl-5 p-lg-5 p-md-4 p-sm-4 p-xs-3">
					<div class="border-bottom ">
						<h3>Edit Post Form</h3>
					</div>
					<c:url var="update" value="/post/update"/>
					<form:form action="${update}" modelAttribute="post" method="POST">
						<form:hidden   path="id"/>
 						<c:url var="detail" value="/post/detail">
							<c:param name="postId" value="${post.id}"/>
						</c:url>
 						<div class="form-group">
						    <label for="editPostTitleInput">Post Title</label>
						    <form:input type="text" class="form-control post-title-input rounded-0" id="editPostTitleInput" aria-describedby="textHelp" path="title" value="${post.title}"/>
<!-- 						    <small id="textHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 -->						</div>
						 <div class="form-group">
						    <label for="editPostTextInput">Details</label>
						    <form:textarea class="form-control post-text-input rounded-0" id="editPostTextInput" path="text" value="${post.text}"/>
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