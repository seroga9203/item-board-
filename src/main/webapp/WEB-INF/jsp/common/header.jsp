<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<header>

    <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container"><a href="main.html"><img src="http://i.piccy.info/i9/b1fbf0375d8a5d40438793410f1a5091/1504113734/59299/1175533/sign.png" width="50"  height="60" id="logo-container"class="brand-logo"></a>

                <div class="nav-wrapper container"><a href="main.html"><span align="left" class="orange-text text-lighten-3">ITEM BOARD</span></a>
                <c:choose>
                <c:when test="${not empty login}" >
                    <ul class="right hide-on-med-and-down">
                        <li><a href="main.html?exit=true">Log Out</a></li>
                    </ul>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="change.html">My Profile</a></li>
                    </ul>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="create.html">New Item</a></li>
                    </ul>

                </c:when>
                <c:otherwise>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="login.html">Login/Register</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
            <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
        </div>
    </nav>

</header>