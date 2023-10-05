<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welocome to Nisanth Webpage </title>

</head>

<body>
<form action="addUser"> 
Enter ID <input type = "text" name = "id" ><br>
Enter Name<input type = "text" name = "name" ><br>
<input type ="submit" >

</form>

<h2>Display the user Information</h2>
<form action="getUser"> 
Enter ID <input type = "text" name = "id" ><br>

<input type ="submit" >
</form>
<h2>Delete the user Information</h2>
<form action="deleteUser"> 
Enter ID <input type = "text" name = "id" ><br>

<input type ="submit" >
</form>
<h2>Update the user Information</h2>
<form action="updateUser"> 
Enter ID <input type = "text" name = "id" ><br>

<input type ="submit" >
</form>
</body>
</html>