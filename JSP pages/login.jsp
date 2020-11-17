<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SITA My_Manager Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
.login-form {
    width: 440px;
    margin: 50px auto;
  	font-size: 15px;
}
 .login-form form {
    margin-bottom: 15px;
    background: rgba(217, 231, 243, 0.8); 
    box-shadow: 10px 10px 10px rgba(10, 10, 10, 0.4);
    padding: 40px;
} 
.login-form h2 {
    margin: 0 0 35px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 8px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
html,body{
background-image: url('https://images.unsplash.com/photo-1593182440709-4b7b56482c55');
background-size: cover;
background-repeat: no-repeat;
height: 100%;
font-family: 'Numans', sans-serif;
}
</style>
</head>

<body>

<div class="login-form">
<div align="center">
<form action="<%=request.getContextPath()%>/login" method="post">
 <p>
 <a href="https://ibb.co/fvKJcV4"><img src="https://i.ibb.co/ySM23mW/My-Manager0.png" width="300" height="120"></a>
 <!-- <img src="D:\Eclipse\Stage SITA\My_Manager0.png" align="middle" width="300" height="120"> -->
  </p>
  <!-- <FONT face="libre baskerville"> 
   <FONT size="7pt">
        <h1 class="text-center" style="color:#139fdb">LogIn</h1>
        </FONT>
        </FONT>  -->
        
   <tr>
     <td><input type="text" class="form-control" placeholder="Username" name="username" required="required"/></td>
    </tr>
    <p>
    </p>
        <tr>
     <td><input type="password" class="form-control" placeholder="Password" name="password" required="required"/></td>
    </tr>
    <p>
    </p>
    
    <FONT face="libre baskerville">
    
        <div class="form-group">
            <button type="submit" class="btn btn-primary">LOGIN</button>
        </div> </FONT>
        
        <!-- <div class="clearfix">
            <label class="float-left form-check-label"><input type="checkbox"> Remember me</label>
            <a href="#" class="float-right">Create an Account</a>
            
            
    </div>   -->  
   
  </form>
  </div>
 </div>
 
</body>
</html>