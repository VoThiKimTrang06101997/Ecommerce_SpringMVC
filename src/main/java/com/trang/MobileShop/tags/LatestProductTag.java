package com.trang.MobileShop.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import com.trang.MobileShop.model.Photo;
import com.trang.MobileShop.model.Product;
import com.trang.MobileShop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class LatestProductTag extends RequestContextAwareTag {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductService productService;

	@Override
	protected int doStartTagInternal() throws Exception {
		if (productService == null) {
			WebApplicationContext webApplicationContext = getRequestContext().getWebApplicationContext();
			AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
					.getAutowireCapableBeanFactory();
			autowireCapableBeanFactory.autowireBean(this);
		}
		return SKIP_BODY;
	}

	@Override
	public void doFinally() {
		JspWriter writer = pageContext.getOut();
		try {
			writer.write("<ul id=\"sideManu\" class=\"nav nav-tabs nav-stacked\">");
			List<Product> products = productService.latestProducts(true, 2);
			if (products != null) {				
				for (Product product : products) {
					Photo photo = product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().orElse(null);
					writer.write("<div class=\"thumbnail\">");
					
						writer.write("<img src=\"" + getRequestContext().getContextPath() + "/uploads/images/" + photo.getPhotoName() + "\"/>");

						writer.write("<div class=\"caption\">");
							writer.write("<h5>" + product.getProductName() + "</h5>");
								writer.write("<h4 style=\"text-align: center\">");
									writer.write("<a class=\"btn\" href=\"product_details.html\"> <i\r\n"
											+ "									class=\"icon-zoom-in\"></i></a> ");
									writer.write("	<a class=\"btn\" href=\"#\">Add to <i\r\n"
											+ "									class=\"icon-shopping-cart\"></i></a> ");
									writer.write("<a class=\"btn btn-primary\"\r\n"
											+ "									href=\"#\">$"+ product.getPrice() + "</a>");
								writer.write("</h4>");
							writer.write("</div>");
					writer.write("</div>");
				}
			}

		} catch (Exception e) {
			try {
				writer.write(e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
