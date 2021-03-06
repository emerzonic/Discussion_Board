<!-- 	NAVBAR STARTS -->
<nav id="mainNav" class="navbar navbar-expand-lg navbar-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/discussion-board">DB</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="#">Post
						Analytics</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
			</ul>
		</div>
	</div>
</nav>
<!-- NAVBAR ENDS -->

<!-- HEADER STARTS -->
<div class="jumbotron jumbotron-fluid top-header text-center mx-auto">
	<div class="container p-lg-5">
		<div>
			<h1 class="display-4 pt-5">Join The Discussion</h1>
		</div>
		<div>
			<a href="/discussion-board/post/new"><button
					class="btn btn-success newpost-button 
					my-4" type="button">Start
					a Conversation</button></a>
		</div>

		<div>
			<c:url var="search" value="/post/search"/>
			<form action="${search}"  method="POST">
				<div class="input-group mb-3 px-lg-5 px-xl-5">
					<input type="text" name="searchTerm" class="form-control"
						placeholder="Search topics"
						aria-label="search_terms" aria-describedby="basic-addon2">
					<div class="input-group-append">
						<button type="submit" class="input-group-text" id="basic-addon2"><i class="fa fa-search" aria-hidden="true"></i></button>
					</div>
				</div>

			</form>
		</div>
	</div>
</div>

<!-- HEADER ENDS -->