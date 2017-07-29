package com.ensak.gc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDES")
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUMERO_COMMANDE")
	private int numerocommande;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="NUMERO_CLIENT")
	private Client client;
	
	//////////////////////////////////
	@OneToMany(mappedBy="commande")
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
	
	@OneToMany(mappedBy="commande")
	private Collection<Livraison> livraisons;
	
	@OneToMany(mappedBy="commande")
	private Collection<Facture> factures;

		
	
	public int getNumerocommande() {
		return numerocommande;
	}
	public void setNumerocommande(int numerocommande) {
		this.numerocommande = numerocommande;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Date date) {
		super();
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Collection<Livraison> getLivraisons() {
		return livraisons;
	}
	public void setLivraisons(Collection<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	public Collection<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
	
	

}
