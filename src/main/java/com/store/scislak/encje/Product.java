package com.store.scislak.encje;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message="{NotEmpty.Product.name.validation}")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message="{NotEmpty.Product.category.validation}")
	@Column(name="category")
	private String category;
	
	
	@Column(name="netto")
	private double netto;
	
	@Column(name="brutto")
	private double brutto;
	
	@Column(name="vat")
	private int vat;
	
	@Column(name="picture")
	private int picture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getNetto() {
		return netto;
	}

	public void setNetto(double netto) {
		this.netto = netto;
	}

	public double getBrutto() {
		return brutto;
	}

	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public int getPicture() {
		return picture;
	}

	public void setPicture(int picture) {
		this.picture = picture;
	}
}
