<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Mobile Shop | Photo</title>
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
			Photo <small>List of ${product.productName }</small>
		</h1>
		<ol class="breadcrumb">
			<li><a
				href="${pageContext.request.contextPath }/admin/dashboard"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Photo List</li>
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
						<table id="photoTable" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Photo</th>
									<th>Status</th>
									<th>Main</th>
									<th>Action</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="photo" items="${product.photos }">
									<tr>
										<td>${photo.photoId }</td>
										<td><img
											src="${pageContext.request.contextPath }/uploads/images/${photo.photoName }"
											width="120" /></td>
										<td>${photo.status ? "Show" : "Hide"}</td>
										<td>${photo.main ? "Main" : ""}</td>
										<td><a
											href="${pageContext.request.contextPath }/admin/photo/edit/${product.productId}">
												Edit</a> | <a
											href="${pageContext.request.contextPath }/admin/photo/delete/${photo.photoId }/${photo.product.productId}">
												Delete Photos</a></td>
									</tr>
								</c:forEach>
							</tbody>


							<tfoot>
								<tr>
									<th>Id</th>
									<th>Photo</th>
									<th>Status</th>
									<th>Main</th>
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

	<!-- Add the DataTables library -->
	<script
		src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>

	<!-- Add the DataTables CSS -->
	<link rel="stylesheet"
		href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">

	<!-- Page script -->
	<script>
		$(document).ready(function() {
			$('#photoTable').DataTable({
				'paging' : true,
				'lengthChange' : false,
				'searching' : false,
				'ordering' : true,
				'info' : true,
				'autoWidth' : false,
				'language' : {
					'paginate' : {
						'previous' : 'Previous',
						'next' : 'Next'
					}
				}
			});
		});
	</script>
</body>
</html>
