<style type=text/css>
/*
** Style Simple Ecommerce Theme for Bootstrap 4
** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
*/
.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: #007bff;
}

.category_block li:hover a {
	color: #ffffff;
}

.category_block li a {
	color: #343a40;
}

.add_to_cart_block .price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 200%;
	margin-bottom: 0;
}

.add_to_cart_block .price_discounted {
	color: #343a40;
	text-align: center;
	text-decoration: line-through;
	font-size: 140%;
}

.product_rassurance {
	padding: 10px;
	margin-top: 15px;
	background: #ffffff;
	border: 1px solid #6c757d;
	color: #6c757d;
}

.product_rassurance .list-inline {
	margin-bottom: 0;
	text-transform: uppercase;
	text-align: center;
}

.product_rassurance .list-inline li:hover {
	color: #343a40;
}

.reviews_product .fa-star {
	color: gold;
}

.pagination {
	margin-top: 20px;
}

footer {
	background: #343a40;
	padding: 40px;
}

footer a {
	color: #f8f9fa !important
}
</style>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<section class="jumbotron text-center"
	style="margin-top: 10%; margin-bottom: 0%; margin-right: 10%; margin-left: 10%;">
	<div class="container">
		<h1 class="jumbotron-heading">CONTACT US</h1>
		<p class="lead text-muted mb-0">We would love to hear from you !</p>
	</div>
</section>
<!-- <div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Contact Us</li>
                </ol>
            </nav>
        </div>
    </div>
</div> -->
<div class="container"
	style="margin-top: 0%; margin-bottom: 10%; margin-right: 10%; margin-left: 10%;">
	<div class="row">
		<div class="col">
			<div class="card">
				<div class="card-header bg-primary text-white">
					<i class="fa fa-envelope"></i> Contact us.
				</div>
				<div class="card-body">
					<form>
						<div class="form-group">
							<label for="name">Name</label> <input type="text"
								class="form-control" id="name" aria-describedby="emailHelp"
								placeholder="Enter name" required>
						</div>
						<div class="form-group">
							<label for="email">Email address</label> <input type="email"
								class="form-control" id="email" aria-describedby="emailHelp"
								placeholder="Enter email" required> <small
								id="emailHelp" class="form-text text-muted">We'll never
								share your email with anyone else.</small>
						</div>
						<div class="form-group">
							<label for="message">Message</label>
							<textarea class="form-control" id="message" rows="6"
								placeholder="Enter your text here" required></textarea>
						</div>
						<div class="mx-auto">
							<button type="submit" class="btn btn-primary text-right">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-12 col-sm-4">
			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">
					<i class="fa fa-home"></i> Address
				</div>
				<div class="card-body">
					<p>3 Street, Champs Elysees,</p>
					<p>PARIS - 75008</p>
					<p>France</p>
					<p>Email : email@example.com</p>
					<p>Tel. +33 12 56 11 51 84</p>
				</div>

			</div>
			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">
					<i class="fa fa-map"></i> Map
				</div>
				<div class="card-body">
					<div style="width: 100%">
						<iframe width="100%" height="200"
							src="https://maps.google.com/maps?width=100%&amp;height=100%&amp;hl=en&amp;q=champs%20Elysees%2C%20Paris-75008+(Odissi%20Books)&amp;ie=UTF8&amp;t=&amp;z=16&amp;iwloc=B&amp;output=embed"
							frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
							<a href="https://www.maps.ie/map-my-route/">Draw map route</a>
						</iframe>
					</div>
					<br />
				</div>
			</div>
		</div>
	</div>
</div>
