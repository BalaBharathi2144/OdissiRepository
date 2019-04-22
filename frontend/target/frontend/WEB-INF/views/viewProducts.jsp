<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style type="text/css">
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
</style>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">


<div class="container-fluid" style="margin-top: 2%">
	<div class="row">
		<div class="col-2 col-sm-2">
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<li class="list-group-item"><a href="category.html">Romance/Erotica</a></li>
					<li class="list-group-item"><a href="category.html">Crime/Mystery</a></li>
					<li class="list-group-item"><a href="category.html">Religious/Inspirational</a></li>
					<li class="list-group-item"><a href="category.html">Science
							Fiction/Fantasy</a></li>
					<li class="list-group-item"><a href="category.html">Horror</a></li>
				</ul>
			</div>

			<div class="card bg-light mb-3">
				<div class="card-header bg-success text-white text-uppercase">Last
					product</div>
				<div class="card-body">
					<img class="img-fluid"
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRU1dgGUD9yCeHPBgiFxeeFlKVJbWAfSmOaLwRieeNRaRriiC2P"/>
					<h5 class="card-title">Harry Potter</h5>
					<p class="card-text">Complete Collection.</p>
					<p class="bloc_left_price">Rs.1899</p>
				</div>
			</div>
		</div>
		<div class="col-10">
			<div class="row">
				<c:forEach items="${prolist}" var="viewallprod">
					<div class="col-3">

						<div class="card">
							<img class="card-img-top"
								src="resources/pimages/${viewallprod.product_Id}.jpg" width="70"
								height="350" alt="Card image cap">
							<div class="card-body">
								<h4 class="card-title">
									<a href="product.html" title="View Product">${viewallprod.product_Name}</a>
								</h4>
								<div class="row">
								
										<p class="btn btn-info btn-block">Rs.${viewallprod.price}</p>
										<a href="viewOneProduct?proid=${viewallprod.product_Id}" class="btn btn-success btn-block"><p>View Product</p></a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
