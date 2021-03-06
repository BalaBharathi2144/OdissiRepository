<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
h1 {
	margin-left: 30%;
	width: 100%;
}
</style>
<div class="container">
	<h1>Odissi Receipt</h1>
	<div class="row">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<address>
						<strong>Seller Information</strong><br> <strong>${order.product.supplier.supplier_Name}</strong>
						<br>${order.product.supplier.supplier_Emailid} <br>
						${order.product.supplier.location}<br>
					</address>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6 text-right">
					<p>
						<em>Date:${order.order_Date}</em>
					</p>
					<p>
						<em>Receipt #: ${order.myorder_Id}</em>
					</p>
				</div>
			</div>
			<div class="row">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Qty</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="col-md-10"><em></em>
								<div>
									<img
										src="${cr}/resources/pimages/${order.product.product_Id}.jpg"
										alt="allytees-500-trans.png" width="50" height="50"> <span>${order.product.product_Name}</span>
								</div></td>
							<td class="col-md-1" style="text-align: center">${order.quantity}</td>
							<td class="col-md-1" style="text-align: center">${order.grandTotal} Rs</td>
						</tr>
						<tr>
							<td> </td>
							<td class="col-md-10"><strong>Shipping: </strong></td>
							<td class="col-md-1" style="text-align: center">50 Rs</td>
						</tr>
						<tr>
							<td> </td>
							<td class="text-right"><h4>
									<strong>Total: </strong>
								</h4></td>
							<td class="text-center text-danger"><h4>
									<strong>${order.grandTotal+50} Rs</strong>
								</h4></td>
						</tr>
					</tbody>
				</table>
				<h1>Thank you for your order.</h1>
			</div>
		</div>
	</div>
</div>