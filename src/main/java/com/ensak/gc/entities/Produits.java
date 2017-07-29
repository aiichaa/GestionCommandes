package com.ensak.gc.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PRODUITS")
public class Produits implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_PRODUITS")
	private int numeroproduit;
	
	private String nomproduit;
	private int quantite;
	private double prix;
	
//////////////////////////////////
 @OneToMany(mappedBy="produit")
private Collection<CommandeProduit> commandeProduit;

public Collection<CommandeProduit> getCommandeProduit() {
return commandeProduit;
}

public void setCommandeProduit(Collection<CommandeProduit> commandeProduit) {
this.commandeProduit = commandeProduit;
}

public void addCommandeProduit(CommandeProduit commandeProduit){
this.commandeProduit.add(commandeProduit);
}
//////////////////////////////////
	
	public int getNumeroproduit() {
		return numeroproduit;
	}
	public void setNumeroproduit(int numeroproduit) {
		this.numeroproduit = numeroproduit;
	}
	public String getNomproduit() {
		return nomproduit;
	}
	public void setNomproduit(String nomproduit) {
		this.nomproduit = nomproduit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produits(String nomproduit, int quantite, double prix) {
		super();
		this.nomproduit = nomproduit;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	
}
