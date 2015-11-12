<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<div class="container" id="connectDiv">
    <div class="row">
        <div class="col-xs-3">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"
                    title="Database Connection">
                <i class="fa fa-sign-in"></i>
                Connect
            </button>
        </div>
    </div>
</div>
<jsp:include page="../sqlcmd/connectModal.jsp" flush="true"/>