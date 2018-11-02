
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
<%@ include file="footer.jsp" %>

</body>
</html>