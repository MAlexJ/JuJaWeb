<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="jumbotron top-space">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="tabs">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab-1" data-toggle="tab">Connect</a></li>
                        <li><a href="#tab-2" data-toggle="tab">CRUD operation</a></li>
                        <li><a href="#tab-3" data-toggle="tab">Info</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab-1">

                            <form action="create" name="form_create" class="navbar-form" method="post">
                                <div class="form-group">
                                    <br>

                                    <p>
                                        Database name <br>
                                        <input type="text" class="form-control" name="db_name"> <br>
                                    </p>

                                    <p>
                                        User name <br>
                                        <input type="text" class="form-control" name="user_name"> <br>
                                    </p>

                                    <p>
                                        Password <br>
                                        <input type="password" class="form-control" name="password"> <br><br>
                                    </p>
                                    <button type="submit" class="btn btn-info"><i class="fa fa-sign-in"></i> Enter
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="tab-2">
                            <br>

                            <p>Item 2</p>
                        </div>
                        <div class="tab-pane fade" id="tab-3">
                            <br>

                            <p>Item 3</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

