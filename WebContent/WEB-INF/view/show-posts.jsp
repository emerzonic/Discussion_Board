<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>

<h1>Show Posts Page</h1>

<div>
<table >
					<thead>
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Text</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="post" items="${posts}">
						<tr>
							<td>${ post.id }</td>
							<td>${ post.title }</td>
							<td>${ post.text }</td>
							<td>${ post.date }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>



</div>



</body>
</html>