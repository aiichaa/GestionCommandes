package com.ensak.gc.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensak.gc.entities.Client;
import com.ensak.gc.entities.Commande;
import com.ensak.gc.entities.Facture;
import com.ensak.gc.entities.Livraison;
import com.ensak.gc.entities.Produits;
import com.ensak.gc.metier.IGestionCmdMetier;
import com.ensak.gc.models.ClientForm;
import com.ensak.gc.models.CommandeForm;
import com.ensak.gc.models.ProduitForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IGestionCmdMetier metier;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	/*
	 ***************** Clients ***************
	 */
	
	@RequestMapping(value = "/clients")
	public String clients(Model model){
		
		List<Client> clients = metier.consulterClients();
		
		model.addAttribute("clients",clients);
		return "clients";	
	}
	
	@RequestMapping(value = "/ajouterClient")
	public String ajouterClient(@Valid ClientForm cf,BindingResult bindingResult,Model model){
		
		//validation du formulaire
				if(bindingResult.hasErrors()){
					//si erreur je retourne vers la vue
					return "ajouterClient";
				}

				try{
					  Client cl = new Client(cf.getNom(),cf.getPrenom(),cf.getAdresse(),cf.getTelephone());
					  metier.addClient(cl); 
					  return "redirect:/clients";
					  	
				}catch (Exception e) {
					cf.setException(e.getMessage());
				}
					  
				
		model.addAttribute("clientForm", cf);
	   			
		return "ajouterClient";	
	}
	
	@RequestMapping(value ="/consulterClient/{numeroclient}")
	public String afficherClient(Model model,@PathVariable int numeroclient){
		
		Client client = metier.consulterClient(numeroclient);
		model.addAttribute("client",client);
		
		List<Commande> commandes = metier.consulterCommandesOfClient(numeroclient);
		if(!commandes.isEmpty()){
			model.addAttribute("commandes",commandes);
		}
		
		
		return "consulterClient";
		
	}
	
	@RequestMapping(value ="/supprimerClient/{numeroclient}")
	public String supprimerClient(Model model,@PathVariable int numeroclient){	
		metier.deleteClient(numeroclient);
		return "redirect:/clients";
		
	}
	
	@RequestMapping(value ="/modifierClient/{numeroclient}")
	public String modifierClient(@Valid ClientForm cf,BindingResult bindingResult,Model model,@PathVariable int numeroclient){
		
		Client client = metier.consulterClient(numeroclient);
		model.addAttribute("client",client);
		
		model.addAttribute("clientForm", cf);
		
		//validation du formulaire
		if(bindingResult.hasErrors()){
			//si erreur je retourne vers la vue
			return "modifierClient";
		}

		
		try{
				 Client cl = new Client(cf.getNom(),cf.getPrenom(),cf.getAdresse(),cf.getTelephone());
				  metier.updateClient(numeroclient, cl);
					logger.info("le nom : " + cf.getNom());
				  return "redirect:/clients";	
			   	
		}catch (Exception e) {
			cf.setException(e.getMessage());
		}
			  
		return "modifierClient";
		
	}
	
	
	/*
	 ***************** Commandes ***************
	 */
	
	@RequestMapping(value = "/commandes")
	public String commandes(Model model){
		
		List<Commande> commandes = metier.consulterCommandes();
		
		model.addAttribute("commandes",commandes);
		return "commandes";	
	}
	
	@RequestMapping(value ="/consulterCommande/{numerocommande}")
	public String afficherCommande(Model model,@PathVariable int numerocommande){
		
		Commande commande = metier.consulterCommande(numerocommande);
		model.addAttribute("commande",commande);
		
		List<Produits> produits = metier.consulterProduitsOfCommande(numerocommande);
		List<Integer> quantites = new ArrayList<Integer>(); 
		List<Facture> factures = metier.consulterFacturesOfCommande(numerocommande);
		List<Livraison> livraisons = metier.consulterLivraisonsOfCommande(numerocommande);
		
		double total = 0;
		
		if(!produits.isEmpty()){
			
			 for(int i=0;i<produits.size();i++){
				 quantites.add(metier.consulterQtProduitsCommande(produits.get(i).getNumeroproduit(), numerocommande));
			     total += metier.consulterQtProduitsCommande(produits.get(i).getNumeroproduit(), numerocommande)*produits.get(i).getPrix();
			    }
			 
			model.addAttribute("quantites", quantites);
			
			model.addAttribute("total",total);
			
			model.addAttribute("produits",produits);
			
			model.addAttribute("factures",factures);
			
			model.addAttribute("livraisons", livraisons);
			
		}
		
		return "consulterCommande";
		
	}
	
	@RequestMapping(value = "/ajouterCommande")
	public String ajouterClient(@Valid CommandeForm cf,BindingResult bindingResult,Model model){
		
		//validation du formulaire
				if(bindingResult.hasErrors()){
					//si erreur je retourne vers la vue
					return "ajouterCommandet";
				}
				
				//recuperer la liste des clients
				List<Client> clients = metier.consulterClients();
				model.addAttribute("clients",clients);
				
				//recuperer la liste des produits
				List<Produits> produits = metier.consulterProduits();
				model.addAttribute("produits",produits);
				
				
				

				try{
					//creer commande
					Commande commande = new Commande(new Date());
					commande.setClient(cf.getClient());
					
					
					List<Integer> q=cf.getQuantites();
					Commande newCommande = metier.addCommande(commande);
					for(int i=0;i<produits.size();i++){
	                     if(q.get(i)!=null){
	                    	 metier.addProduitsToCommande(produits.get(i).getNumeroproduit(), newCommande.getNumerocommande(), q.get(i));
	                     }
					}
					 
					  	
				}catch (Exception e) {
					//cf.setException(e.getMessage());
				}
					  
				
		model.addAttribute("CommandeForm", cf);
	   			
		return "ajouterCommande";	
	}
	
	/*
	 ***************** Produits ***************
	 */
	
	@RequestMapping(value = "/produits")
	public String produits(Model model){
		
		List<Produits> produits = metier.consulterProduits();
		
		model.addAttribute("produits",produits);
		return "produits";	
	}
	
	
	@RequestMapping(value = "/ajouterProduit")
	public String ajouterProduit(@Valid ProduitForm pf,BindingResult bindingResult,Model model){
		
		//validation du formulaire
				if(bindingResult.hasErrors()){
					//si erreur je retourne vers la vue
					return "ajouterProduit";
				}

				try{
					  Produits p = new Produits(pf.getNomproduit(),pf.getQuantite(),pf.getPrix());
					  metier.addProduit(p);
					  return "redirect:/produits";
					  	
				}catch (Exception e) {
					pf.setException(e.getMessage());
				}
					  
				
		model.addAttribute("produitForm", pf);
	   			
		return "ajouterProduit";	
	}
	
	@RequestMapping(value ="/supprimerProduit/{numeroproduit}")
	public String supprimerProduit(Model model,@PathVariable int numeroproduit){	
		metier.deleteProduit(numeroproduit);
		return "redirect:/produits";
		
	}
	
	/*
	 ***************** Factures ***************
	 */
	
	@RequestMapping(value = "/factures")
	public String factures(Model model){
		
		List<Facture> factures = metier.consulterFactures();
		
		model.addAttribute("factures",factures);
		return "factures";	
	}
	
	/*
	 ***************** Livraisons ***************
	 */
	
	@RequestMapping(value = "/livraisons")
	public String livraisons(Model model){
		
		List<Livraison> livraisons = metier.consulterLivraisons();
		
		model.addAttribute("livraisons",livraisons);
		return "livraisons";	
	}
	
	
	
	
	
}
