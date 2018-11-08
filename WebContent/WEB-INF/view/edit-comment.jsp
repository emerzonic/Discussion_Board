
<%@ include file="tags.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="content w-75 mx-auto border p-5 mb-5 rounded">
					<div class="border-bottom bg-success p-2">
						<h3>Edit Comment</h3>
					</div>
					<c:url var="update" value="/comment/update"/>
					<form:form action="${update}" modelAttribute="postcomment" method="POST">
						<form:input  name="postId" path="post.id"/>
						<form:input  name="commentId" path="comment.id"/>
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