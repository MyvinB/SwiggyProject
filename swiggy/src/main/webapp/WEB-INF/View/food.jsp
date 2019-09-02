
<!DOCTYPE html>

<html lang="en">
<head>
<title>FoodForLife</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<style>
h1 {
	color: FireBrick;
}

.menu-item {
	height: 200px
}
</style>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
		<a class="navbar-brand" href="#">FoodPanda</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>



			</ul>
			
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron text-center">
			<h1>Eat till you die</h1>
			<p>ORDER FROM PANDA YOU WONT STOP</p>
		</div>
		<div class="row">
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<img src="img/chk.jpg" class="card-img-top menu-item"
						alt="Card image">
					<div class="card-body">
						<h5 class="card-title">CHICKEN</h5>

						<p class="card-text">&#x20b9;180</p>
					</div>
					<div class="card-footer">
						<div class="input-group">
							<span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="minus"
									data-min="1" data-target="font-size">
									<span class="glyphicon glyphicon-minus">-</span>
								</button></span> <input type="text" value="1" class="form-control"
								id="font-size" /> <span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="plus"
									data-max="4" data-target="font-size">
									<span class="glyphicon glyphicon-plus"></span>+
								</button></span>
							<button class="btn btn-primary" value="Pork"
								onclick="AddToCart(this)">AddToCart</button>
						</div>
						<p class="card-text">
							<small class="text-muted">Available Quantity 4</small>
						</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<img src="img/prk.jfif" class="card-img-top menu-item"
						alt="Card image">
					<div class="card-body">
						<h5 class="card-title">Pork</h5>
						<p class="card-text">&#x20b9;29</p>
					</div>
					<div class="card-footer">
						<div class="input-group">
							<span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="minus"
									data-min="1" data-target="font-size">
									<span class="glyphicon glyphicon-minus">-</span>
								</button></span> <input type="text" value="1" class="form-control xyz"
								id="font-size" /> <span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="plus"
									data-max="3" data-target="font-size">
									<span class="glyphicon glyphicon-plus"></span>+
								</button></span>
							<button class="btn btn-primary" value="Pork"
								onclick="AddToCart(this)">Add To Cart</button>
						</div>

						<p class="card-text">
							<small class="text-muted">Available Quantity 3</small>
						</p>
					</div>

				</div>
			</div>
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<img src="img/veg.jpg" class="card-img-top menu-item"
						alt="Card image">
					<div class="card-body">
						<h5 class="card-title">Veg</h5>
						<p class="card-text">&#x20b9;40</p>
					</div>
					<div class="card-footer">
						<div class="input-group">
							<span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="minus"
									data-min="1" data-target="font-size">
									<span class="glyphicon glyphicon-minus">-</span>
								</button></span> <input type="text" value="1" class="form-control xyz"
								id="font-size" /> <span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="plus"
									data-max="2" data-target="font-size">
									<span class="glyphicon glyphicon-plus"></span>+
								</button></span>
							<button class="btn btn-primary" value="Pork"
								onclick="AddToCart(this)">Add To Cart</button>
						</div>

						<p class="card-text">
							<small class="text-muted">Available Quantity 2</small>
						</p>
					</div>

				</div>

			</div>
		</div>
		<div class="row mt-5">
			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<img src="img/pho.jpg" class="card-img-top menu-item"
						alt="Card image">
					<div class="card-body">
						<h5 class="card-title">Poha</h5>
						<p class="card-text">&#x20b9;10</p>
						<div class="input-group">
							<span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="minus"
									data-min="1" data-target="font-size">
									<span class="glyphicon glyphicon-minus">-</span>
								</button></span> <input type="text" value="1" class="form-control xyz"
								id="font-size" /> <span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="plus"
									data-max="2" data-target="font-size">
									<span class="glyphicon glyphicon-plus"></span>+
								</button></span>
							<button class="btn btn-primary" value="Pork"
								onclick="AddToCart(this)">Add To Cart</button>
						</div>

					</div>
					<div class="card-footer">


						<p class="card-text">
							<small class="text-muted">Available Quantity 2</small>
						</p>
					</div>

				</div>
			</div>

			<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<img src="img/paneer.png" class="card-img-top menu-item"
						alt="Card image">
					<div class="card-body">
						<h5 class="card-title">Panner</h5>
						<p class="card-text">&#x20b9;90</p>
						<div class="input-group">
							<span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="minus"
									data-min="1" data-target="font-size">
									<span class="glyphicon glyphicon-minus">-</span>
								</button></span> <input type="text" value="1" class="form-control xyz"
								id="font-size" /> <span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="plus"
									data-max="2" data-target="font-size">
									<span class="glyphicon glyphicon-plus"></span>+
								</button></span>
							<button class="btn btn-primary" value="Pork"
								onclick="AddToCart(this)">Add To Cart</button>
						</div>

					</div>
					<div class="card-footer">


						<p class="card-text">
							<small class="text-muted">Available Quantity 2</small>
						</p>
					</div>

				</div>
			</div>
			
				<div class="col-lg-4 col-md-6 col-sm-12">
				<div class="card">
					<img src="img/cof.jfif" class="card-img-top menu-item"
						alt="Card image">
					<div class="card-body">
						<h5 class="card-title">Coffee</h5>
						<p class="card-text">&#x20b9;60</p>
						<div class="input-group">
							<span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="minus"
									data-min="1" data-target="font-size">
									<span class="glyphicon glyphicon-minus">-</span>
								</button></span> <input type="text" value="1" class="form-control xyz"
								id="font-size" /> <span class="input-group-btn"><button
									class="btn btn-default value-control" data-action="plus"
									data-max="2" data-target="font-size">
									<span class="glyphicon glyphicon-plus"></span>+
								</button></span>
							<button class="btn btn-primary" value="Pork"
								onclick="AddToCart(this)">Add To Cart</button>
						</div>

					</div>
					<div class="card-footer">


						<p class="card-text">
							<small class="text-muted">Available Quantity 2</small>
						</p>
					</div>

				</div>
			</div>
			
		</div>
	</div>



</body>
</html>