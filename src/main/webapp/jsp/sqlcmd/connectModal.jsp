<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title" id="myModalLabel">Connection</h4>
            </div>
            <form role="form" class="form-horizontal" method="post" action="connect">
                <div class="modal-body">

                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-3">Database name:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control" required="required" name="db_name"
                                       pattern="[A-Za-z]{1,}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-3"> User name:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control" required="required" name="user_name"
                                       pattern="[A-Za-z]{1,}">
                            </div>

                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-xs-3"> Password:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <input type="text" class="form-control" required="required" name="password"
                                       pattern="[A-Za-z]{1,}">
                            </div>

                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Back</button>
                    <button id="save" type="submit" class="btn btn-primary">Enter</button>
                </div>
            </form>
        </div>
    </div>
</div>

