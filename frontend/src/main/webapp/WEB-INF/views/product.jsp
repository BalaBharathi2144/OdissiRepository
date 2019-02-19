<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type=text/css>
/*
** Style Simple Ecommerce Theme for Bootstrap 4
** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
*/
.card {
	margin-top: 10%;
	margin-bottom: 10%;
	margin-right: 10%;
	margin-left: 10%;
}

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
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<div class="container">
	<div class="row">
		<div class="col">
			<div class="card">
				<div class="card-header bg-primary text-white">
					<i class="fa fa-envelope"></i> Add Product.
				</div>
				<c:if test="${success}">
					<div class="alert alert-success">
						<strong>Success!</strong>Data Inserted.
					</div>
				</c:if>
				<c:if test="${error1}">
					<div class="alert alert-danger">
						<strong>Danger!</strong>Incorrect Data.
					</div>
				</c:if>
				<c:if test="${error2}">
					<div class="alert alert-warning">
						<strong>Warning!</strong>Data Already Exists.
					</div>
				</c:if>
				<c:if test="${fail}">
					<div class="alert alert-warning">
						<strong>Failed!</strong>Contact Your Administrator.
					</div>
				</c:if>
				<c:if test="${edit}">
					<c:set var="url" value="updateProduct"></c:set>
				</c:if>
				<c:if test="${!edit}">
					<c:set var="url" value="addProduct"></c:set>
				</c:if>
				<div class="card-body">
					<form:form method="Post" enctype="multipart/form-data" role="form" modelAttribute="myproduct"
						action="${url}">
						<c:if test="${edit}">
							<div class="form-group">
								<label for="name">Id</label>
								<form:input type="text" class="form-control" name="product_Id"
									id="pid" aria-describedby="emailHelp" placeholder="Product Id"
									path="product_Id" readonly="true" />
							</div>
						</c:if>
						<div class="form-group">
							<label for="name">Name</label>
							<form:input type="text" class="form-control" id="name"
								aria-describedby="emailHelp" placeholder="Enter product name"
								path="product_Name" />
							<form:errors path="product_Name" cssStyle="color:Red"></form:errors>
						</div>
						<div class="form-group">
							<label for="message">Description</label>
							<form:textarea class="form-control" id="message" rows="6"
								placeholder="Enter your text here" path="product_Desc"></form:textarea>
							<form:errors path="product_Desc" cssStyle="color:Red"></form:errors>
						</div>
						<div class="form-group">
							<label for="message">Category</label>
							<!-- class="custom-select" -->
							<form:select class="custom-select" id="cid"
								path="product_Category.category_Id">
								<form:option value="0">Select Category</form:option>
								<c:forEach items="${catlist}" var="p">
									<form:option value="${p.category_Id}">${p.category_Name}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group">
							<label for="message">Price</label>
							<form:textarea class="form-control" id="message" rows="6"
								placeholder="Enter your text here" path="price"></form:textarea>
							<form:errors path="price" cssStyle="color:Red"></form:errors>
						</div>
						<div class="form-group">
							<label for="message">Quantity</label>
							<form:textarea class="form-control" id="message" rows="6"
								placeholder="Enter your text here" path="quantity"></form:textarea>
							<form:errors path="quantity" cssStyle="color:Red"></form:errors>
						</div>
						<!-- class="custom-select custom-file-input" -->
						<div class="form-group">
							<label for="message">Product Image</label>
							<form:input type="file" class="form-control custom-select" name="fileToUpload" id="fileToUpload"
								 path="product_Image" required="true"/>
						</div>
						<div class="mx-auto">
							<form:button type="submit" class="btn btn-primary text-right">Submit</form:button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<div class="row" style="margin-bottom: 3%;">
		<div class="table-responsive table-bordered movie-table">
			<table class="table movie-table">
				<thead class="dark-row">
					<tr class="movie-table-head">
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Product Description</th>
						<th>Product Category</th>
						<th>Product Price</th>
						<th>Product Quantity</th>
						<th>Product Image</th>
						<th>Edit/Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${prolist}" var="c">
						<tr>
							<td>${c.product_Id}</td>
							<td>${c.product_Name}</td>
							<td>${c.product_Desc}</td>
							<td>${c.product_Category.category_Name}</td>
							<td>${c.price}</td>
							<td>${c.quantity}</td>
							<td><img src="resources/pimages/${c.product_Id}.jpg" width="50" height="50"/></td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="editProduct?proid=${c.product_Id}"><span
									class="glyphicon glyphicon-edit"></span> Edit</a> <a
								href="deleteProduct?proid=${c.product_Id}"
								class="btn btn-danger btn-xs"> <span
									class="glyphicon glyphicon-remove"></span> Del
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
