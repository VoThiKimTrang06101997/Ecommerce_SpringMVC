package com.trang.MobileShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_id")
	private int photoId;

	@Column(name = "photo_name")
	private String photoName;

	@Column(name = "status")
	private boolean status;

	@Column(name = "main")
	private boolean main;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

}
