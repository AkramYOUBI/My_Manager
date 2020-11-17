<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
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
<div class="container col-md-10 col-md-offset-1">
<div class="card text-center">
  <div class="card-header">
  <div class="text-right">

<a class="btn btn-outline-danger" href="logout.do" > LogOut </a>

</div>
   <p>
   <img src='https://zupimages.net/up/20/39/lxc8.png' align="middle" width="300" height="120"/>
  <!-- <image src="D:\Eclipse\Stage SITA\My_Manager0.png" align="middle" width="300" height="120"> -->
   <!-- <FONT face="libre baskerville"> 
   <FONT size="5pt">
  <p style="color:#139fdb"> Let's move the world, together </p>
  </FONT>
  </FONT> -->
  </p>
  <ul class="nav nav-tabs card-header-tabs">
      <li class="nav-item">
        <a class="nav-link" href="index.do">Recherche Des Equipements</a>
      </li>
         <li class="nav-item">
        <a class="nav-link" href="Saisie.do">Saisie D'un Equipement</a>
       </li>
       
      
     <li class="nav-item">
        <a class="nav-link" href="RP.do">Recherche Avancée</a>
      </li>
        <% if(session.getAttribute("fct")== null) 
					{%>
        	  
				<%	}else{%>
      <li class="nav-item">
        <a class="nav-link" href="admin.do">Espace Admin</a>
      </li>
      <% }%>
      
      
    </ul> 
  </div>
  
 <div class="form-group">
 <label>Numéro_Série:</label>
 <label>${equipement.numero_serie}</label>
 </div>
  <div class="form-group">
 <label>Assets_Tag:</label>
 <label>${equipement.assets_tag}</label>
 </div>
 <div class="form-group">
 <label>Node_Name:</label>
 <label>${equipement.node_name}</label>
 </div>
 <div class="form-group">
 <label>Model:</label>
 <label>${equipement.model}</label>
 </div>
 <div class="form-group">
 <label>Type:</label>
 <label>${equipement.type}</label>
 </div>
  <div class="form-group">
 <label>Nom_Projet:</label>
 <label>${equipement.nom_projet}</label>
 </div>
 <div class="form-group">
 <label>Nom_Aéroport:</label>
 <label>${equipement.nom_aeroport}</label>
 </div>
 <div class="form-group">
 <label>Emplacement:</label>
 <label>${equipement.emplacement}</label>
 </div>
 <div class="form-group">
 <label>ID_Terminal:</label>
 <label>${equipement.id_terminal}</label>
 </div>
 <div class="form-group">
 <label>Nom_zone:</label>
 <label>${equipement.nom_zone}</label>
 </div>
 <div class="form-group">
 <label>ID_Comptoir:</label>
 <label>${equipement.id_comptoir}</label>
 </div>
  <div class="form-group">
 <label>Etat:</label>
 <label>${equipement.etat}</label>
 </div>
  <div class="form-group">
 <label>Commentaire:</label>
 <label>${equipement.commentaire}</label>
 </div>
 
</div>
</div>
</body>
<%} %>
</html>