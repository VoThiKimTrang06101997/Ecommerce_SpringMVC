<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Mobile Shop | Product Edit Form</title>
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
			Edit <small>Product</small>
		</h1>
		<ol class="breadcrumb">
			<li><a
				href="${pageContext.request.contextPath }/admin/dashboard"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Edit Product</a></li>
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
					<s:form method="post" modelAttribute="product"
						action="${pageContext.request.contextPath }/admin/product/edit">

						<div class="box-body">
							<div class="form-group">
								<label for="productName">Name</label>
								<s:input path="productName" cssClass="form-control"
									id="productName" required="required" />
							</div>

							<div class="form-group">
								<label for="price">Price</label>
								<s:input type="number" min="0" path="price"
									cssClass="form-control" id="price" required="required" />
							</div>

							<div class="form-group">
								<label for="quantity">Quantity</label>
								<s:input type="number" min="0" path="quantity"
									cssClass="form-control" id="quantity" required="required" />
							</div>

							<div class="form-group">
								<label for="description">Description</label>
								<s:textarea path="description" cssClass="form-control"
									id="description" required="required" />
							</div>

							<div class="form-group">
								<label for="details">Details</label>
								<s:textarea path="details" cssClass="form-control" id="details"
									required="required" />
							</div>

							<div class="checkbox">
								<label> <s:checkbox path="featured" /> Featured
								</label>
							</div>

							<div class="checkbox">
								<label> <s:checkbox path="status" /> Status
								</label>
							</div>

							<!-- 
							<div class="form-group">
								<label >Select:</label>
								<s:select path="category.categoryId" class="form-control">
									<c:forEach var="category" items="${categories }">
										<optgroup label="${category.name }"></optgroup>
										<c:if test="${category.subcategories.isEmpty() }">
											<c:forEach var="subCategory" items="${category.subcategories}">
												<option value="${subCategory.categoryId }">${subCategory.name }</option>
											</c:forEach>
										</c:if>
									</c:forEach>
								</s:select>
							</div>
							 -->

							<div class="form-group">
								<label>Select:</label> <select class="form-control"
									name="category.categoryId">
									<c:forEach var="category" items="${categories}">
										<optgroup label="${category.indentedName}">
											<c:forEach var="subCategory"
												items="${category.subcategories}">
												<option value="${subCategory.categoryId}"
													${product.category.categoryId ==  subCategory.categoryId ? 'selected="selected"' : ""}>${subCategory.indentedName}</option>
											</c:forEach>
										</optgroup>
									</c:forEach>
								</select>
							</div>



							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Save</button>
								<s:hidden path="productId" />
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
