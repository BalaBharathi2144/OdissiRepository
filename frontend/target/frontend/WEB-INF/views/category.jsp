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
}</style>
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
					<i class="fa fa-envelope"></i> Add Category.
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
					<c:set var="url" value="updateCategory"></c:set>
				</c:if>
				<c:if test="${!edit}">
					<c:set var="url" value="addCategory"></c:set>
				</c:if>

				<div class="card-body">
					<form:form method="Post" role="form" modelAttribute="mycategory"
						action="${url}">
						<c:if test="${edit}">
							<div class="form-group">
								<label for="name">Id</label>
								<form:input type="text" class="form-control" name="category_Id"
									id="cid" aria-describedby="emailHelp" placeholder="Enter Category Id"
									path="category_Id" readonly="true" />
							</div>
						</c:if>
						<div class="form-group">
							<label for="name">Name</label>
							<form:input type="text" class="form-control" id="name"
								aria-describedby="emailHelp" placeholder="Enter category name"
								path="category_Name" />
							<form:errors path="category_Name" cssStyle="color:Red"></form:errors>
						</div>
						<div class="form-group">
							<label for="message">Description</label>
							<form:textarea class="form-control" id="message" rows="6"
								placeholder="Enter your text here" path="category_Desc"></form:textarea>
							<form:errors path="category_Desc" cssStyle="color:Red"></form:errors>
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
						<th>Category Id</th>
						<th>Category Name</th>
						<th>Category Description</th>
						<th>Edit/Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${catlist}" var="c">
						<tr>
							<td>${c.category_Id}</td>
							<td>${c.category_Name}</td>
							<td>${c.category_Desc}</td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="editCategory?catid=${c.category_Id}"><span
									class="glyphicon glyphicon-edit"></span> Edit</a> <a
								href="deleteCategory?catid=${c.category_Id}"
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
