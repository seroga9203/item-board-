<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paid  Service</title>
        <%--meta link--%>
        <%@ include file="common/meta.jsp" %>
        <link href="<c:url value="/resources/item-board_resources/css/pay.css" />" rel="stylesheet">
        <%--<link href="<c:url value="/resources/item-board_resources/css/pay.css" />" rel="stylesheet1">--%>
        
       <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
       <%--<link rel="stylesheet1" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css1">--%>


       
    </style>  
</head>
<body>
    
    
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/item-board_resources/js/materialize.js"/>"></script>

    
    <%--header link--%>

    <%@ include file="common/header.jsp" %>
    <c:if test="${not empty login}" >

        <div class="parent">
            <h1 style="color: #004d1a">Paid Service</h1>

<br>
            <form action="pay.html"><!-- input зоздает элемент для зоздания текстовых полей -->
                <!--<input type="button" class="button" value="In top"/>   -->    
                <input type="hidden" name="id" value="${id}"/>    
                <input type="hidden" name="isTop" value="True"/> 
                <input type="submit" class="buttonP" value="In Top"/> 
            </form>
                <br>
                <br>
            <form>
                <input type="hidden" name="id" value="${id}"/>    
                <input type="hidden" name="Date" value="True"/> 
                <input type="submit" class="buttonP" value="Update Date"/> 
            </form>
                <br>
        </div>
    </c:if>
    <%--footer link--%>
    <%@ include file="common/footer.jsp" %>

</body>
</html>
