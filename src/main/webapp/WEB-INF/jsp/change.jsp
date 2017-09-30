<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>

        <title>Change Page</title>
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
        <c:set var="login" value="${i.login}"/>
        <c:set var="passwErr" value="${i.passwErr}"/>
        <c:set var="phoneErr" value="${i.phoneErr}"/>
        <c:set var="phone" value="${i.phone}"/>
        <c:set var="email" value="${i.email}"/>
        <c:set var="emailErr" value="${i.emailErr}"/>
        <c:set var="city" value="${i.city}"/>  
        <c:set var="cityErr" value="${i.cityErr}"/>  
        <c:set var="identPasswError" value="${i.identPasswError}"/> 
        <c:set var="currPasswError" value="${i.currPasswError}"/> 

    </c:forEach>
    <div class="form-wraper" >   
        <h1 class="text-center">Change <c:out value="${login}"/></h1>
        <form action="change.html" method="post">
            <div class="error fullwidth"><c:out value="${identPasswError}"/></div>
            <label class="fullwidth" for="pass">current password: </label>
            <input id="pass" class="fullwidth" type="password" name="currPass"/>
            <div class="error fullwidth"><c:out value="${currPasswError}"/></div>
            
            <label class="fullwidth" for="pass" style=" margin-top: 30px; display: block;" >new password: </label>
            <input id="pass" class="fullwidth" type="password" name="pass"  />
            <div class="error fullwidth"><c:out value="${passwErr}"/></div>
            
            <label class="fullwidth" for="checkPass">check password: </label>
            <input id="checkPass" class="fullwidth" type="password" name="checkPass" />
            
            <label class="fullwidth" for="phone">phone: </label>
            <input id="phone" class="fullwidth" type="phone" name="phone" value="<c:out value="${phone}"/>"/>
            <div class="error fullwidth"><c:out value="${phoneErr}"/></div>
            
            <label class="fullwidth" for="email">email: </label>
            <input id="email" class="fullwidth" type="email" name="email" value="<c:out value="${email}"/>"/>
            <div class="error fullwidth"><c:out value="${emailErr}"/></div>
            
            <label class="fullwidth" for="city">city: </label>
            <input id="city" class="fullwidth" name="city" value="<c:out value="${city}"/>"/>
            <div class="error fullwidth"><c:out value="${cityErr}"/></div>

            <input class="fullwidth" type="submit" value="change" />
        </form>
        <hr><form action="main.html">
            <input type="submit" value="Main"/>
        </form>
    </div>

    <%--footer link--%>
    <%@ include file="common/footer.jsp" %>
</body>
</html>

