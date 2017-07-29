package com.ensak.gc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ensak.gc.entities.Client;
import com.ensak.gc.entities.Commande;
import com.ensak.gc.entities.CommandeProduit;
import com.ensak.gc.entities.Facture;
import com.ensak.gc.entities.Livraison;
import com.ensak.gc.entities.Produits;

public class GestionCmdDaoImpl implements IGestionCmdDao{

	@PersistenceContext
	private EntityManager em;
	private List<Produits> produits;
	
	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Produits addProduit(Produits p) {
		em.persist(p);
		return p;
	}

	@Override
	public Commande addCommande(Commande c) {
       em.persist(c);
		return c;
	}

	@Override
	public Livraison addLivraison(Livraison l) {
		em.persist(l);
		return l;
	}

	@Override
	public Facture addFacture(Facture f) {
		em.persist(f);
		return f;
	}

	@Override
	public void addProduitsToCommande(int numeroProduit, int numeroCommande, int quantite) {
		Produits p = em.find(Produits.class, numeroProduit);
		Commande c = em.find(Commande.class, numeroCommande);
		
		CommandeProduit cp = new CommandeProduit(c,p,quantite);
		
		//p.getCommandeProduit().add(cp);
		//c.getCommandeProduit().add(cp);
		
		em.persist(cp);
		
	}

	@Override
	public Client consulterClient(int numeroClient) {
		Client cl = em.find(Client.class, numeroClient);
		if(cl==null) throw new RuntimeException("Client introuvable");
		return cl;
	}
	
	@Override
	public List<Client> consulterClients() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();	
	}
	
	@Override
	public List<Commande> cosulterCommandes() {
		Query req = em.createQuery("select c from Commande c");
		return req.getResultList();
	}
	
	@Override
	public List<Produits> consulterProduits() {
		Query req = em.createQuery("select p from Produits p");
		return req.getResultList();
	}
	

	@Override
	public Commande consulterCommande(int numeroCommande) {
		Commande cm = em.find(Commande.class, numeroCommande);
		if(cm==null) throw new RuntimeException("Commande introuvable");
		return cm;
	}

	@Override
	public List<Produits> consulterProduitsOfCommande(int numeroCommande) {
		Query req = em.createQuery("select cp from CommandeProduit cp where cp.commande.numerocommande=:X");
		req.setParameter("X", numeroCommande);
		
		//commande produit d'une commande
        List<CommandeProduit> pc = req.getResultList();
        
        List<Produits> produits = new ArrayList<Produits>();
        
        for(int i=0;i<pc.size();i++){
        	Produits p = em.find(Produits.class, pc.get(i).getProduit().getNumeroproduit());
        	produits.add(p);
        }
        
       return produits;
	}

	
	@Override
	public int consulterQtProduitsCommande(int numeroproduit, int numerocommande) {
		Query req = em.createQuery("select cp from CommandeProduit cp where cp.commande.numerocommande=:X");
		req.setParameter("X", numerocommande);
		//commande produit d'une commande
        List<CommandeProduit> pc = req.getResultList();
       
        int quantite = 0;
        
        for(int i=0;i<pc.size();i++){
        	Produits p = em.find(Produits.class, pc.get(i).getProduit().getNumeroproduit());
        	if(p.getNumeroproduit()==numeroproduit){
        		quantite = p.getQuantite();
        	}
        }
        
       return quantite;
	}
	
	@Override
	public List<Commande> consulterCommandesOfClient(int numeroClient) {
		Query req = em.createQuery("select c from Commande c where c.client.numeroclient=:X");
		req.setParameter("X", numeroClient); //qlq soit la position du mot cle
		return req.getResultList();
	}

	@Override
	public List<Facture> consulterFacturesOfCommande(int numeroCommande) {
		Query req = em.createQuery("select f from Facture f where f.commande.numerocommande=:X");
		req.setParameter("X", numeroCommande); //qlq soit la position du mot cle
		return req.getResultList();
	}

	@Override
	public List<Livraison> consulterLivraisonsOfCommande(int numeroCommande) {
		Query req = em.createQuery("select l from Livraison l where l.commande.numerocommande=:X");
		req.setParameter("X", numeroCommande); //qlq soit la position du mot cle
		return req.getResultList();
	}

	@Override
	public Client updateClient(int numeroClient, Client newClient) {
		Client oldClient = em.find(Client.class, numeroClient);
		if(oldClient!=null){
			oldClient.setNom(newClient.getNom());
			oldClient.setPrenom(newClient.getPrenom());
			oldClient.setAdresse(newClient.getAdresse());
			oldClient.setTelephone(newClient.getTelephone());
			return oldClient;
		}
		else{
			System.out.println("old client not found");
			return null;
		}
		
	}

	@Override
	public Produits updateProduit(int numeroProduit, Produits newProduits) {
		Produits oldProduits = em.find(Produits.class, numeroProduit);
		if(oldProduits!=null){
			oldProduits.setNomproduit(newProduits.getNomproduit());
			oldProduits.setPrix(newProduits.getPrix());
			oldProduits.setQuantite(newProduits.getQuantite());
			return oldProduits;
		}else{
			System.out.println("old produit not found");
			return null;
		}
	}

	@Override
	public Commande updateCommande(int numeroCommande, Commande newCommande) {
		Commande oldcmd = em.find(Commande.class, numeroCommande);
		if(oldcmd!=null){
			oldcmd.setDate(newCommande.getDate());
			return oldcmd;
		}else{
			System.out.println("old commande not found");
			return null;
		}
	}

	@Override
	public Facture updateFacture(int numeroFacture, Facture newFacture) {
		Facture oldFacture = em.find(Facture.class, numeroFacture);
		if(oldFacture!=null){
			oldFacture.setDatefacture(newFacture.getDatefacture());
			oldFacture.setMontant(newFacture.getMontant());
			return oldFacture;
		}else{
			System.out.println("old facture not found");
			return null;
		}
	}

	@Override
	public Livraison updateLivraison(int numeroLivraison, Livraison newLivraison) {
		Livraison oldLivraison = em.find(Livraison.class, numeroLivraison);
		if(oldLivraison!=null){
			oldLivraison.setDatelivraison(newLivraison.getDatelivraison());
			return oldLivraison;
		}else{
			System.out.println("old livraison not found");
			return null;
		}
	}

	@Override
	public void deleteClient(int numeroClient) {
		Client c = em.find(Client.class, numeroClient);
		em.remove(c);
		
	}

	@Override
	public void deleteCommande(int numeroCommande) {
		Commande c = em.find(Commande.class, numeroCommande);
		em.remove(c);
		
	}

	@Override
	public void deleteFacture(int numeroFacture) {
		Facture f = em.find(Facture.class, numeroFacture);
		em.remove(f);
		
	}

	@Override
	public void deleteLivraison(int numeroLivraison) {
		Livraison l = em.find(Livraison.class, numeroLivraison);
		em.remove(l);
	
		
	}

	@Override
	public void deleteProduit(int numeroProduit) {
		Produits p = em.find(Produits.class, numeroProduit);
		em.remove(p);
		
	}

	@Override
	public List<Facture> consulterFactures() {
		Query req = em.createQuery("select f from Facture f");
		return req.getResultList();	
	}

	@Override
	public List<Livraison> consulterLivraison() {
		Query req = em.createQuery("select l from Livraison l");
		return req.getResultList();	
	}

	@Override
	public Facture consulterFacture(int numeroFacture) {
		Facture f = em.find(Facture.class, numeroFacture);
		if(f==null) throw new RuntimeException("Facture introuvable");
		return f;
	}

	

	

	

	

}
