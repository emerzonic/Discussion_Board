<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link type="text/css" rel="stylesheet" href="css/style.css"> 
</head>
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