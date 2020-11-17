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
<a class="btn btn-outline-danger" href="logout.do"  > LogOut </a>
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
      <li class="nav-item">
        <a class="nav-link" href="admin.do">Espace Admin</a>
      </li>
    
    </ul>
  </div>
 
 <form action="tSave.do" method="post">
	<p>  </p>
  <div class="form-group">
  <label class="control-label">Type D'un Equipement:</label>
  <input type="text" name="type" value="${type.type}" class="form-control" />
  <span></span>
  
  <button class="btn btn-primary">Save</button>
  </form>
  </div>
  
</div>

</body>
<%} %>
</html>