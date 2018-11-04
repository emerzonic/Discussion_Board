
<%@ include file="tags.jsp"%>

<!DOCTYPE html>
<html>

<%@ include file="head.jsp"%>
<body>

	<%@ include file="header.jsp"%>

	<!-- MAIN CONTENT STARTS -->
	<div class="container p-lg-5 pb-lg-10">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-sm-12">
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
						<div class="card-header">${post.title}</div>
						<div class="card-body text-info">
							<span class="card-title">By ${post.author}</span> <span>
								posted on ${post.dateString}</span>
							<hr class="mt-0.5">
							<p class="card-text">${post.text}</p>
							<hr>
							<a href="${pageContext.request.contextPath}/post/list"><button
									type="button" class="btn btn-secondary btn-sm px-lg-1">Back
									To Posts</button></a> <a href="${deletePostLink}"><button type="button"
									class="btn btn-danger btn-sm px-lg-5">Delete</button></a> <a
								href="${editPostLink}"><button type="button"
									class="btn btn-warning btn-sm px-lg-5">Edit</button></a>
							<c:set var="commentNumber" value="${fn:length(post.comments)}" />
							<span class="ml-3 mr-1"><i class="fa fa-thumbs-up"
								aria-hidden="true"></i></span><span class="">23</span> <span
								class="ml-3 mr-1"> <i class="fa fa-comments"
								aria-hidden="true"> ${commentNumber} </i> comments
							</span>
						</div>
					</div>
					<div class="mb-3">

						<!--NEW COMMENT FORM BELOW-->
						<form:form id="commentForm" class="comment-form"
							action="addComment" method="POST">
							<input id="postId" type="hidden" name="parentPostId"
								value="${post.id}" />
							<div class="form-group">
								<textarea id="commentInput" name="text"
									class="form-control comment-input rounded-0"
									id="exampleFormControlTextarea1"
									placeholder="Add comment to this post...">
							 </textarea>
							</div>
							<div class="d-flex justify-content-end">
								<button type="button" id="cancelButton"
									class="btn btn-sm cancel-button">CANCEL</button>
								<button type="submit"
									class="btn btn-primary btn-sm submit-button">COMMENT</button>
							</div>

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
								<div class="d-flex">
									<div style="width: 8%;">
										<h3 class="rounded-circle text-center mr-3 p-3"
											style="height: 25%; background: red;">E</h3>
									</div>
									<div class="d-flex flex-column" style="width: 92%;">
										<div class="w-100">
											<span class="mr-2 comment-author">${comment.author}</span> <span
												class="comment-date">${ comment.dateString }</span>
											<hr class="mt-1">
										</div>
										<div class="w-100 d-flex">
											<div style="width: 95%;">
												<p class="comment-text">${comment.text}</p>
											</div>
											<div class="btn-group d-flex align-items-center"
												style="width: 5%;">
												<i class="fa fa-ellipsis-v pl-4" data-toggle="dropdown"
													aria-hidden="true"></i>
												<div class="dropdown-menu">
													<ul class="list-group">
														<li class="list-group-item list-group-item-action"><a
															href="#">Edit</a></li>
														<li class="list-group-item list-group-item-action"><a
															href="#">Delete</a></li>
													</ul>
												</div>
											</div>
										</div>
										<div class="w-100">
											<span class="mr-4"><i class="fa fa-thumbs-up"
												aria-hidden="true"></i></span><span class="">Reply</span>
										</div>
									</div>
								</div>
								<hr>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MAIN CONTENT ENDS -->

	<%@ include file="footer.jsp"%>
</body>
</html>