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

   <h1>Client : ${client.numeroclient}</h1> 
   
   <div class="madiv">
   <table >
     <tr>
       <td>Nom :</td>
       <td>${client.nom}</td>
     </tr>
     
     <tr>
       <td>Prenom :</td>
       <td>${client.prenom}</td>
     </tr>
     
     <tr>
       <td>Adresse :</td>
       <td>${client.adresse}</td>
     </tr>
     
     <tr>
       <td>Telephone :</td>
       <td>${client.telephone}</td>
     </tr>
     
   </table>
   </div>
   <br>
   
   <h3>Commandes du client : </h3>
   <div class="madiv">
   
   
    <table width="70%" cellpadding="2" class="table1">  
<tr>
<th>Numero</th>
<th>Date</th>
<th>Afficher</th>
<th>Modifer</th>
<th>Supprimer</th>
</tr>  
   <c:forEach items="${commandes}" var="commande">   
   <tr>  
   <td>${commande.numerocommande}</td>  
   <td>${commande.date}</td>  
   <td><a href="/gc/consulterCommande/${commande.numerocommande}">Afficher</a></td> 
   <td><a href="/gc/modifierCommande/${commande.numerocommande}">Modifier</a></td>  
   <td><a href="/gc/supprimerCommande/${commande.numerocommande}">Supprimer</a></td>  
   </tr>  
   </c:forEach>  
   </table>   
   </div>
   
   <a href="/gc/clients">Retourner a la liste</a>

</body>
</html>

