<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
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



        <br>

        <div class="container" style="text-align: left; display: flex; flex-wrap: wrap; justify-content: center; ">
            <br>
            <br>
            <a href="item.html?id=${displayitem.id}"> </a>  

                <div class="header col s12 light" >
                    <figure style="margin-left: 0px; "tabindex="1">  <img src="${displayitem.pic}"style ="  border-radius: 10px; padding: 15px; margin: 20px; font-size: 0.7em; background-color: #e3e3e3; display: inline-block; float: left; align-content: center; " width=480px height=320px /><figcaption style=" margin-left: 20px; font-family: cursive; color:black; text-shadow: 5px 2px 4px grey; font-size: x-large; width: 480px; height: 95px;"><br><p style="text-align: center; ">${displayitem.name}</p></figcaption>

                        <div class ="bodo" style="  margin-left: 600px; margin-top: 30px; font-family: cursive; font-size: 17pt;">
                            <p style="color:greenyellow; margin-top: -100px">Price: ${displayitem.price} UAH </p>
                            <p style="margin-top: 15px;"> <img src="http://s1.iconbird.com/ico/2013/11/504/w128h1281385326570phone.png" style="width: 28px; height: 28px;">${displayitem.phone}</p>
                            <p style="color:black; text-shadow: 5px 2px 4px white; margin-top: 15px; margin-left: 50px;"><img src="http://s1.iconbird.com/ico/1012/EcommerceBusinessIcons/w128h1281350822895admin128x128.png" style="width: 128px; height: 128px; margin-left: -70px; float:left;"></p> 
                            <div class="owner" style="width: 445px; height: 130px; font-size: 16pt; background-color: lightblue;"> Owner:</p> ${displayitem.owner}</p>
                                <p>City: ${displayitem.city}</p>
                                <p>Date: ${displayitem.date}</p>
                            </div>

                           
                            <%--<hr>--%>
                             </div>
                        <div class="about" style="text-align: center; position: relative;  border: 2px solid lightskyblue; border-radius: 4px; background: url(https://image.freepik.com/free-photo/no-translate-detected_1253-505.jpg) 100% 100% no-repeat; background-size: cover; font-family: cursive; font-size: 15pt; margin-left: 20px; margin-top: 160px; color:black; text-shadow: 5px 2px 4px grey; font-size: large; width: 480px; ">About item: ${displayitem.about}
                        </div>
                        <c:if test="${not empty login}" >
                                <button class="btn-large waves-effect waves-light orange" type="submit" name="action" style=" margin-top: -88px; margin-left: 750px;">
                                    <a class="white-text"  href="pay.html?id=${displayitem.id}"> Pay
                                        <i class="material-icons right">payment</i></a>
                                </button>
                            </c:if>
                         
                         
                </div>
        </div>


        <%--footer link--%>
        <%@ include file="common/footer.jsp" %>

    </body>
</html>

