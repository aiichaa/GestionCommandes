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
@Table(name="FACTURES")
public class Facture implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_FACTURE")
	private int numerofacture;
	
	private Date datefacture;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="NUMERO_COMMANDE")
	private Commande commande;

	public int getNumerofacture() {
		return numerofacture;
	}
	public void setNumerofacture(int numerofacture) {
		this.numerofacture = numerofacture;
	}
	public Date getDatefacture() {
		return datefacture;
	}
	public void setDatefacture(Date datefacture) {
		this.datefacture = datefacture;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Date datefacture, double montant) {
		super();
		this.datefacture = datefacture;
		this.montant = montant;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
}
