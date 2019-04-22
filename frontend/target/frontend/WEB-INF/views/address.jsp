<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
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
</style>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">Billing Address</h1>
		<p class="lead text-muted mb-0">Enter your Address to Deliver or
			Select an Address !</p>
	</div>
</section>
<div class="container">
	<div class="row">
		<div class="col-md-6">
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
				<c:set var="url" value="${cr}/user/updateAddress"></c:set>
			</c:if>
			<c:if test="${!edit}">
				<c:set var="url" value="${cr}/user/addAddress"></c:set>
			</c:if>
			<div class="span8">
				<form:form method="Post" class="form-horizontal" role="form"
					modelAttribute="myaddress" action="${url}">

					<c:if test="${edit}">
						<form:hidden path="address_Id" />
					</c:if>


					<form:hidden path="userdetails.user_id"
						value="${sessionScope.usercartid}" />


					<c:if test="${edit}">
						<div class="control-group">
							<label for="id">Id</label>
							<form:input type="text" class="form-control" name="address_Id"
								id="cid" aria-describedby="emailHelp"
								placeholder="Enter Address Id" path="address_Id" readonly="true" />
						</div>
					</c:if>
					<div class="control-group">
						<label for="email" class="control-label"> Billing E-Mail </label>
						<div class="controls">
							<form:input name="email" type="email" value="" id="email"
								path="billEmailid" />
							<span class="help-inline"> Where should we send invoices?</span>
						</div>
					</div>

					<div class="control-group">
						<label for="email" class="control-label"> Billing Name </label>
						<div class="controls">
							<form:input name="billingName" type="text" value="" id="name"
								path="billName" />
							<span class="help-inline"> Billing Customer Name?</span>
						</div>
					</div>

					<div class="control-group">
						<label for="address" class="control-label"> Street Address
							Line1 </label>
						<div class="controls">
							<form:input name="address" placeholder="W 123 Street" type="text"
								value="" id="address" path="line1" />
							<span class="help-inline"> Street Name and/or apartment
								number</span>
						</div>
					</div>

					<div class="control-group">
						<label for="address" class="control-label"> Street Address
							Line2 </label>
						<div class="controls">
							<form:input name="address" placeholder="Locality" type="text"
								value="" id="address" path="line2" />
							<span class="help-inline"> Address Line2</span>
						</div>
					</div>

					<div class="control-group">
						<label for="zip" class="control-label"> Zip Code </label>
						<div class="controls">
							<form:input name="zip" type="text" placeholder="Pincode"
								path="pincode" />
							<span class="help-inline"> Enter your address pincode</span>
						</div>
					</div>

					<div class="control-group">
						<label for="city" class="control-label"> City </label>
						<div class="controls">
							<form:input name="city" type="text" placeholder="City" id="city"
								path="city" />
							<span class="help-inline"> Enter City</span>
						</div>
					</div>

					<div class="control-group">
						<label for="city" class="control-label"> State </label>
						<div class="controls">
							<form:input name="city" type="text" placeholder="State" id="city"
								path="state" />
							<span class="help-inline"> Enter State</span>
						</div>
					</div>

					<div class="control-group">
						<label for="country" class="control-label"> Country </label>
						<div class="controls">
							<form:select name="country" id="country" path="country">
								<option value=""></option>
								<option value="AR">Argentina</option>
								<option value="AU">Australia</option>
								<option value="AT">Austria</option>
								<option value="BY">Belarus</option>
								<option value="BE">Belgium</option>
								<option value="BA">Bosnia and Herzegovina</option>
								<option value="BR">Brazil</option>
								<option value="BG">Bulgaria</option>
								<option value="CA">Canada</option>
								<option value="CL">Chile</option>
								<option value="CN">China</option>
								<option value="CO">Colombia</option>
								<option value="CR">Costa Rica</option>
								<option value="HR">Croatia</option>
								<option value="CU">Cuba</option>
								<option value="CY">Cyprus</option>
								<option value="CZ">Czech Republic</option>
								<option value="DK">Denmark</option>
								<option value="DO">Dominican Republic</option>
								<option value="EG">Egypt</option>
								<option value="EE">Estonia</option>
								<option value="FI">Finland</option>
								<option value="FR">France</option>
								<option value="GE">Georgia</option>
								<option value="DE">Germany</option>
								<option value="GI">Gibraltar</option>
								<option value="GR">Greece</option>
								<option value="HK">Hong Kong S.A.R., China</option>
								<option value="HU">Hungary</option>
								<option value="IS">Iceland</option>
								<option value="IN">India</option>
								<option value="ID">Indonesia</option>
								<option value="IR">Iran</option>
								<option value="IQ">Iraq</option>
								<option value="IE">Ireland</option>
								<option value="IL">Israel</option>
								<option value="IT">Italy</option>
								<option value="JM">Jamaica</option>
								<option value="JP">Japan</option>
								<option value="KZ">Kazakhstan</option>
								<option value="KW">Kuwait</option>
								<option value="KG">Kyrgyzstan</option>
								<option value="LA">Laos</option>
								<option value="LV">Latvia</option>
								<option value="LB">Lebanon</option>
								<option value="LT">Lithuania</option>
								<option value="LU">Luxembourg</option>
								<option value="MK">Macedonia</option>
								<option value="MY">Malaysia</option>
								<option value="MT">Malta</option>
								<option value="MX">Mexico</option>
								<option value="MD">Moldova</option>
								<option value="MC">Monaco</option>
								<option value="ME">Montenegro</option>
								<option value="MA">Morocco</option>
								<option value="NL">Netherlands</option>
								<option value="NZ">New Zealand</option>
								<option value="NI">Nicaragua</option>
								<option value="KP">North Korea</option>
								<option value="NO">Norway</option>
								<option value="PK">Pakistan</option>
								<option value="PS">Palestinian Territory</option>
								<option value="PE">Peru</option>
								<option value="PH">Philippines</option>
								<option value="PL">Poland</option>
								<option value="PT">Portugal</option>
								<option value="PR">Puerto Rico</option>
								<option value="QA">Qatar</option>
								<option value="RO">Romania</option>
								<option value="RU">Russia</option>
								<option value="SA">Saudi Arabia</option>
								<option value="RS">Serbia</option>
								<option value="SG">Singapore</option>
								<option value="SK">Slovakia</option>
								<option value="SI">Slovenia</option>
								<option value="ZA">South Africa</option>
								<option value="KR">South Korea</option>
								<option value="ES">Spain</option>
								<option value="LK">Sri Lanka</option>
								<option value="SE">Sweden</option>
								<option value="CH">Switzerland</option>
								<option value="TW">Taiwan</option>
								<option value="TH">Thailand</option>
								<option value="TN">Tunisia</option>
								<option value="TR">Turkey</option>
								<option value="UA">Ukraine</option>
								<option value="AE">United Arab Emirates</option>
								<option value="GB">United Kingdom</option>
								<option value="US">USA</option>
								<option value="UZ">Uzbekistan</option>
								<option value="VN">Vietnam</option>
							</form:select>
							<span class="help-inline"> Select Country</span>
						</div>
					</div>
					<br>
					<div class="form-actions">
						<button type="submit" class="btn btn-large btn-primary">Save
							Billing Address</button>
					</div>
				</form:form>
			</div>
		</div>
		<!-- .span8 -->

		<div class="col-md-6">
			<div class="row">
				<c:forEach items="${addlist}" var="a">
					<div class="col-lg-6">
						<div class="thumbnail card">
							<div class="img-event">
								<img class="group list-group-image img-fluid"
									src="http://pngimagesfree.com/house/t/HOUSE-PNG.png"
									alt="Unsupported browser"
									style="max-height: 100px; width: 100%" />
							</div>
							<div class="caption card-body">
								<h5 class="group card-title inner list-group-item-heading">
									${a.billName}</h5>
								<div class="row">
									<div class="col-xs-12">
										<p class="lead">${a.line1}</p>
										<p class="lead">${a.line2}</p>
										<p class="lead">${a.city}</p>
										<p class="lead">${a.state}</p>
										<p class="lead">${a.pincode}</p>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<a class="btn btn-success"
											href="${cr}/user/editAddress?addid=${a.address_Id}"><span
											class="fa fa-edit"> </span></a> <a class="btn btn-success"
											href="${cr}/user/deleteAddress?addid=${a.address_Id}"><span
											class="fa fa-trash-o"> </span></a> <a class="btn btn-success "
											href="${cr}/user/placeorder?addid=${a.address_Id}"><span
											class="fa fa-truck"></span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>