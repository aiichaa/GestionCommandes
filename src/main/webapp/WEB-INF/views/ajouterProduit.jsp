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

   <h1>Ajouter Produit</h1> 
   
   <div>
      <f:form modelAttribute="produitForm" methode="post" action="ajouterProduit">
        <table>
           <tr>
              <td>Nom Produit:</td>
              <td><f:input path="nomproduit"/></td>
              <td><f:errors path="nomproduit"></f:errors></td>
            </tr>
            
            <tr>
              <td>Quantite:</td>
              <td><f:input path="quantite"/></td>
              <td><f:errors path="quantite"></f:errors></td>
            </tr>
            
            <tr>
              <td>Prix:</td>
              <td><f:input path="prix"/></td>
              <td><f:errors path="prix"></f:errors></td>
            </tr>
            
            
            <tr>
              <td><input type="submit" value="Ajouter"></td>
            </tr>
            
        </table>
      </f:form>
   </div>
   
   <a href="/gc/produits">Retourner a la liste</a>

</body>
</html>

