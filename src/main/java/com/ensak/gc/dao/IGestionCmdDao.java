package com.ensak.gc.dao;

import java.util.List;

import com.ensak.gc.entities.Client;
import com.ensak.gc.entities.Commande;
import com.ensak.gc.entities.Facture;
import com.ensak.gc.entities.Livraison;
import com.ensak.gc.entities.Produits;

public interface IGestionCmdDao {

	public Client addClient(Client c);
	public Produits addProduit(Produits p);
	public Commande addCommande(Commande c);
	public Livraison addLivraison(Livraison l);
	public Facture addFacture(Facture f);
	public void addProduitsToCommande(int numeroProduit, int numeroCommande,int quantite);
	
	public Client consulterClient(int numeroClient);
	public Commande consulterCommande(int numeroCommande);
	public Facture consulterFacture(int numeroFacture);
	public List<Client> consulterClients();
	public List<Commande> cosulterCommandes();
	public List<Produits> consulterProduits();
	public List<Facture> consulterFactures();
	public List<Livraison> consulterLivraison();
	public List<Produits> consulterProduitsOfCommande(int numeroCommande);
	public List<Commande> consulterCommandesOfClient(int numeroClient);
	public List<Facture> consulterFacturesOfCommande(int numeroCommande);
	public List<Livraison> consulterLivraisonsOfCommande(int numeroCommande);
	
	public int consulterQtProduitsCommande(int numeroproduit,int numerocommande);
	
	public Client updateClient(int numeroClient, Client newClient);
	public Produits updateProduit(int numeroProduit, Produits newProduit);
	public Commande updateCommande(int numeroCommande, Commande newCommande);
	public Facture updateFacture(int numeroFacture, Facture newFacture);
	public Livraison updateLivraison(int numeroLivraison, Livraison newLivraison);
	
	public void deleteClient(int numeroClient);
	public void deleteCommande(int numeroCommande);
	public void deleteProduit(int numeroProduit);
	public void deleteFacture(int numeroFacture);
	public void deleteLivraison(int numeroLivraison);
	
	
	
}
