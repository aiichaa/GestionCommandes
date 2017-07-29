<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title>Gestion Commande</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>

<ul>
  
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Client</a>
    <div class="dropdown-content">
      <a href="ajouterClient">Ajouter Client</a>
      <a href="clients">Voir list Clients</a>
    </div>
  </li>


 <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Commande</a>
    <div class="dropdown-content">
      <a href="ajouterCommande">Ajouter Commande</a>
      <a href="commandes">Voir list Commandes</a>
    </div>
  </li>


<li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Produit</a>
    <div class="dropdown-content">
      <a href="ajouterProduit">Ajouter Produit</a>
      <a href="produits">Voir list Produits</a>
    </div>
</li>

<li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Facture</a>
    <div class="dropdown-content">
      <a href="factures">Voir list Factures</a>
    </div>
</li>

<li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Livraison</a>
    <div class="dropdown-content">
      <a href="livraisons">Voir list Livraison</a>
    </div>
</li>
  
</ul>

   <h1>Commande : ${commande.numerocommande}</h1> 
   
   <div class="madiv">
   <table >
     <tr>
       <td>Date :</td>
       <td>${commande.date}</td>
     </tr>
     
     <tr>
       <td>Client :</td>
       <td>${commande.client.nom}</td>
     </tr>
     
    
     
   </table>
   </div>
   <br>
   
   <h3>Produits de la Commande : </h3>
   <div class="madiv">
   
   
    <table width="70%" cellpadding="2" class="table1">  
<tr>
<th>Numero</th>
<th>Nom</th>
<th>Prix</th>
<th>Quantite</th>
<th>Afficher</th>
<th>Modifer</th>
<th>Supprimer</th>
</tr>  
   <c:forEach items="${produits}" var="produit" varStatus="i">   
   <tr>  
   <td>${produit.numeroproduit}</td>  
   <td>${produit.nomproduit}</td> 
   <td>${produit.prix}</td> 
   <td>${quantites[i.index]}</td>
   <td><a href="consulterProduit/${produit.numeroproduit}">Afficher</a></td> 
   <td><a href="modifierProduit/${produit.numeroproduit}">Modifier</a></td>  
   <td><a href="supprimerProduit/${produit.numeroproduit}">Supprimer</a></td>  
   </tr>  
   </c:forEach>  
   </table>   
   </div>
   
   <div class="madiv">
     <p>Prix Total : ${total} </p>   
   </div>
   
   <h3>Factures de la Commande : </h3>
   <c:forEach items="${factures}" var="facture">
   <div class="madiv">
      <table>
          <tr>
            <td>Numero : </td>
            <td>${facture.numerofacture}</td>
         </tr>
         <tr>
            <td>Date : </td>
            <td>${facture.datefacture}</td>
         </tr>
         <tr>
            <td>Montant : </td>
            <td>${facture.montant}</td>
         </tr>
      </table>
   </div>
   </c:forEach>
   
   <h3>Livraisons de la Commande : </h3>
   <c:forEach items="${livraisons}" var="livraison">
   <div class="madiv">
      <table>
          <tr>
            <td>Numero : </td>
            <td>${livraison.numerolivraison}</td>
         </tr>
         <tr>
            <td>Date : </td>
            <td>${livraison.datelivraison}</td>
         </tr>
      </table>
   </div>
   </c:forEach>
   
   <a href="/gc/commandes">Retourner a la liste</a>

</body>
</html>

