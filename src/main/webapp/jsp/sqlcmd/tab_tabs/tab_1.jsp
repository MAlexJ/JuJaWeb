<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
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

        <button type="submit" class="btn btn-info">
            <i class="fa fa-sign-in"></i>
            Enter
        </button>
    </div>
</form>