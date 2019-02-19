<style type="text/css">
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
		color: #f8f9fa!important
	}
</style>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="home">Home</a></li>
                    <li class="breadcrumb-item"><a href="category">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="viewProducts">View_Products</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                    <li class="list-group-item"><a href="category.html">Romance/Erotica</a></li>
                    <li class="list-group-item"><a href="category.html">Crime/Mystery</a></li>
                    <li class="list-group-item"><a href="category.html">Religious/Inspirational</a></li>
                    <li class="list-group-item"><a href="category.html">Science Fiction/Fantasy</a></li>
                    <li class="list-group-item"><a href="category.html">Horror</a></li>
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Last product</div>
                <div class="card-body">
                    <img class="img-fluid" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRU1dgGUD9yCeHPBgiFxeeFlKVJbWAfSmOaLwRieeNRaRriiC2P" />
                    <h5 class="card-title">Harry Potter</h5>
                    <p class="card-text">Complete Collection.</p>
                    <p class="bloc_left_price">Rs.1899</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="https://images-na.ssl-images-amazon.com/images/I/51dEuPZMS-L._SX322_BO1,204,203,200_.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product">The Book Thief</a></h4>
                            <p class="card-text">By Markus zusak.</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">Rs.799</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="http://static1.squarespace.com/static/54ef4a93e4b01b969d320540/551d9601e4b09bd0ea364ab9/59d28449d7bdced358ac3328/1548968781839/The+Wild+Book+Cover+-+Online.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product">The Wild Book</a></h4>
                            <p class="card-text">By Juan Villoro.</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">Rs.899</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="https://www.fluentu.com/blog/english/wp-content/uploads/sites/4/2016/03/best-books-to-learn-english14.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product">The Atlantis Gene</a></h4>
                            <p class="card-text">By A.G.Riddle.</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">Rs.999</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="https://cdn.vox-cdn.com/thumbor/pelgbEaddQ4EaYpKP0xCUwOO1So=/0x0:1400x2114/1200x0/filters:focal(0x0:1400x2114):no_upscale()/cdn.vox-cdn.com/uploads/chorus_asset/file/13655926/812eeYQMIpL.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product">Ancestral Night</a></h4>
                            <p class="card-text">Hugo Award Winning Author-Elizabeth Bear.</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">Rs.1299</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT94GFJHbSsxNXVDOLB9-KNC-dAN-RE04ch5QrO-6snaMyMA7w" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product">Star Wars Thrawn</a></h4>
                            <p class="card-text">By Timothi Zahn.</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">Rs.1699</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2r9P-X6uogNigqlSDNtxfbJ1qYSLp57AXKRGdLefOP21dJis3" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product">Paris By The Book</a></h4>
                            <p class="card-text">By Liam Callanan.</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">Rs.699</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active">
                                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

    </div>
</div>