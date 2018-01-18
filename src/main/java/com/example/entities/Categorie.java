package com.example.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="CATEGORIE")
@Entity
@SuppressWarnings("serial")
public class Categorie implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="NOMCATEGORIE")
	private String nomCatgorie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomCatgorie() {
		return nomCatgorie;
	}

	public void setNomCatgorie(String nomCatgorie) {
		this.nomCatgorie = nomCatgorie;
	}

	public Categorie(String nomCatgorie) {
		super();
		this.nomCatgorie = nomCatgorie;
	}

	public Categorie() {
		super();
	}

}