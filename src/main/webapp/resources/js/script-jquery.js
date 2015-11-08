$(document).ready(function () {

        $(".headroom").headroom({
            "tolerance": 20,
            "offset": 50,
            "classes": {
                "initial": "animated",
                "pinned": "slideDown",
                "unpinned": "slideUp"
            }
        });

        $("#tablediv").hide();
        $("#showTable").click(function (event) {
            $.get('tables', function (responseJson) {
                if (responseJson != null) {
                    $("#countrytable").find("tr:gt(0)").remove();
                    var table1 = $("#countrytable");
                    $.each(responseJson, function (key,value) {
                        var rowNew = $("<tr><td></td></tr>");
                        rowNew.children().eq(0).text(value.toString());
                        rowNew.appendTo(table1);
                    });
                }
            });
            $("#tablediv").show();
        });

        $("#tableFind").hide();
        $("#showFind").click(function (event) {
            var name = $('#inputFind').val();

            $.get('find', {userName: name}, function (responseJson) {
                if (responseJson != null) {
                    $("#countryTableFind").find("tr:gt(0)").remove();
                    var table1 = $("#countryTableFind");
                    var flag = false;
                    $.each(responseJson, function (key, value) {
                        if (key.valueOf() == 1) {
                            flag = true;
                        }
                        var rowNew = $("<tr><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text(value['name']);
                        rowNew.children().eq(1).text(value['password']);
                        rowNew.children().eq(2).text(value['id']);
                        rowNew.appendTo(table1);
                    });
                    if (flag) {
                        $("#tableFind").show();
                    } else {
                        $("#tableFind").hide();
                    }

                }
            });

        });


        $('body').on('click', '.add', function () {
            $('<p></p><div class="row test"><div class="col-xs-5 col-sm-4 col-md-3"><input type="text" class="form-control table_name" name="table_name" placeholder="name"></div> <div class="col-xs-5 col-sm-4 col-md-3"> <input type="password" class="form-control table_password" name="table_password" placeholder="password"></div>  <button type="button" class="btn-sm btn-action remove"><i class="fa fa-minus-circle"></i>  </button></div>').fadeIn('slow').appendTo('.inputs');
        });
        $('body').on('click', '.remove', function () {
            $(this).parent().remove();
        });

        $("#showCreate").click(function () {
            $('#myForm').ajaxSubmit(function () {
            });
        })
    }
);


