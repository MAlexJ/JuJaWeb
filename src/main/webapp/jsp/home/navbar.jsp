<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><img src="resources/images/logo.png"
                                                          alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right" id="text_header">
                <c:choose>
                    <c:when test="${flag eq 'sqlcmd'}">
                        <li><a href="home">Home</a></li>
                        <li class="active"><a href="sqlcmd">SQLcmd</a></li>
                        <li><a href="help">Help</a></li>
                    </c:when>
                    <c:when test="${flag eq 'help'}">
                        <li><a href="home">Home</a></li>
                        <li><a href="sqlcmd">SQLcmd</a></li>
                        <li class="active"><a href="help">Help</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="active"><a href="home">Home</a></li>
                        <li><a href="sqlcmd">SQLcmd</a></li>
                        <li><a href="help">Help</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

