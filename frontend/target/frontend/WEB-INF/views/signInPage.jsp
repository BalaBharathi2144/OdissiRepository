<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
body {
	background-image:
		url('https://wallpaperplay.com/walls/full/c/3/c/330021.jpg');
}
/* sign in FORM */
#logreg-forms {
	width: 412px;
	margin: 10vh auto;
	background-color: #f3f3f3;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
	transition: all 0.3s cubic-bezier(.25, .8, .25, 1);
}

#logreg-forms form {
	width: 100%;
	max-width: 410px;
	padding: 15px;
	margin: auto;
}

#logreg-forms .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

#logreg-forms .form-control:focus {
	z-index: 2;
}

#logreg-forms .form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

#logreg-forms .form-signin input[type="password"] {
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

#logreg-forms .social-login {
	width: 390px;
	margin: 0 auto;
	margin-bottom: 14px;
}

#logreg-forms .social-btn {
	font-weight: 100;
	color: white;
	width: 190px;
	font-size: 0.9rem;
}
/* 		#logreg-forms a{ */
/* 			display: block; */
/* 			padding-top:10px; */
/* 			color:lightseagreen; */
/* 		} */
#logreg-form .lines {
	width: 200px;
	border: 1px solid red;
}

#logreg-forms button[type="submit"] {
	margin-top: 10px;
}

#logreg-forms .facebook-btn {
	background-color: #3C589C;
}

#logreg-forms .google-btn {
	background-color: #DF4B3B;
}

#logreg-forms .form-reset, #logreg-forms .form-signup {
	display: none;
}

#logreg-forms .form-signup .social-btn {
	width: 210px;
}

#logreg-forms .form-signup input {
	margin-bottom: 2px;
}

.form-signup .social-login {
	width: 210px !important;
	margin: 0 auto;
}
/* Mobile */
@media screen and (max-width:500px) {
	#logreg-forms {
		width: 300px;
	}
	#logreg-forms  .social-login {
		width: 200px;
		margin: 0 auto;
		margin-bottom: 10px;
	}
	#logreg-forms  .social-btn {
		font-size: 1.3rem;
		font-weight: 100;
		color: white;
		width: 200px;
		height: 56px;
	}
	#logreg-forms .social-btn:nth-child(1) {
		margin-bottom: 5px;
	}
	#logreg-forms .social-btn span {
		display: none;
	}
	#logreg-forms  .facebook-btn:after {
		content: 'Facebook';
	}
	#logreg-forms  .google-btn:after {
		content: 'Google+';
	}
}
</style>

<script type="text/javascript">
        function toggleResetPswd(e){
		e.preventDefault();
		$('#logreg-forms .form-signin').toggle() // display:block or none
		$('#logreg-forms .form-reset').toggle() // display:block or none
		}
		function toggleSignUp(e){
			e.preventDefault();
			$('#logreg-forms .form-signin').toggle(); // display:block or none
			$('#logreg-forms .form-signup').toggle(); // display:block or none
		}
		$(()=>{
			// Login Register Form
			$('#logreg-forms #forgot_pswd').click(toggleResetPswd);
			$('#logreg-forms #cancel_reset').click(toggleResetPswd);
			$('#logreg-forms #btn-signup').click(toggleSignUp);
			$('#logreg-forms #cancel_signup').click(toggleSignUp);
		})
</script>
<div id="logreg-forms">
	<c:if test="${success}">
		<div class="alert alert-success">
			<strong>Success!</strong>Sign In Successful.
		</div>
	</c:if>
	<c:if test="${error1}">
		<div class="alert alert-danger">
			<strong>Danger!</strong>Incorrect Data.
		</div>
	</c:if>
	<c:if test="${error2}">
		<div class="alert alert-warning">
			<strong>Warning!</strong>Account Already Exists.
		</div>
	</c:if>
	<c:if test="${fail}">
		<div class="alert alert-warning">
			<strong>Failed!</strong>Contact Your Administrator.
		</div>
	</c:if>
	<form class="form-signin">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
			Sign in</h1>
		<input type="email" id="inputEmail" class="form-control"
			placeholder="Email address" required="" autofocus=""> 
			<input type="password" id="inputPassword" class="form-control"
			placeholder="Password" required="">

		<button class="btn btn-success btn-block" type="submit">
			<i class="fas fa-sign-in-alt"></i> Sign in
		</button>
		<a href="#" id="forgot_pswd">Forgot password?</a>
		<hr>
		<!-- <p>Don't have an account!</p>  -->
		<button class="btn btn-primary btn-block" type="button"
			id="btn-signup">
			<i class="fas fa-user-plus"></i> Sign up New Account
		</button>
	</form>

	<form action="/reset/password/" class="form-reset">
		<input type="email" id="resetEmail" class="form-control"
			placeholder="Email address" required="" autofocus="">
		<button class="btn btn-primary btn-block" type="submit">Reset
			Password</button>
		<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i>
			Back</a>
	</form>

	<form:form class="form-signup" method="Post" role="form" modelAttribute="myuser" action="addUser">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
			Sign Up</h1>
		<form:input type="text" id="user-name" class="form-control"
			placeholder="Full name" path="user_Name"/>
		<form:input type="email" id="user-email" class="form-control"
			placeholder="Email address" path="emailid"/>
		<form:input type="text" id="user-phone" class="form-control"
			placeholder="Phone" path="phno"/>
		<form:input type="password" id="user-pass" class="form-control"
			placeholder="Password" path="user_Password"/>
		<form:button class="btn btn-primary btn-block" type="submit">
			<i class="fas fa-user-plus"></i> Sign Up
		</form:button>
		<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
			Back</a>
	</form:form>
	<br>
</div>
<p style="text-align: center">
	<a
		href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
	}
	
	function toggleSignUp(e){
	    e.preventDefault();
	    $('#logreg-forms .form-signin').toggle(); // display:block or none
	    $('#logreg-forms .form-signup').toggle(); // display:block or none
	}
	
	$(()=>{
	    // Login Register Form
	    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
	    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
	    $('#logreg-forms #btn-signup').click(toggleSignUp);
	    $('#logreg-forms #cancel_signup').click(toggleSignUp);
	})g"
		target="_blank" style="color: black"></a>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/script.js"></script>
</p>
