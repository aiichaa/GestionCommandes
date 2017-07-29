package com.ensak.gc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CMD_PRD")
public class CommandeProduit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_CMDPRD")
	private int numerocmdprd;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "NUMERO_COMMANDE") 
	private Commande commande;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "NUMERO_PRODUITS") 
	private Produits produit;
	 
	 
	private int quantiteProduit;
	public int getNumerocmdprd() {
		return numerocmdprd;
	}
	public void setNumerocmdprd(int numerocmdprd) {
		this.numerocmdprd = numerocmdprd;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produits getProduit() {
		return produit;
	}
	public void setProduit(Produits produit) {
		this.produit = produit;
	}
	public int getQuantiteProduit() {
		return quantiteProduit;
	}
	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}
	public CommandeProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommandeProduit(Commande commande, Produits produit, int quantiteProduit) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantiteProduit = quantiteProduit;
	}
	
	
	
	
}
