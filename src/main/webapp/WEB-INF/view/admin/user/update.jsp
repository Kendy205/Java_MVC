<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link href="/css/demo.css" rel="stylesheet">
            </head>

            <body>
                <div class="container-fluid">
                    <div class="row mx-auto">
                        <form:form method="post" action="/admin/user/update" modelAttribute="newUser">
                            <div class="form-group" style="display: none;">
                                <label for="">Id</label>
                                <form:input type="text" name="id" id="" class="form-control" placeholder=""
                                    aria-describedby="helpId" path="id" />

                            </div>
                            <div class="form-group">
                                <label for="">Email</label>
                                <form:input type="text" name="email" id="" class="form-control" placeholder=""
                                    aria-describedby="helpId" path="email" />

                            </div>
                            <div class="form-group">
                                <label for="">FullName</label>
                                <form:input type="text" id="" class="form-control" placeholder=""
                                    aria-describedby="helpId" path="fullName" />

                            </div>
                            <div class="form-group">
                                <label for="">Address</label>
                                <form:input type="text" name="" id="" class="form-control" placeholder=""
                                    aria-describedby="helpId" path="address" />

                            </div>
                            <div class="form-group">
                                <label for="">phone</label>
                                <form:input type="text" name="phone" id="" class="form-control" placeholder=""
                                    aria-describedby="helpId" path="phone" />

                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form:form>
                    </div>
                </div>

            </body>

            </html>