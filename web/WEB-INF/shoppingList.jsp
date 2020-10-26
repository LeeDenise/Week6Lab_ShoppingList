<%-- 
    Document   : shoppingList
    Created on : Oct 25, 2020, 3:47:14 PM
    Author     : 807785
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}<p>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        
        <form action="" method="POST">
            <h2>Add Item</h2>
            <input type="text" name="item"><input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">            
        </form>
        
        <form action="" method="post">
            
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
