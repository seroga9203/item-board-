<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

        <script type="text/javascript">
            $(document).ready(function () {
                $('select').material_select();
            });
        </script>

        <%--header link--%>
        <%@ include file="common/header.jsp" %>

        <%-- SEARCH BLOCK --%>

        <br>
        <br>
        <br>
        <br>
        <br>

        <div class="fieldset">
            <form action="search.html">
                <div style=" width: 25%; float: left; translateY(20%); margin-left: 15px; margin-top: 10px; margin-bottom: 25px; background: white; height: 46px; border-radius: 4px;">
                    <div>
                        <select style="height: 35px; text-decoration: none" name="categories">
                            <option value="all" selected = "selected">    All</option>
                            <option value="a">    Cars</option>
                            <option value="h">    Weapon</option>
                            <option value="e">    Real Estate</option>
                        </select>
                    </div>
                </div>

                <div style=" width: 35%;  display: inline-block; transform: translateY(20%);  margin-left:30px; margin-top: 2px; margin-bottom: 24px; background: white; height: 46px; border-radius: 4px;">
                    <input align="center" id="icon_telephone" type="search" class="validate" placeholder="     Search..." style=" display: inline-block; text-indent: 25px" name="searchword">
                </div>

                <div align="right" style=" width: 33%; float: right; transform: translateY(20%); margin-left: 10px;  margin-right: 15px; margin-top: 6px; margin-bottom: 10px; height: 46px; border-radius: 4px;">
                    <button class="btn waves-effect waves-light" type="submit" value="Search">Search
                        <i class="material-icons right">search</i>
                    </button>
                </div>
            </form>
        </div>

        <br>
        <br>

        <%--
                           <input type="submit" value="Search"/>
            </form><hr>--%>
        <%-- SEARCH BLOCK END --%>

        <h3><p>Top advertisments</p></h3><hr><br>
        <div class="topAdvertisments">
            <c:choose>
                <c:when test="${not empty topItems}" >
                    <c:forEach items="${topItems}" var="i">
                        <div class="itemsTop">
                            <a href="item.html?id=${i.id}"><img src="${i.pic}" width="200" height="130"/><br>
                                <p class="topAdvertismentsText">Name: ${i.name}<br>
                                Price: ${i.price} UAH<br>
                                </p>
                            </a>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <a href="pay.html"><h3>Promote your advertisment!</h3></a><br><hr>
                </c:otherwise>
            </c:choose>
        </div><hr>

        <h3><p>Simple advertisments</p></h3><hr>
        <div class="content-box">
            <c:forEach items="${displayitem}" var="i">
                <a href="item.html?id=${i.id}"><div class="simpleItems">
                    <img src="${i.pic}" width="170" height="100"/><br>
                    Name: ${i.name}<br>
                    City: ${i.city}<br>                  
                    Price: ${i.price} UAH
                    </div>
                </a>
                <hr>
            </c:forEach>
        </div>

        <div class="content-box">
            <c:if test="${not empty errorSearch}" >
                <br>
                <br>
                <br>
                <br>
                <h6 style="font-size: 25px;  color: red;">${errorSearch}</h6>
                <br>
                <br>
                <br>
                <br>
            </c:if>
        </div>
        <%--footer link--%>
        <%@ include file="common/footer.jsp" %>

    </body>
</html>
