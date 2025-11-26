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
                        <div class="card" style="width: 60%">
                            <div class="card-header">
                                User information
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">ID: ${user.id}</li>
                                <li class="list-group-item">Email: ${user.email}</li>
                                <li class="list-group-item">FullName: ${user.fullName}</li>
                                <li class="list-group-item">Address: ${user.address}</li>
                            </ul>
                        </div>
                        <a href="/admin/user" class="btn btn-success mt-3">Back</a>
                    </main>
                    <!-- End Main -->
                    <jsp:include page="../layout/footer.jsp" />
                </div>
                <!-- End Right content -->
            </div>
            <script src="js/scripts.js"></script>

        </body>

        </html>