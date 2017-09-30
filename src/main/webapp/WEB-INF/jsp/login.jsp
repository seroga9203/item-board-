<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
       
        <title>Item Board</title>

        <%--meta link--%>
        <%@ include file="common/meta.jsp" %>

    </head>

    <body>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/item-board_resources/js/materialize.js"/>"></script>

        <%--header link--%>
        <%@ include file="common/header.jsp" %>

         <c:forEach items="${user}" var="i">
            <c:set var="logErr" value="${i.searchError}"/>
         </c:forEach>

<%--
    поставила br поскольку хэдер "прилипал" к таблице
--%>
    <br>
    <br>
    <br>
    <br>

        <div class="form-wraper">        
            <h1 class="text-center" >Enter login/password:</h1>
            <form action="login.html" method="post">
                <input type="login" class="fullwidth" name="login"/>
                <input type="password" class="fullwidth" name="pass"/>
                <div class="error fullwidth"> <c:out value="${logErr}"/> </div>
                <input type="submit" class="fullwidth" value="Enter"/>
            </form>
            <hr>
            <a class="button1 text-center" href="/ItemBoardProj/register.html">Register</a>
        </div>
                
 
            
            
     <%--footer link--%>
        <%@ include file="common/footer.jsp" %>

    </body>
    
    
    
</html>