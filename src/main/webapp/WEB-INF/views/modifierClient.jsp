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

   <h1>Modifier Client</h1> 
   
   <div>
      <f:form modelAttribute="clientForm" methode="post" action="modifierClient">
        <table>
           <tr>
              <td>Nom:</td>
              <td><f:input path="nom" value="${client.nom}"/></td>
              <td><f:errors path="nom"></f:errors></td>
            </tr>
            
            <tr>
              <td>Prenom:</td>
              <td><f:input path="prenom" value="${client.prenom}"/></td>
              <td><f:errors path="prenom"></f:errors></td>
            </tr>
            
            <tr>
              <td>Adresse:</td>
              <td><f:input path="adresse" value="${client.adresse}"/></td>
              <td><f:errors path="adresse"></f:errors></td>
            </tr>
            
            <tr>
              <td>Telephone:</td>
              <td><f:input path="telephone" value="${client.telephone}"/></td>
              <td><f:errors path="telephone"></f:errors></td>
            </tr>
            
            <tr>
              <td><input type="submit" value="Modifier"></td>
            </tr>
            
        </table>
      </f:form>
   </div>
   
   <a href="/gc/clients">Retourner a la liste</a>

</body>
</html>

