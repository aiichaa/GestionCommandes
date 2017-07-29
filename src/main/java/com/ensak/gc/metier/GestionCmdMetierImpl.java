package com.ensak.gc.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ensak.gc.dao.IGestionCmdDao;
import com.ensak.gc.entities.Client;
import com.ensak.gc.entities.Commande;
import com.ensak.gc.entities.Facture;
import com.ensak.gc.entities.Livraison;
import com.ensak.gc.entities.Produits;

@Transactional
public class GestionCmdMetierImpl implements IGestionCmdMetier{

	private IGestionCmdDao dao;
	
	public void setDao(IGestionCmdDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

	@Override
	public Produits addProduit(Produits p) {
		// TODO Auto-generated method stub
		return dao.addProduit(p);
	}

	@Override
	public Commande addCommande(Commande c) {
		// TODO Auto-generated method stub
		return dao.addCommande(c);
	}

	@Override
	public Livraison addLivraison(Livraison l) {
		// TODO Auto-generated method stub
		return dao.addLivraison(l);
	}

	@Override
	public Facture addFacture(Facture f) {
		// TODO Auto-generated method stub
		return dao.addFacture(f);
	}

	@Override
	public void addProduitsToCommande(int numeroProduit, int numeroCommande,int quantite) {
		dao.addProduitsToCommande(numeroProduit, numeroCommande, quantite);
		
	}

	@Override
	public Client consulterClient(int numeroClient) {
		// TODO Auto-generated method stub
		return dao.consulterClient(numeroClient);
	}

	@Override
	public Commande consulterCommande(int numeroCommande) {
		// TODO Auto-generated method stub
		return dao.consulterCommande(numeroCommande);
	}

	@Override
	public List<Client> consulterClients() {
		// TODO Auto-generated method stub
		return dao.consulterClients();
	}
	
	@Override
	public List<Commande> consulterCommandes() {
		// TODO Auto-generated method stub
		return dao.cosulterCommandes();
	}
	
	@Override
	public List<Produits> consulterProduits() {
		// TODO Auto-generated method stub
		return dao.consulterProduits();
	}

	@Override
	public List<Produits> consulterProduitsOfCommande(int numeroCommande) {
		// TODO Auto-generated method stub
		return dao.consulterProduitsOfCommande(numeroCommande);
	}

	@Override
	public List<Commande> consulterCommandesOfClient(int numeroClient) {
		// TODO Auto-generated method stub
		return dao.consulterCommandesOfClient(numeroClient);
	}

	@Override
	public List<Facture> consulterFacturesOfCommande(int numeroCommande) {
		// TODO Auto-generated method stub
		return dao.consulterFacturesOfCommande(numeroCommande);
	}

	@Override
	public List<Livraison> consulterLivraisonsOfCommande(int numeroCommande) {
		// TODO Auto-generated method stub
		return dao.consulterLivraisonsOfCommande(numeroCommande);
	}

	@Override
	public Client updateClient(int numeroClient, Client newClient) {
		// TODO Auto-generated method stub
		return dao.updateClient(numeroClient, newClient);
	}

	@Override
	public Produits updateProduit(int numeroProduit, Produits newProduit) {
		// TODO Auto-generated method stub
		return dao.updateProduit(numeroProduit, newProduit);
	}

	@Override
	public Commande updateCommande(int numeroCommande, Commande newCommande) {
		// TODO Auto-generated method stub
		return dao.updateCommande(numeroCommande, newCommande);
	}

	@Override
	public Facture updateFacture(int numeroFacture, Facture newFacture) {
		// TODO Auto-generated method stub
		return dao.updateFacture(numeroFacture, newFacture);
	}

	@Override
	public Livraison updateLivraison(int numeroLivraison, Livraison newLivraison) {
		// TODO Auto-generated method stub
		return dao.updateLivraison(numeroLivraison, newLivraison);
	}

	@Override
	public void deleteClient(int numeroClient) {
		dao.deleteClient(numeroClient);
		
	}

	@Override
	public void deleteCommande(int numeroCommande) {
		dao.deleteCommande(numeroCommande);
		
	}

	@Override
	public void deleteFacture(int numeroFacture) {
		dao.deleteFacture(numeroFacture);
		
	}

	@Override
	public void deleteLivraison(int numeroLivraison) {
		dao.deleteLivraison(numeroLivraison);
		
	}

	@Override
	public void deleteProduit(int numeroProduit) {
		dao.deleteProduit(numeroProduit);
		
	}

	@Override
	public int consulterQtProduitsCommande(int numeroproduit, int numerocommande) {
		// TODO Auto-generated method stub
		return dao.consulterQtProduitsCommande(numeroproduit, numerocommande);
	}

	@Override
	public List<Facture> consulterFactures() {
		// TODO Auto-generated method stub
		return dao.consulterFactures();
	}

	@Override
	public List<Livraison> consulterLivraisons() {
		// TODO Auto-generated method stub
		return dao.consulterLivraison();
	}

	@Override
	public Facture consulterFacture(int numeroFacture) {
		// TODO Auto-generated method stub
		return dao.consulterFacture(numeroFacture);
	}

	

	

	
}
