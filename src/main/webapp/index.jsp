<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>JuJaWeb</title>
    <link rel="shortcut icon" href="resources/images/gt_favicon.png">
    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="resources/css/main.css">
    <script src="resources/js/html5shiv.js"></script>
    <script src="resources/js/respond.min.js"></script>
</head>
<body class="home">

<jsp:include page="jsp/navbar.jsp" flush="true"/>
<jsp:include page="jsp/header.jsp" flush="true"/>

<c:choose>
    <c:when test="${flag eq 'sqlcmd'}">
        <jsp:include page="jsp/sqlcmd/introSQLcmd.jsp" flush="true"/>
        <jsp:include page="jsp/sqlcmd/tabsSQLcmd.jsp" flush="true"/>
    </c:when>
    <c:when test="${flag eq 'help'}">
        <h1>help</h1>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal-help">Help</button>
        <jsp:include page="jsp/help.jsp" flush="true"/>
    </c:when>
    <c:when test="${flag eq 'contact'}">
        <h1>contact</h1>
    </c:when>
    <c:otherwise>
        <jsp:include page="jsp/intro.jsp" flush="true"/>
        <jsp:include page="jsp/jumbotron.jsp" flush="true"/>
        <jsp:include page="jsp/container.jsp" flush="true"/>
    </c:otherwise>
</c:choose>

<jsp:include page="jsp/footer.jsp" flush="true"/>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/headroom.min.js"></script>
<script src="resources/js/jQuery.headroom.min.js"></script>
<script src="resources/js/template.js"></script>
</body>
</html>