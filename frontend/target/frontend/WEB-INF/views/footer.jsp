<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr" value="${pageContext.request.contextPath}" />
<style type="text/css">
body {
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	font-family: 'Source Sans Pro', sans-serif;
	letter-spacing: 0px;
	font-size: 17px;
	color: #6d767a;
	font-weight: 400;
	line-height: 34px;
}

h1, h2, h3, h4, h5, h6 {
	color: #161f23;
	margin: 0px 0px 15px 0px;
	font-family: 'Source Sans Pro', sans-serif;
	font-weight: 700;
}

h1 {
	font-size: 42px;
}

h2 {
	font-size: 32px;
}

h3 {
	font-size: 24px;
}

h4 {
	font-size: 20px;
}

h5 {
	font-size: 14px;
}

h6 {
	font-size: 12px;
}

p {
	margin: 0 0 20px;
	line-height: 1.0;
}

p:last-child {
	margin: 0px;
}

ul, ol {
	
}

a {
	text-decoration: none;
	color: #6d767a;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

a:focus, a:hover {
	text-decoration: none;
	color: #235f83;
}

hr {
	border-top: 1px solid #e4e7e9;
	margin-bottom: 0px;
	margin-top: 10px;
}

.btn {
	font-family: 'Source Sans Pro', sans-serif;
	font-size: 16px;
	text-transform: capitalize;
	font-weight: 700;
	padding: 12px 24px;
	letter-spacing: 0px;
	border-radius: 3px;
	line-height: 1;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	transition: all 0.5s;
	word-wrap: break-word;
	white-space: normal !important;
}

.btn-default {
	background-color: #ff9f2a;
	color: #fff;
	border: 1px solid #ff9f2a;
}

.btn-default:hover {
	background-color: #ec8a13;
	color: #fff;
	border: 1px solid #ec8a13;
}

.btn-default.focus, .btn-default:focus {
	background-color: #ec8a13;
	color: #fff;
	border: 1px solid #ec8a13;
	box-shadow: 0 0 0 0.1rem rgb(236, 138, 19);
}

.form-control {
	border-radius: 0px;
	font-size: 14px;
	font-weight: 700;
	width: 100%;
	height: 64px;
	padding: 16px 20px;
	line-height: 1.42857143;
	border: 1px solid #d6dadc;
	background-color: #fff;
	text-transform: capitalize;
	letter-spacing: 0px;
	margin-bottom: 30px;
	-webkit-box-shadow: inset 0 0px 0px rgba(0, 0, 0, 0);
	box-shadow: inset 0 0px 0px rgba(0, 0, 0, 0);
	-webkit-appearance: none;
	color: #011c28;
}

.form-control:focus {
	color: #011c28;
	outline: 0;
	box-shadow: 0 0 0 0.0rem rgb(255, 255, 255);
	border-color: #c9cdd0;
	background-color: #f0f4f6;
}

.footer {
	background-color: #08202e;
	padding-top: 20px;
	color: #636e74;
	font-weight: 400;
	font-size: 17px;
}

.footer-line {
	border-color: #152e3d;
}

.footer-title {
	font-size: 24px;
	font-weight: 600;
	margin-bottom: 22px;
	color: #fff;
}

.footer-widget ul li a {
	text-transform: capitalize;
	font-size: 17px;
	color: #636e74;
	display: block;
	font-weight: 600;
}

.footer-widget ul li a:hover {
	color: #fff;
}

.newsletter-form {
	padding-top: 5px;
}

.newsletter-form .form-control {
	background-color: #1e2e38;
	border-color: #1e2e38;
}

.newsletter-form .form-control:focus {
	color: #fff;
}

.newsletter-form input::-webkit-input-placeholder {
	color: #fff !important;
}

.newsletter-form input:focus::-webkit-input-placeholder {
	color: #fff !important;
}

.tiny-footer {
	font-size: 14px;
	padding: 4px 0px;
	font-weight: 600;
	background-color: transparent;
	border-top: 1px solid #152e3d;
	color: #888d90;
	line-height: 1;
}
</style>
<footer>
	<!-- footer -->
	<div class="footer">
		<div class="container-fluid">
			<div class="row ">
				<!-- footer-about -->
				<div class="col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ">
					<div class="ft-logo">
						<img
							src="data:image/jpeg;base64,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"
							alt="" style="width: 175px; height: 70px;">
					</div>

				</div>

				<div class="col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ">
					<div class="footer-widget ">
						<div class="footer-title">Company</div>
						<ul class="list-unstyled">
							<li><a href="${cr}/aboutus">About Us</a></li>
							<li><a href="${cr}/contactus">Contact us</a></li>
						</ul>
					</div>

				</div>
				<div class="col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ">
					<div class="footer-widget ">
						<div class="footer-title">Social</div>
						<ul class="list-unstyled">
							<li><a href="${cr}/#">Twitter</a></li>
							<li><a href="${cr}/#">Facebook</a></li>
						</ul>
					</div>
				</div>
				
				<div class="col-xl-3 col-lg-3 col-md-12 col-sm-6 col-6 ">
					<div class="footer-widget ">
						<h3 class="footer-title">Subscribe Newsletter</h3>
						<form>
							<div class="newsletter-form">
								<table>
									<tr>
									<td class="col-9"><input class="form-control"
									placeholder="Enter Your Email address" type="text">
								</td>
										<td class="col-3">
											<button class="btn btn-default btn-sm" type="submit">Go</button>
										</td>
									</tr>
								</table>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="row ">
				<div
					class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 text-center ">
					<div class="tiny-footer">
						<p>
							Copyright © All Rights Reserved 2020 | Template Design &
							Development by <a
								href="https://easetemplate.com/downloads/bitcoin-cryptocurrency-website-template-amazing-design "
								target="_blank" class="copyrightlink">BalaBharathi</a>
						</p>
					</div>
				</div>
				<!-- /. tiny-footer -->
			</div>
		</div>
	</div>
	<!-- /.footer -->
</footer>
