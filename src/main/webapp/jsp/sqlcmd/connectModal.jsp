<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title" id="myModalLabel">Connection</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal">
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-3">Database name:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control" required="required" id="db_name"
                                       pattern="[A-Za-z]{1,}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-3"> User name:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control" required="required" id="user_name"
                                       pattern="[A-Za-z]{1,}">
                            </div>

                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-3"> Password:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control" required="required" id="password"
                                       pattern="[A-Za-z]{1,}">
                            </div>

                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Back</button>
                <button id="save" type="button" class="btn btn-primary">Enter</button>
            </div>
        </div>
    </div>
</div>

