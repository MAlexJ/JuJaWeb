<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<br>

<div class="row">
    <div class="col-md-12">
        <button type="button" class="btn btn-info" id="showTable">
            <i class="fa fa-angle-down"></i>Tables
        </button>
        <br>

        <div id="tablediv">
            <table class="table" cellspacing="0" id="countrytable" align="center">
                <tr>
                    <th scope="col">Name</th>
                </tr>
            </table>
        </div>
    </div>
</div>
<br>

<div class="row">
    <div class="col-md-12">
        <a href="#spoiler-2" class="btn btn-info" data-toggle="collapse"><i class="fa fa-angle-down"></i>
            Clear</a>

        <div class="collapse" id="spoiler-2">
            <div class="well">
                <div class="form-group">
                    <input type="text" class="form-control" name="table_name" placeholder="Name table" id="inputClear">
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-success" id="showClear">Enter</button>
                </div>
            </div>
        </div>
    </div>
</div>
<br>

<div class="row">
    <div class="col-md-12">
        <a href="#spoiler-3" class="btn btn-info" data-toggle="collapse">
            <i class="fa fa-angle-down"></i>Create</a>

        <div class="collapse" id="spoiler-3">
            <div class="well inputCreate" id="inputCreate">
                <form id="myForm" method="get">
                    <div class="row">
                        <div class="col-xs-5 col-sm-4 col-md-3"><input type="text" class="form-control table_name"
                                                                       name="table_name" placeholder="name">
                        </div>
                        <div class="col-xs-5  col-sm-4  col-md-3"><input type="password"
                                                                         class="form-control table_password"
                                                                         name="table_password" placeholder="password">
                        </div>
                        <button type="button" class="btn-sm btn-info add"><i class="fa fa-plus"></i> Add</button>
                    </div>
                    <div class="container">
                        <div class="row inputs">
                        </div>
                    </div>
                    <br>

                    <div class="row">
                        <div class="form-group col-xs-3">
                            <button type="button" class="btn btn-success" id="showCreate">Enter</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>
<br>

<div class="row">
    <div class="col-md-12">
        <a href="#spoiler-1" class="btn btn-info" data-toggle="collapse"><i class="fa fa-angle-down"></i>
            Find</a>

        <div class="collapse" id="spoiler-1">
            <div class="well">
                <div class="form-group">
                    <input type="text" class="form-control" name="table_name" placeholder="Name table" id="inputFind">
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-success" id="showFind">Enter</button>
                </div>
            </div>
        </div>

        <div id="tableFind">
            <table class="table" cellspacing="0" id="countryTableFind" align="center">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Password</th>
                </tr>
            </table>
        </div>
    </div>
</div>
<br>

<div class="row">
    <div class="col-md-12">
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modal-help">
            <i class="fa fa-info"></i> Help
        </button>
        <jsp:include page="/jsp/help/help.jsp" flush="true"/>
    </div>
</div>