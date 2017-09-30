<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Add Item</title>
        <%--meta link--%>
        <%@ include file="common/meta.jsp" %>
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
    </head>

    <body>
        
        <br>
        <br>
        <br>

        <div class="form-wraper">
            <form action="create.html">
                name: <input name="name"/><br>
                pic: <input  name="pic" /><br>

                    <select name="cat" style="height: 35px; text-decoration: none">
                        <option value="a" selected = "selected">    Car</option>
                        <option value="h">    Weapon</option>
                    </select>
                price:<input name="price" /><br>
                about:<input  name="about" /><br>
                <input class="button1 text-center"  type="submit" value="Create"/>
            </form>

        </div>
        <br>
    </div>
</body>
        <%--footer link--%>
        <%@ include file="common/footer.jsp" %>
    
</html>
<a href="../../../java/controller/CreateController.java"></a>