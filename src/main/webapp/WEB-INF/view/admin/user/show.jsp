<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="" />
            <meta name="author" content="" />
            <title>Dashboard - Admin</title>
            <!-- /css de no map tu rootapp  -->
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
            <!-- Begin Top nav -->
            <jsp:include page="../layout/header.jsp" />
            <!-- End Top nav -->
            <div id="layoutSidenav">
                <!-- Begin Left menu -->
                <jsp:include page="../layout/sidebar.jsp" />
                <!-- End Left menu -->
                <!-- Begin Right content -->
                <div id="layoutSidenav_content">
                    <!-- Begin Main -->
                    <main>
                        <div class="container">
                            <div class="row">
                                <div class="header">User</div>
                            </div>
                            <div class="row">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">id</th>
                                            <th scope="col">avatar</th>
                                            <th scope="col">FullName</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Address</th>
                                            <th scope="col">Phone</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="s" items="${users}">
                                            <tr>
                                                <th scope="row">${s.id}</th>
                                                <th><img src="${s.avatar}" alt="${s.fullName}"></th>
                                                <th>${s.fullName}</th>
                                                <td>${s.email}</td>
                                                <td>${s.address}</td>
                                                <td>${s.phone}</td>
                                                <td>
                                                    <ul>
                                                        <li>
                                                            <a href="/admin/user/${s.id}">
                                                                <div class="btn btn-success">Detail</div>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </main>
                    <!-- End Main -->
                    <jsp:include page="../layout/footer.jsp" />
                </div>
                <!-- End Right content -->
            </div>
            <script src="js/scripts.js"></script>

        </body>

        </html>