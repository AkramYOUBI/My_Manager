<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie D'un Equipement</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

</head>

<style>
html,body{
background-image: url('https://images.unsplash.com/photo-1593182440709-4b7b56482c55');
background-size: cover;
background-repeat: no-repeat;
height: 146%;
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
<a class="btn btn-outline-danger" href="logout.do"> LogOut </a>
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
        <a class="nav-link active" href="Saisie.do">Saisie D'un Equipement</a>
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
 
 <form action="SaveEquipement.do" method="post">
	<p>  </p>
  <div class="form-group"> 
  <label class="control-label">Numéro Série:</label>
  <input type="text" name="numero_serie" value="${equipement.numero_serie}" class="form-control" />
  <span></span>
</div> 
  <div class="form-group">
  <label class="control-label">Asset Tag:</label>
  <input type="text" name="assets_tag" value="${equipement.assets_tag}" class="form-control"/>
  <span></span>
  </div>
  <div class="form-group">
  <label class="control-label">Node Name:</label>
  <input type="text" name="node_name" value="${equipement.node_name}"class="form-control"/>
  <span></span>
  </div>
  <div class="form-group">
  <label class="control-label">Model:</label>
  <input type="text" name="model" value="${equipement.model}" class="form-control"/>
  <span></span>
  </div>
  
  
  <p>Type:</p>
  <select name="type" id="type" value="${equipement.type}" class="form-control" >
  <option value=""></option>
  <c:forEach items="${tmodel.types}" var="t">
   <option value="${t.type}">${t.type}</option>
  </c:forEach>
	</select>	
  		<p>	
  
  
  <%-- <div class="form-group">
  <label class="control-label">Type:</label>
  <input type="text" name="type" value="${equipement.type}" class="form-control"/>
  <span></span>
  </div> --%>
  <%-- <div class="form-group">
  <label class="control-label">Projet:</label>
  <input type="text" name="nom_projet" value="${equipement.nom_projet}" class="form-control"/>
  <span></span>
  </div> --%>
	
	<p>Projet:</p>
  <select name="nom_projet" id="nom_projet" value="${equipement.nom_projet}" class="form-control" >
  <option value=""></option>
  <c:forEach items="${pmodel.projets}" var="p">
   <option value="${p.nomProjet}">${p.nomProjet}</option>
  </c:forEach>
	</select>	
  		<p>
	
  		<p>	
 <%--  <div class="form-group">
  <label class="control-label">Aéroport:</label>
  <input type="text" name="nom_aeroport" value="${equipement.nom_aeroport}" class="form-control"/>
  <span></span>
  </div> --%>	
  		
  		<p>Aéroport:</p>
  <select name="nom_aeroport" id="nom_aeroport" value="${equipement.nom_aeroport}" class="form-control" >
  <option value=""></option>
  <c:forEach items="${amodel.aeroports}" var="a">
   <option value="${a.nomAeroport}">${a.nomAeroport}</option>
  </c:forEach>
	</select>	
  		<p>
  		
  		
  		
 
  <p>Emplacement:</p>
  <select name="emplacement" id="emplacement" value="${equipement.emplacement}" class="form-control" onchange="return visibilite();" >
  <option value=""></option>
  <option value="stock">Stock</option>
  <option value="production">Production</option>
	</select>	
  		<p>	
  		
  		<script>
	function visibilite(){
	    var selectbox =document.getElementById("emplacement");
		var emplc = selectbox.options[selectbox.selectedIndex].value; 
		if(emplc == "production"){
			
			document.getElementById("id_terminal").style.visibility="visible";
			document.getElementById("nom_zone").style.visibility="visible";
			document.getElementById("id_comptoir").style.visibility="visible";
		}
		else if (emplc == "stock"){
			document.getElementById("id_terminal").value= null;
			document.getElementById("id_terminal").style.visibility="hidden";
			document.getElementById("nom_zone").value= null ;
			document.getElementById("nom_zone").style.visibility="hidden";
			document.getElementById("id_comptoir").value= null;
			document.getElementById("id_comptoir").style.visibility="hidden";
		}
		return false; 		  
			
	}
	</script>
    
  <div class="form-group">
  <label class="control-label">Terminal:</label>
  <input type="text" id="id_terminal" name="id_terminal" value="${equipement.id_terminal}" class="form-control" style="visibility: hidden;"/>   
  <span></span>
  </div>
  <div class="form-group">
  <label class="control-label">Zone:</label>
  <input type="text" id="nom_zone" name="nom_zone" value="${equipement.nom_zone}" class="form-control" style="visibility: hidden;"/>
  <span></span>
  </div>
  <div class="form-group">
  <label class="control-label">Comptoir:</label>
  <input type="text" id="id_comptoir"  name="id_comptoir" value="${equipement.id_comptoir}" class="form-control" style="visibility: hidden;"/>
  <span></span>
  </div>
  
  <p>Etat:</p>
  <select name="etat" value="${equipement.etat}" class="form-control">
   <option value=""></option>
  <option value="OK">OK</option>
 <option value="NON OK">NON OK</option> 
	</select>
	<p></p>
	<div class="form-group">
  <label class="control-label">Commentaire:</label>
  <input type="text" name="commentaire" value="${equipement.commentaire}" class="form-control"/>
  <span></span>
  </div>
	<p>
	<p>
	<p>	
  
  <button class="btn btn-primary">Save</button>
  </form>
  </div>
  
</div>

</body>
<%} %>
</html>