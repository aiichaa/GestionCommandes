package com.ensak.gc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="LIVRAISONS")
public class Livraison implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_LIVRAISON")
	private int numerolivraison;
	
	private Date datelivraison;
	
	@ManyToOne
	@JoinColumn(name="NUMERO_COMMANDE")
	private Commande commande;
	
	public int getNumerolivraison() {
		return numerolivraison;
	}
	public void setNumerolivraison(int numerolivraison) {
		this.numerolivraison = numerolivraison;
	}
	public Date getDatelivraison() {
		return datelivraison;
	}
	public void setDatelivraison(Date datelivraison) {
		this.datelivraison = datelivraison;
	}
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livraison(Date datelivraison) {
		super();
		this.datelivraison = datelivraison;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
	
}
