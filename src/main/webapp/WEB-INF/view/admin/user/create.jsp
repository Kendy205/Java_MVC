<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
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
                            <div class="container-fluid">
                                <div class="row mx-auto">
                                    <form:form method="post" enctype="multipart/form-data" action="/admin/user/created"
                                        modelAttribute="newUser">

                                        <div class="form-group">
                                            <label for="">Avatar</label>
                                            <input class="form-control" type="file" id="avatarFile" name="hoidanitFile"
                                                accept=".png, .jpg, .jpeg" />
                                            <img id="avatarPreview" />
                                        </div>
                                        <div class="form-group">
                                            <label for="">Email</label>
                                            <form:input type="text" name="email" id="" class="form-control"
                                                placeholder="" aria-describedby="helpId" path="email" />

                                        </div>
                                        <div class="form-group">
                                            <label for="">password</label>
                                            <form:input type="text" name="pw" id="" class="form-control" placeholder=""
                                                aria-describedby="helpId" path="password" />

                                        </div>
                                        <div class="form-group">
                                            <label for="">Address</label>
                                            <form:input type="text" name="" id="" class="form-control" placeholder=""
                                                aria-describedby="helpId" path="address" />

                                        </div>
                                        <div class="form-group">
                                            <label for="">phone</label>
                                            <form:input type="text" name="phone" id="" class="form-control"
                                                placeholder="" aria-describedby="helpId" path="phone" />

                                        </div>
                                        <div class="form-group">
                                            <!-- path: doi tuong role (thuoc tinh name) -->
                                            <form:select class="form-select" path="role.name">
                                                <form:option value="ADMIN">ADMIN</form:option>
                                                <form:option value="USER">USER</form:option>
                                            </form:select>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form:form>
                                </div>
                            </div>
                        </main>
                        <!-- End Main -->
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                    <!-- End Right content -->
                </div>
                <script src="/js/scripts.js"></script>

            </body>

            </html>