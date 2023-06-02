<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="pagedListHolder" scope="request"
	class="org.springframework.beans.support.PagedListHolder" />

<spring:url value="/product/category/${category.categoryId}"
	var="pageLink">
	<spring:param name="p" value="~" />
</spring:url>


<div class="span9">
	<ul class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/home">Home</a> <span
			class="divider">/</span></li>
		<li class="active">${category.name}</li>
	</ul>

	<h3>
		${category.name} <small class="pull-right">
			${category.products.size()} products are available </small>
	</h3>

	<hr class="soft" />
	<c:forEach var="product" items="${category.products}">
		<p>${product.description}.</p>
	</c:forEach>


	<hr class="soft" />
	<form class="form-horizontal span6">
		<div class="control-group">
			<label class="control-label alignL">Sort By </label> <select>
				<option>Product name A - Z</option>
				<option>Product name Z - A</option>
				<option>Product Stoke</option>
				<option>Price Lowest first</option>
			</select>
		</div>
	</form>

	<div id="myTab" class="pull-right">
		<a href="#listView" data-toggle="tab"><span class="btn btn-large"><i
				class="icon-list"></i></span></a> <a href="#blockView" data-toggle="tab"><span
			class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
	</div>
	<br class="clr" />
	<div class="tab-content">
		<div class="tab-pane" id="listView">
			<c:forEach var="product" items="${pagedListHolder.pageList }">
				<c:set var="photo"
					value="${product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().orElse(null)}"></c:set>


				<div class="row">
					<div class="span2">
						<img
							src="${pageContext.request.contextPath}/uploads/images/${product.photos[0].photoName}"
							alt="" />
					</div>
					<div class="span4">
						<h3>New | Available</h3>
						<hr class="soft" />
						<h5>${product.productName}</h5>
						<p>${product.description}</p>
						<a class="btn btn-small pull-right"
							href="${pageContext.request.contextPath}/product/details/${product.productId}">View
							Details</a> <br class="clr" />
					</div>
					<div class="span3 alignR">
						<form class="form-horizontal qtyFrm">
							<h3>$ ${product.price}</h3>
							<label class="checkbox"> <input type="checkbox">
								Adds product to compare
							</label><br /> <a href="product_details.html"
								class="btn btn-large btn-primary"> Add to <i
								class=" icon-shopping-cart"></i></a> <a
								href="${pageContext.request.contextPath}/product/details/${product.productId}"
								class="btn btn-large"><i class="icon-zoom-in"></i></a>
						</form>
					</div>
				</div>
				<hr class="soft" />
			</c:forEach>

		</div>

		<div class="tab-pane active" id="blockView">
			<ul class="thumbnails">
				<c:set var="photo"
					value="${product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().orElse(null)}"></c:set>

				<c:forEach var="product" items="${pagedListHolder.pageList}">
					<li class="span3">
						<div class="thumbnail">
							<a
								href="${pageContext.request.contextPath}/product/details/${product.productId}"
								title="${product.productName}"> <img
								src="${pageContext.request.contextPath}/uploads/images/${product.photos[0].photoName}"
								style="width: 100%" />
							</a>

							<div class="caption">
								<h5>${product.productName}</h5>
								<p>${product.description}</p>
								<h4 style="text-align: center">
									<a class="btn"
										href="${pageContext.request.contextPath}/product/details/${product.productId}">
										<i class="icon-zoom-in"></i>
									</a> <a class="btn" href="#"> Add to <i
										class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
										href="#"> $ ${product.price}</a>
								</h4>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<hr class="soft" />
		</div>

	</div>
</div>

<a href="compair.html" class="btn btn-large pull-right">Compare
	Product</a>

<div class="pagination">
	<spring:eval var="pageCount"
		expression="pagedListHolder.getPageCount()" />
	<c:choose>
		<c:when test="${pageCount <= 2}">
			<c:forEach var="pageNumber" begin="1" end="${pageCount}">
				<spring:url value="/product/category/${category.categoryId}"
					var="pageLink">
					<spring:param name="p" value="${pageNumber}" />
				</spring:url>
				<c:if test="${pageNumber == pagedListHolder.page + 1}">
					<span class="current-page">${pageNumber}</span>
				</c:if>
				<c:if test="${pageNumber != pagedListHolder.page + 1}">
					<a href="${pageLink}">${pageNumber}</a>
				</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:set var="currentPage" value="${pagedListHolder.page + 1}" />
			<c:if test="${currentPage == 1}">
				<span class="current-page">${currentPage}</span>
				<a href="/product/category/${category.categoryId}?p=2">2</a>
			</c:if>
			<c:if test="${currentPage == pageCount}">
				<a
					href="/product/category/${category.categoryId}?p=${currentPage - 1}">${currentPage - 1}</a>
				<span class="current-page">${currentPage}</span>
			</c:if>
			<c:if test="${currentPage != 1 && currentPage != pageCount}">
				<a
					href="/product/category/${category.categoryId}?p=${currentPage - 1}">${currentPage - 1}</a>
				<span class="current-page">${currentPage}</span>
				<a
					href="/product/category/${category.categoryId}?p=${currentPage + 1}">${currentPage + 1}</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>


<br class="clr" />
</div>
</div>
</div>
</div>