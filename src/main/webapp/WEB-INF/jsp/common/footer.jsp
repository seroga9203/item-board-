
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<footer class="page-footer orange" >
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Company Bio</h5>
                <p class="grey-text text-lighten-4">We are a team of course students working on this project: Yevheniia Vorobei, Pohorelaia Anna, Dana Muzyka, Bazeliuk Volodimir, Kovalenko Serhii , Burliaiev Ivan</p>
            </div>
            <div class="col l3 s12">
                <h5 class="white-text">SITEMAP</h5>
                <ul>
                    <c:choose>
                    <c:when test="${not empty login}" >
                        <li><a class="white-text" href="main.html">Home</a></li>
                        <li><a class="white-text" href="create.html">New Item</a></li>
                    </c:when>
                        <c:otherwise>
                            <li><a class="white-text" href="main.html">Home</a></li>
                            <li><a class="white-text" href="login.html">Login</a></li>
                            <li><a class="white-text" href="register.html">Registration</a></li>
                        </c:otherwise>
                        </c:choose>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            Made by students of <a class="orange-text text-lighten-3" href="https://mainacad.com">Main Academy</a>
        </div>
    </div>
</footer>