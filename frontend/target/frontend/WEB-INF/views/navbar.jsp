<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Gothic+A1|Kaushan+Script|Libre+Baskerville|Lobster');
	.body{
		font-family: 'Gothic A1', sans-serif;
		font-size:16px;
		}
		p{
		color:#6c6c6f;
		font-size:1em;
		}
		h1,h2,h3,h4,h5,h6{color:#323233;text-transform:uppercase;}
	.navbar-brand  span{
		color: #fed136;
		font-size:25px;font-weight:700;letter-spacing:0.1em;
		font-family: 'Kaushan Script','Helvetica Neue',Helvetica,Arial,cursive;
	}
	.navbar-brand {
		color: #2874f0;
		font-size:25px;
		font-family: 'Kaushan Script','Helvetica Neue',Helvetica,Arial,cursive;
		font-weight:700;
		letter-spacing:0.1em;
	}
	.navbar-nav .nav-item .nav-link{
		padding: 0.5em 1em!important;
		font-size: 120%;
		font-weight: 500;
		letter-spacing: 1px;
		color: #E5D431;
	   font-family: 'Gothic A1', sans-serif;
	}
	.navbar-nav .nav-item .nav-link:hover{color:#fed136;}
	.navbar-expand-md .navbar-nav .dropdown-menu{
		border-top:3px solid #fed136;
	}
	.dropdown-item:hover{background-color:#fed136;color:#fff;}
	nav{-webkit-transition: padding-top .3s,padding-bottom .3s;
		-moz-transition: padding-top .3s,padding-bottom .3s;
		transition: padding-top .3s,padding-bottom .3s;
		border: none;
		background-color: #161f23;
		}
	 .shrink {
		padding-top: 0;
		padding-bottom: 0;
		background-color: #212529;
	}
	.banner{
		background-image:url('https://images.unsplash.com/photo-1481627834876-b7833e8f5570?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
		text-align: center;
		color: #fff;
		background-repeat: no-repeat;
		background-attachment: scroll;
		background-position: center center;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
		margin-top:3%;
	}
	.banner-text{
		padding:50px 0 1px 0;
	}
	.banner-heading{
		font-family: 'Lobster', cursive;
		font-size: 75px;
		font-weight: 700;
		line-height: 100px;
		margin-bottom: 5px;
		color:#fff;
	}
	.banner-sub-heading{
		font-family: 'Libre Baskerville', serif;
		font-size: 30px;
		font-weight: 300;
		line-height: 30px;
		margin-bottom: 50px;
		color:#fff;
	}
	.btn-banner{
		padding:5px 20px;
		border-radius:10px;
		font-weight:700;
		line-height:1.5;
		text-align:center;
		color:#fff;
		text-transform:uppercase;
	}
	.text-intro{
		width:90%;
		margin:auto;
		text-align:center;
		padding-top:30px;
	}
	/* mobile view */
	@media (max-width:500px)
	{
		.navbar-nav{
			background-color:#000;
			border-top:3px solid #fed136;
			color:#fff;
			z-index:1;
			margin-top:5px;
			}
		.navbar-nav .nav-item .nav-link{
		padding: 0.7em 1em!important;
		font-size: 100%;
		font-weight: 500;
		}
		.banner-text{
		padding:150px 0 150px 0;
	}
	.banner-heading{
		font-size: 30px;
		line-height: 30px;
		margin-bottom: 20px;
	}
	.banner-sub-heading{
		font-size: 10px;
		font-weight: 200;
		line-height: 10px;
		margin-bottom: 40px;
		}
	}
	@media (max-width:768px){
		.banner-text{
		padding:150px 0 150px 0;
		}
		.banner-sub-heading{
		font-size: 23px;
		font-weight: 200;
		line-height: 23px;
		margin-bottom: 40px;
		}
	}
</style>

<script type="text/js">
	$(document).on("scroll", function(){
		if
      ($(document).scrollTop() > 86){
		  $("#banner").addClass("shrink");
		}
		else
		{
			$("#banner").removeClass("shrink");
		}
	});
</script>
<nav class="navbar navbar-expand-md navbar-dark fixed-top" id="banner">
	<div class="container">
  <!-- Brand -->
  <a class="navbar-brand" href="/"><span>Odissi</span> Online book shop</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="category">Category</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="product">Product</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="viewProducts">View Products</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="supplier">Supplier</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cart">Cart</a>
      </li> 
	   <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        My Account
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Profile</a>
        <a class="dropdown-item" href="#">Change Password</a>
        <a class="dropdown-item" href="#">Logout</a>
      </div>
    </li>
    <li class="nav-item">
    	<a href="signInPage" class="btn btn-warning text-dark btn-banner">Sign In</a>
    </li>
    
    </ul>
  </div>
	</div>
</nav>

<div class="banner">
	<div class="container">
	<div class="banner-text">
	<div class="banner-heading">
	Welcome to the largest online book shopping website in India !
	</div>
	<div class="banner-sub-heading">
	We cook books here everyday, to provide better services to you...
	</div>
	</div>
	</div>
</div>
