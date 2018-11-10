
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
						<h3>Edit Comment</h3>
					</div>
					<c:url var="update" value="/comment/update"/>
					<form:form action="${update}" modelAttribute="postcomment" method="POST">
						<form:hidden  name="postId" path="post.id"/>
						<form:hidden  name="commentId" path="comment.id"/>
 						<c:url var="detail" value="/post/detail">
							<c:param name="postId" value="${post.id}"/>
						</c:url> 
						 <div class="form-group">
						    <label for="editPostTextInput">Details</label>
						    <form:textarea class="form-control post-text-input rounded-0" id="editPostTextInput" path="comment.text" value="${comment.text}"/>
						  </div>
						  <a href="${detail}"><button type="button" class="btn btn-secondary btn-lg">Cancel</button></a>
						 <button type="submit" class="submit-button btn btn-lg">Submit Comment</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>