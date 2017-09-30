<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Register Page</title>
        <%--meta link--%>
        <%@ include file="common/meta.jsp" %>
</head>
<body>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/item-board_resources/js/materialize.js"/>"></script>

    <%--header link--%>
    <%@ include file="common/header.jsp" %>

    <%--    поставила br поскольку хэдер "прилипал" к таблице--%>
    <br>
    <br>
    <br>
    <br>


    <c:set var="myName" value=""/>
    <c:forEach items="${user}" var="i">
        <c:set var="loginErr" value="${i.loginErr}"/>
        <c:set var="login" value="${i.login}"/>
        <c:set var="passwErr" value="${i.passwErr}"/>
        <c:set var="phoneErr" value="${i.phoneErr}"/>
        <c:set var="phone" value="${i.phone}"/>
        <c:set var="email" value="${i.email}"/>
        <c:set var="emailErr" value="${i.emailErr}"/>
        <c:set var="city" value="${i.city}"/>  
        <c:set var="cityErr" value="${i.cityErr}"/>  
    </c:forEach>

    <div class="form-wraper">        
        <h1  class="text-center">Register:</h1>
        <form action="register.html" method="POST">

            <label class="fullwidth" for="login">login: </label>
            <input id="login" name="login" class="fullwidth" value="<c:out value="${login}"/>"/> 
            <div class="error fullwidth"><c:out value="${loginErr}"/></div>
            
            <label class="fullwidth" for="pass">password: </label>
            <input id="pass" type="password" class="fullwidth" name="pass" /> 
            <div class="error fullwidth"><c:out value="${passwErr}"/></div>
            
            <label class="fullwidth" for="checkPass">check password: </label>
            <input id="checkPass" type="password" class="fullwidth" name="checkPass" />
            
            <label class="fullwidth" for="phone">phone: </label>
            <input id="phone" type="phone" name="phone" class="fullwidth"  value="<c:out value="${phone}"/>"/> 
            <div class="error fullwidth"><c:out value="${phoneErr}"/></div>
            
            <label class="fullwidth" for="email">email: </label>
            <input id="email" type="email" name="email" class="fullwidth" value="<c:out value="${email}"/>"/> 
            <div class="error fullwidth"><c:out value="${emailErr}"/></div>
            
            
            <label class="fullwidth" for="city">city: </label>
            <input id="city" type="city" name="city" class="fullwidth" value="<c:out value="${city}"/>"/> 
            <div class="error fullwidth"><c:out value="${cityErr}"/></div>

            <input type="submit" class="fullwidth" value="register" />
        </form>
        <a class="button1 text-center" href="/ItemBoardProj/main.html">Main</a>
    </div>

    <%--footer link--%>
    <%@ include file="common/footer.jsp" %>    	

</body>
</html>
