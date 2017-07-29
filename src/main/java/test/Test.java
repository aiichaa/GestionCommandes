package test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ensak.gc.entities.Client;
import com.ensak.gc.entities.Commande;
import com.ensak.gc.entities.Facture;
import com.ensak.gc.entities.Livraison;
import com.ensak.gc.entities.Produits;
import com.ensak.gc.metier.IGestionCmdMetier;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	
 IGestionCmdMetier metier= (IGestionCmdMetier) context.getBean("metier");
		
 
 /*Client c1 = new Client("Fatah","Aicha","N51 rue gare","0637638847");
 Client c2 = new Client("Hadraoui","Jihane","Chabab 2","0666738273");
 Client c3 = new Client("Tanfioui","Khaoula","Hana 2","0693847625");
 
 metier.addClient(c1);
 metier.addClient(c2);
 metier.addClient(c3);*/
         
        Client c1 = metier.consulterClient(1);
        Client c2 = metier.consulterClient(2);
        Client c3 = metier.consulterClient(3);
        
      
       /*Commande com1 = new Commande(new Date());
        Commande com2 = new Commande(new Date());
        Commande com3 = new Commande(new Date());
        Commande com4 = new Commande(new Date());
        Commande com5 = new Commande(new Date());
        
        
        com1.setClient(c1);
        com2.setClient(c1);
        com3.setClient(c2);
        com4.setClient(c3);
        com5.setClient(c1);
        
        metier.addCommande(com1);
        metier.addCommande(com2);
        metier.addCommande(com3);
        metier.addCommande(com4);
        metier.addCommande(com5);*/
        
        Commande com1 = metier.consulterCommande(1);
        Commande com2 = metier.consulterCommande(2);
        Commande com3 = metier.consulterCommande(3);
        Commande com4 = metier.consulterCommande(4);
        Commande com5 = metier.consulterCommande(5);
        

        
        /*metier.addProduit(new Produits("pc hp",10,100000));
        metier.addProduit(new Produits("pc samsung",34,200000));
        metier.addProduit(new Produits("pc asus",50,300000));
        metier.addProduit(new Produits("mac",15,500000));
        metier.addProduit(new Produits("lenovo",40,100000));
        metier.addProduit(new Produits("pc dell",40,100000));
        metier.addProduit(new Produits("pc toshiba",40,100000));
        */
        
        /*metier.addProduitsToCommande(1, 1, 3);
        metier.addProduitsToCommande(2, 1, 5);
        metier.addProduitsToCommande(3, 1, 2);
        
        metier.addProduitsToCommande(1, 2, 4);
        metier.addProduitsToCommande(3, 2, 1);
        metier.addProduitsToCommande(4, 2, 3);
        
        metier.addProduitsToCommande(1, 3, 4);
        metier.addProduitsToCommande(2, 3, 1);
        metier.addProduitsToCommande(4, 3, 3);
        metier.addProduitsToCommande(3, 3, 1);
        metier.addProduitsToCommande(5, 3, 3);
        
        metier.addProduitsToCommande(3, 4, 5);
        
        metier.addProduitsToCommande(4, 5, 2);
        metier.addProduitsToCommande(5, 5, 2);*/
        
        
        
        
        
        
  List<Produits> produitsCm1 = metier.consulterProduitsOfCommande(1);
  List<Produits> produitsCm2 = metier.consulterProduitsOfCommande(2);
  List<Produits> produitsCm3 = metier.consulterProduitsOfCommande(3);
  List<Produits> produitsCm4 = metier.consulterProduitsOfCommande(4);
  List<Produits> produitsCm5 = metier.consulterProduitsOfCommande(5);

  
  /*Facture f1 =new Facture(new Date(), 2.28E7);
  f1.setCommande(com1);
  Facture f2 = new Facture(new Date(), 2.35E7);
  f2.setCommande(com2);
  Facture f3 = new Facture(new Date(), 3.43E7);
  f3.setCommande(com3);
  Facture f4 = new Facture(new Date(), 1.5E7);
  f4.setCommande(com4);
  Facture f5 = new Facture(new Date(), 1.15E7);
  f5.setCommande(com5);
      
      metier.addFacture(f1);
      metier.addFacture(f2);
      metier.addFacture(f3);
      metier.addFacture(f4);
      metier.addFacture(f5);*/
      

     /* Facture f1 = metier.consulterFacture(1);
      Facture f2 = metier.consulterFacture(2);
      Facture f3 = metier.consulterFacture(3);
      Facture f4 = metier.consulterFacture(4);
      Facture f5 = metier.consulterFacture(5);*/
      
      
     /* Livraison l1 = new Livraison(new Date());
      l1.setCommande(com1);
      Livraison l2 = new Livraison(new Date());
      l2.setCommande(com2);
      Livraison l3 = new Livraison(new Date());
      l3.setCommande(com3);
      Livraison l4 = new Livraison(new Date());
      l4.setCommande(com4);
      Livraison l5 = new Livraison(new Date());
      l5.setCommande(com5);
      
      metier.addLivraison(l1);
      metier.addLivraison(l2);
      metier.addLivraison(l3);
      metier.addLivraison(l4);
      metier.addLivraison(l5);*/

       
       /*List<Commande> commandes = metier.consulterCommandesOfClient(23);

       for(int i=0;i<commandes.size();i++){
       	System.out.println(commandes.get(i).getDate());
       	
       }*/
        
       /* List<Client> list = metier.consulterClients();
        for(int i=0;i<list.size();i++){
        	System.out.println(list.get(i).getNumeroclient());
        	System.out.println(list.get(i).getNom());
        }*/
 
      /* metier.addProduit(new Produits("pc hp",3,100000));
       metier.addProduit(new Produits("pc samsung",2,200000));
       metier.addProduit(new Produits("pc azur",4,300000));*/
 
        //Commande c = metier.consulterCommande(1);
        //System.out.println("date " + c.getDate());
        /*List<Produits> produits = metier.consulterProduits();
        for(int i=0;i<produits.size();i++){
           	System.out.println(produits.get(i).getNomproduit());
           	metier.addProduitsToCommande(produits.get(i).getNumeroproduit(), 1);
           }*/
        //c.setProduits(produits);
 
       /*List<Produits> p = metier.consulterProduitsOfCommande(1);
       for(int i=0;i<p.size();i++){
       	System.out.println(p.get(i).getNomproduit());
       }*/
       
 
       
		
	}
}

