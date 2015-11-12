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
                    $.each(responseJson, function (key, value) {
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

            $.get('find', {tableName: name}, function (responseJson) {
                if (responseJson != null) {
                    $("#countryTableFind").find("tr:gt(0)").remove();
                    var table1 = $("#countryTableFind");
                    var flag = false;
                    $.each(responseJson, function (key, value) {
                        if (key.valueOf() == 1) {
                            flag = true;
                        }
                        var rowNew = $("<tr><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text(value['id']);
                        rowNew.children().eq(1).text(value['name']);
                        rowNew.children().eq(2).text(value['password']);
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
            $('<p></p><div class="row test"><div class="col-xs-5 col-sm-4 col-md-3"><input type="text" class="form-control" name="table_name" placeholder="name"></div> <div class="col-xs-5 col-sm-4 col-md-3"> <input type="text" class="form-control" name="table_password" placeholder="password"></div><button type="button" class="btn-sm btn-action remove"><i class="fa fa-minus-circle"></i>  </button></div>').fadeIn('slow').appendTo('.inputs');
        });
        $('body').on('click', '.remove', function () {
            $(this).parent().remove();
        });

        $("#showClear").click(function () {
            var name = $('#inputClear').val();
            $.get('clear', {clear: name});
        });

        $("#showCreate").click(function () {
            $.ajax({
                type: "POST",
                url: "./create",
                data: jQuery("#myForm").serialize()
            });
        });

        $("#connect").click(function () {
            var db_name = $('#db_name').val();
            var user_name = $('#user_name').val();
            var password = $('#password').val();
            $.ajax({
                type: "POST",
                url: "./connect",
                data: {db_name: db_name, user_name: user_name, password: password}
            });
        });

        $(function () {
            $("[data-toggle='tooltip']").tooltip();
        });

        //при нажатии на кнопку с id="save"
        $('#save').click(function () {
            //переменная formValid

            var formValid = true;
            //перебрать все элементы управления input
            $('input').each(function () {
                //найти предков, которые имеют класс .form-group, для установления success/error
                var formGroup = $(this).parents('.form-group');

                //для валидации данных используем HTML5 функцию checkValidity
                if (this.checkValidity()) {
                    //добавить к formGroup класс .has-success, удалить has-error
                    formGroup.addClass('has-success').removeClass('has-error');

                } else {
                    //добавить к formGroup класс .has-error, удалить .has-success
                    formGroup.addClass('has-error').removeClass('has-success');

                    //отметить форму как невалидную
                    formValid = false;
                }
            });

            if (formValid) {
                var db_name = $('#db_name').val();
                var user_name = $('#user_name').val();
                var password = $('#password').val();

                $('#myModal').modal('hide');
                $('#connectDiv').addClass('hidden');
                $('#success-alert').removeClass('hidden');


                $.ajax({
                    type: "POST",
                    url: "./connect",
                    data: {db_name: db_name, user_name: user_name, password: password}
                });

            }
        });


    }
);


