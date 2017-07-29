package com.ensak.gc.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ClientForm {

	@NotEmpty
	@Size(min=2,max=10)
	private String nom;
	
	@NotEmpty
	@Size(min=2,max=10)
	private String prenom;
	
	@NotEmpty
	@Size(min=2,max=30)
	private String adresse;
	
	@NotEmpty
	@Size(min=2,max=10)
	private String telephone;
	
	private String exception;
    	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	
	
	
	
}
