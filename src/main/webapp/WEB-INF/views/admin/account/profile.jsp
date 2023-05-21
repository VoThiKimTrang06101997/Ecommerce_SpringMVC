<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Mobile Shop | General Form Elements</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1 style="color: red;">
			Admin Profile <small>Preview</small>
		</h1>
		<ol class="breadcrumb">
			<li><a
				href="${pageContext.request.contextPath }/admin/dashboard"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Profile</a></li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<!-- form start -->
					<s:form method="post" modelAttribute="account"
						action="${pageContext.request.contextPath }/admin/account/profile">

						<div class="box-body">
							<div class="form-group">
								<label for="userName">Username</label>
								<s:input path="userName" cssClass="form-control" id="userName"
									required="required" />
							</div>

							<div class="form-group">
								<label for="password">Password</label>
								<s:password path="password" cssClass="form-control"
									id="password" />
							</div>

							<div class="form-group">
								<label for="username">Full Name</label>
								<s:input path="fullName" cssClass="form-control" id="fullName"
									required="required" />
							</div>

							<div class="form-group">
								<label for="address">Address</label>
								<s:input path="address" cssClass="form-control" id="address"
									required="required" />
							</div>

							<div class="form-group">
								<label for="email">Email</label>
								<s:input path="email" type="email" cssClass="form-control"
									id="email" required="required" />
							</div>
							
							<div class="form-group">
								<label for="phone">Phone</label>
								<s:input path="phone" cssClass="form-control"
									id="phone" required="required" />
							</div>


							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Submit</button>
								<s:hidden path="accountId" />
							</div>
						</div>						
					</s:form>
				</div>
			</div>
		</div>
	</section>



	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/demo.js"></script>
</body>
</html>
