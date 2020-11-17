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

<a class="btn btn-outline-danger" href="logout.do" > LogOut </a>

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
        <a class="nav-link" href="RP.do">Recherche Avancée</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="admin.do">Espace Admin</a>
      </li>
      
      
      
    </ul>
  </div>
  <p>
  </p>
 
  <br> <br>
 
  <!-- <div class="container col-md-3 col-md-offset" >
 <div class="custom-file">
  <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp"> 
  <p></p>
  <a  href="SaisieAeroport.jsp" class="btn btn-outline-primary" > Inserer </a>
</div>
</div> -->
<p></p>
<p></p>
  
  <FONT face="libre baskerville">
  <p class="h2" style="color:#139fdb">Les Aeroports:</p>
  </FONT>
  <p></p>
  <table class="table table-striped">
  <tr>
  <th scope="col">Nom Aeroport</th>
  <th></th><th ><a  href="SaisieAeroport.jsp" class="btn btn-primary" > Ajouter Un Aeroport</a></th>
  </tr>
  <c:forEach items="${amodel.aeroports}" var="a">
  <tr>
  <td>${a.nomAeroport}</td>
  <td><a onclick="return confirm('Etes vous sûre ?')" href="aSupprime.do?nomAeroport=${a.nomAeroport }">Supprimer</a></td>
  <td><a href="aEdit.do?nomAeroport=${a.nomAeroport }">Edit</a></td>
  </tr>
  </c:forEach>
  </table>
  
  <br> <br>
  <FONT face="libre baskerville">
  <p class="h2" style="color:#139fdb">Les Projets:</p>
  </FONT>
  <p></p>
  <table class="table table-striped">
  <tr>
  <th scope="col">Nom Projet</th><th></th><th ><a  href="SaisieProjet.jsp" class="btn btn-primary" > Ajouter Un Projet</a></th>
  </tr>
  <c:forEach items="${pmodel.projets}" var="p">
  <tr>
  <td>${p.nomProjet}</td>
  <td><a onclick="return confirm('Etes vous sûre ?')" href="pSupprime.do?nomProjet=${p.nomProjet }">Supprimer</a></td>
  <td><a href="pEdit.do?nomProjet=${p.nomProjet }">Edit</a></td>
  </tr>
  </c:forEach>
  </table>
  
  
  <br> <br>
  <FONT face="libre baskerville">
 <p class="h2" style="color:#139fdb">Type D'équipement:</p>
 </FONT>
  <p></p>
  <table class="table table-striped">
  <tr>
  <th scope="col">Types D'équipement</th><th></th><th ><a href="SaisieType.jsp" class="btn btn-primary" > Ajouter Un Type</a></th>
  </tr>
  <c:forEach items="${tmodel.types}" var="t">
  <tr>
  <td>${t.type}</td>
  <td><a onclick="return confirm('Etes vous sûre ?')" href="tSupprime.do?type=${t.type }">Supprimer</a></td>
  <td><a href="tEdit.do?type=${t.type }">Edit</a></td>
  </tr>
  </c:forEach>
  </table>
  
</div>
</body>
<%} %>
</html>