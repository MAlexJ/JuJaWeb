<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="tabs">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab-1" data-toggle="tab">CRUD operation</a></li>
                    <li><a href="#tab-2" data-toggle="tab">Info</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="tab-1">
                        <jsp:include page="tab_tabs/tab_1.jsp" flush="true"/>
                    </div>
                    <div class="tab-pane fade" id="tab-2">
                        <jsp:include page="tab_tabs/tab_2.jsp" flush="true"/>
                    </div>
                </div>
            </div>
        </div>
        <br>
    </div>
</div>




