<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="menu.jsp" />

<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>List Of User</title>
</head>
<body>
<h4 style="color: red">${msg}</h4>
<table class="table table-sm table-dark">
 
  <thead>
    <tr>
      <th scope="col">USERNAME</th>
      <th scope="col">PASSWORD</th>
      <th scope="col">GENDER</th>
      <th scope="col">ROLE</th>
      <th scope="col">QUESTION</th>
      <th scope="col">ANSWER</th>
         <th scope="col">ACTION</th>

    </tr>
  </thead>
  <tbody>
   <c:forEach items="${userList}" var="user">
   <tr>
   <td><c:out value="${user.username}"></c:out></td>
   <td><c:out value="${user.password}"></c:out></td>
   <td><c:out value="${user.gender}"></c:out></td>
   <td><c:out value="${user.role}"></c:out></td>
   <td><c:out value="${user.question}"></c:out></td>
   <td><c:out value="${user.answer}"></c:out></td>
   <td>
   <a href="profile?username=${user.username}">Edit</a> | 
   <a href="deleteUser?username=${user.username}">Delete</a>
   </td>
   </tr>
   
   </c:forEach>
  </tbody>
</table>
</body>
</html>