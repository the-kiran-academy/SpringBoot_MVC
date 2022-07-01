<%
String username=(String)session.getAttribute("username");
if(username==null){
	
	request.setAttribute("msg", "Please Login Fisrt !!");
	RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
}
%>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Product</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="homePage">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <%
     String role=(String)session.getAttribute("role");
      if(role.equals("Admin")){
    	%>
    	<li class="nav-item">
        <a class="nav-link" href="addUserPage">Add User</a>
      </li>
    	<%  
      }
      %>
      
      
     
      <li class="nav-item">
        <a class="nav-link" href="listOfUser?msg=null">List Of User</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="#">List Of Product</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="profile?username=<%=session.getAttribute("username")%>"><%=session.getAttribute("username")%></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="logout?username=<%=session.getAttribute("username")%>">Logout</a>
      </li>
      
      
    </ul>
  </div>
</nav>