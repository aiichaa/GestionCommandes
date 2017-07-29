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

   <h1>Ajouter Commande</h1> 
   
   
   <div>
      <f:form modelAttribute="CommandeForm" methode="post" action="ajouterCommande">
       Client : 
              <f:select path="client">
                    <f:option value="NONE" label="--- Select ---"/>
                     <%-- <f:options items="${clients}" /> --%>
                     <c:forEach items="${clients}" var="client">  
                     <f:option value="client" label="${client.nom} ${client.prenom }"></f:option>
                     </c:forEach>
                  </f:select>
              <f:errors path="client"></f:errors>
            <br><br>
         Liste des Produits : (Choisissez La Quantite) 
            <br>
                
               <div class="madiv" >
                <ol>
                
                 <c:forEach items="${produits}" var="produit" varStatus="i"> 
                   <li> 
                     ${produit.nomproduit } &emsp; <f:input path="${quantites[i.index]}" type="number"/>
                   </li>  
                   <br> 
                   
                    <br>
                 </c:forEach>   
                   
                 </ol> 
                 </div> 
                 
        
             <input type="submit" value="Ajouter">
            
            
        
      </f:form>
   </div>
   
   <br>
   <a href="/gc/clients">Retourner a la liste</a>

</body>
</html>

