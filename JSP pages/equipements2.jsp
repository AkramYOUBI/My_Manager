<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-1>
<title>Recherche des Equipements</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>

<style>


html,body{
background-image: url('https://images.unsplash.com/photo-1593182440709-4b7b56482c55');
background-size: cover;
background-repeat: no-repeat;
height: 100%;
width: 100%;
font-family: 'Numans', sans-serif;
}
</style>

<%if(session.getAttribute("connected")==null) 
{
	request.getRequestDispatcher("login.jsp").forward(request, response);
	
}else 
{ %>

<body>
<script type="text/javascript">
	function preback(){window.history.forward();}
	setTimeout("preback()", 0);
	window.onunload=function(){null};
	</script>
<p></p>

<!-- <div class="container col-md-12 col-md-offset" >  -->

<div class="card text-center">
  <div class="card-header">
  <div class="text-right">

<a class="btn btn-outline-danger" href="logout.do"  > LogOut </a>

</div>
  <p>
  <img src='https://zupimages.net/up/20/39/lxc8.png' align="middle" width="300" height="120"/>
  <!-- <image src="D:\Eclipse\Stage SITA\My_Manager0.png" align="middle" width="300" height="120">  -->
   <!-- <FONT face="libre baskerville"> 
   <FONT size="5pt">
  <p style="color:#139fdb"> Let's move the world, together </p>
  </FONT>
  </FONT> -->
  
  </p>
  <p></p>
  <% if(session.getAttribute("fct")== null) 
					{%>
        	  
				<%	}else{%>
  <form>
                 <input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" value="Generate Report" type="button" onclick="window.print()" />
             </form>
              <% }%>
  <p></p>
  
    <ul class="nav nav-tabs card-header-tabs">
    <!-- <li class="nav-item">
        <a class="nav-link" href="Accueil.do">Acceuil</a>
      </li> -->
      <li class="nav-item">
        <a class="nav-link" href="index.do">Recherche Des Equipements</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Saisie.do">Saisie D'un Equipement</a>
       </li>
      
     <li class="nav-item">
        <a class="nav-link active" href="RP.do">Recherche Avancée</a>
      </li>
      <% if(session.getAttribute("fct")== null) 
					{
    	  
					}else{%>
      <li class="nav-item">
        <a class="nav-link" href="admin.do">Espace Admin</a>
      </li>
      <% }%>
      
      
    </ul>
  </div>
  <p>
  </p>
  <form action="RP.do" method="get">
  <label></label>
  <input type="text" name="nom_aeroport" placeholder="Aeroport" value="${mmodel.nom_aeroport}"/>
  <input type="text" name="nom_projet" placeholder="Projet" value="${mmodel.nom_projet}"/>
  <input type="text" name="id_terminal" placeholder="Terminal" value="${mmodel.id_terminal}"/>
  <input type="text" name="nom_zone" placeholder="Zone" value="${mmodel.nom_zone}"/>
  <input type="text" name="id_comptoir" placeholder="Comptoir" value="${mmodel.id_comptoir}"/>
  <input type="text" name="model" placeholder="Model" value="${mmodel.model}"/>
  <button type="submit" class="btn btn-primary">Chercher</button>
  </form>
  <table class="table table-striped">
  <tr>
  <th>Numéro Série</th><th>Asset Tag</th><th>Node Name</th><th>Model</th><th>Type</th><th>Projet</th><th>Aéroport</th><th>Emplacement</th><th>Terminal</th><th>Zone</th><th>Comptoir</th><th>Etat</th><th>Commentaire</th>
  </tr>
  <c:forEach items="${mmodel.equipements}" var="e">
  <tr>
  <td>${e.numero_serie}</td>
  <td>${e.assets_tag}</td>
  <td>${e.node_name}</td>
  <td>${e.model}</td>
  <td>${e.type}</td>
  <td>${e.nom_projet}</td>
  <td>${e.nom_aeroport}</td>
  <td>${e.emplacement}</td>
  <td>${e.id_terminal}</td>
  <td>${e.nom_zone}</td>
  <td>${e.id_comptoir}</td>
  <td>${e.etat}</td>
  <td>${e.commentaire}</td>
  <td><a onclick="return confirm('Etes vous sûre ?')" href="Supprime.do?numero_serie=${e.numero_serie }">Supprimer</a></td>
  <td><a href="Edit.do?numero_serie=${e.numero_serie }">Edit</a></td>
  </tr>
  </c:forEach>
  </table>
</div>
</body>
<%} %>
</html>