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

<script type="text/js">
    $(document).ready(function(){
        var quantity = 1;
        $('.quantity-right-plus').click(function(e){
            e.preventDefault();
            var quantity = parseInt($('#quantity').val());
            $('#quantity').val(quantity + 1);
        });

        $('.quantity-left-minus').click(function(e){
            e.preventDefault();
            var quantity = parseInt($('#quantity').val());
            if(quantity > 1){
                $('#quantity').val(quantity - 1);
            }
        });
    });
</script>
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Home</a></li>
                    <li class="breadcrumb-item"><a href="category.html">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Product</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <!-- Image -->
        <div class="col-12 col-lg-6">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <a href="" data-toggle="modal" data-target="#productModal">
                        <img class="img-fluid" src="https://dummyimage.com/800x800/55595c/fff" />
                        <p class="text-center">Zoom</p>
                    </a>
                </div>
            </div>
        </div>

        <!-- Add to cart -->
        <div class="col-12 col-lg-6 add_to_cart_block">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <p class="price">99.00 $</p>
                    <p class="price_discounted">149.90 $</p>
                    <form method="get" action="cart.html">
                        <div class="form-group">
                            <label for="colors">Color</label>
                            <select class="custom-select" id="colors">
                                <option selected>Select</option>
                                <option value="1">Blue</option>
                                <option value="2">Red</option>
                                <option value="3">Green</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Quantity :</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                </div>
                                <input type="text" class="form-control"  id="quantity" name="quantity" min="1" max="100" value="1">
                                <div class="input-group-append">
                                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                        <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <a href="cart.html" class="btn btn-success btn-lg btn-block text-uppercase">
                            <i class="fa fa-shopping-cart"></i> Add To Cart
                        </a>
                    </form>
                    <div class="product_rassurance">
                        <ul class="list-inline">
                            <li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br/>Fast delivery</li>
                            <li class="list-inline-item"><i class="fa fa-credit-card fa-2x"></i><br/>Secure payment</li>
                            <li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br/>+33 1 22 54 65 60</li>
                        </ul>
                    </div>
                    <div class="reviews_product p-3 mb-2 ">
                        3 reviews
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        (4/5)
                        <a class="pull-right" href="#reviews">View all reviews</a>
                    </div>
                    <div class="datasheet p-3 mb-2 bg-info text-white">
                        <a href="" class="text-white"><i class="fa fa-file-text"></i> Download DataSheet</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <!-- Description -->
        <div class="col-12">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-align-justify"></i> Description</div>
                <div class="card-body">
                    <p class="card-text">
                        Le Lorem Ipsum est simplement du faux texte employ� dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les ann�es 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour r�aliser un livre sp�cimen de polices de texte. Il n'a pas fait que survivre cinq si�cles, mais s'est aussi adapt� � la bureautique informatique, sans que son contenu n'en soit modifi�. Il a �t� popularis� dans les ann�es 1960 gr�ce � la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus r�cemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.
                    </p>
                    <p class="card-text">
                        Contrairement � une opinion r�pandue, le Lorem Ipsum n'est pas simplement du texte al�atoire. Il trouve ses racines dans une oeuvre de la litt�rature latine classique datant de 45 av. J.-C., le rendant vieux de 2000 ans. Un professeur du Hampden-Sydney College, en Virginie, s'est int�ress� � un des mots latins les plus obscurs, consectetur, extrait d'un passage du Lorem Ipsum, et en �tudiant tous les usages de ce mot dans la litt�rature classique, d�couvrit la source incontestable du Lorem Ipsum. Il provient en fait des sections 1.10.32 et 1.10.33 du "De Finibus Bonorum et Malorum" (Des Supr�mes Biens et des Supr�mes Maux) de Cic�ron. Cet ouvrage, tr�s populaire pendant la Renaissance, est un trait� sur la th�orie de l'�thique. Les premi�res lignes du Lorem Ipsum, "Lorem ipsum dolor sit amet...", proviennent de la section 1.10.32.
                    </p>
                </div>
            </div>
        </div>

        <!-- Reviews -->
        <div class="col-12" id="reviews">
            <div class="card border-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-comment"></i> Reviews</div>
                <div class="card-body">
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2018

                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        <span class="fa fa-star"></span>
                        by Paul Smith
                        <p class="blockquote">
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        </p>
                        <hr>
                    </div>
                    <div class="review">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2018

                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        <span class="fa fa-star" aria-hidden="true"></span>
                        by Paul Smith
                        <p class="blockquote">
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                        </p>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal image -->
<div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="productModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="productModalLabel">Product title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">�</span>
                </button>
            </div>
            <div class="modal-body">
                <img class="img-fluid" src="https://dummyimage.com/1200x1200/55595c/fff" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
