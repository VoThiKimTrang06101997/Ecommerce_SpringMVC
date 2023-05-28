package com.trang.MobileShop.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "details", nullable = false, length = 65535)
	private String details;

	@Column(name = "status")
	private boolean status;

	@Column(name = "featured")
	private boolean featured;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Photo> photos = new ArrayList<Photo>(0);
}
