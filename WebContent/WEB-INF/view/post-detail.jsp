
<%@ include file="tags.jsp" %>

<!DOCTYPE html>
<html>

<%@ include file="head.jsp" %>
<body>
	
<%@ include file="header.jsp" %>
	
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
						<form:form id="commentForm" class="comment-form" action="addComment" method="POST">
							<div class="form-group">
								<textarea id="comment" class="form-control" id="exampleFormControlTextarea1"
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

<%@ include file="footer.jsp" %>
</body>
</html>