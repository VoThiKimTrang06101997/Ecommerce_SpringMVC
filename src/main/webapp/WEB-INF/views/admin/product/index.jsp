<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Mobile Shop | Product</title>
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
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/dist/css/AdminLTE.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/dist/css/skins/_all-skins.min.css">


<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<section class="content-header">
		<h1 style="color: red">
			Product <small>List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/admin/dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Product List</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">

				<c:if test="${error != null }">
					<div class="alert alert-danger alert-dismissable">${error }</div>
				</c:if>

				<div class="box">
					<div class="box-body">
						<table id="categoryList" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Price</th>
									<th>Category</th>
									<th>Status</th>
									<th>Featured</th>
									<th>Action</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="product" items="${products }">
									<tr>
										<td>${product.productId }</td>
										<td>${product.productName}</td>
										<td>${product.price}</td>
										<td>${product.category.name}</td>
										<td>${product.featured ? "featured" : ""}</td>
										<td>${product.status ? 'Show' : 'Hide' }</td>
										<td><a
											href="${pageContext.request.contextPath }/admin/product/edit/${product.productId}">
												Edit</a> | <a
											href="${pageContext.request.contextPath }/admin/product/delete/${product.productId}"
											onclick="return confirm('Are you sure to delete?')">
												Delete</a> 
											| 
											<a
											href="${pageContext.request.contextPath }/admin/photo/product/${product.productId}">
												Photos</a>
											| <a
											href="${pageContext.request.contextPath }/admin/photo/add/${product.productId}">
												Add Photos</a>
											
										</td>
									</tr>
								</c:forEach>
							</tbody>


							<tfoot>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Price</th>
									<th>Category</th>
									<th>Status</th>
									<th>Featured</th>
									<th>Action</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->
				</div>

			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->

	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/demo.js"></script>

	<!-- Add the jQuery library -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<!-- Page script -->
	<script>
		$(function() {
			$('#categoryList').DataTable({
				'paging' : true,
				'lengthChange' : false,
				'searching' : false,
				'ordering' : true,
				'info' : true,
				'autoWidth' : false
			})
		})
	</script>
</body>
</html>
