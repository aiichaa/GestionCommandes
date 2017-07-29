package com.ensak.gc.models;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.ensak.gc.entities.Client;

public class CommandeForm {

	private Client client;
	
	private List<Integer> numerosproduits;
	
	private List<Integer> quantites;
	
	public List<Integer> getNumerosproduits() {
		return numerosproduits;
	}
	public void setNumerosproduits(List<Integer> numerosproduits) {
		this.numerosproduits = numerosproduits;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Integer> getQuantites() {
		return quantites;
	}
	public void setQuantites(List<Integer> quantites) {
		this.quantites = quantites;
	}
	
	
}
