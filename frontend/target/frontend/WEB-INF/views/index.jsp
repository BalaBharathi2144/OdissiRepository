<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<meta name="viewport" content="width=device-width, intial-scale=1.0">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	
	<div style="min-height: 400px">
		<c:if test="${carousel}">
		<jsp:include page="carousel.jsp" />
		</c:if>
		<c:if test="${home}">
		<jsp:include page="carousel.jsp" />
		</c:if>
		<c:if test="${user}">
		<jsp:include page="signInPage.jsp" />
		</c:if>
		<c:if test="${aboutUs}">
			<jsp:include page="aboutUs.jsp" />
		</c:if>
		<c:if test="${contactUs}">
			<jsp:include page="contactUs.jsp" />
		</c:if>
		<c:if test="${category}">
			<jsp:include page="category.jsp" />
		</c:if>
		<c:if test="${product}">
			<jsp:include page="product.jsp" />
		</c:if>
		<c:if test="${viewProducts}">
			<jsp:include page="viewProducts.jsp" />
		</c:if>
		<c:if test="${supplier}">
			<jsp:include page="supplier.jsp" />
		</c:if>
		<c:if test="${cart}">
			<jsp:include page="cart.jsp" />
		</c:if>
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>
