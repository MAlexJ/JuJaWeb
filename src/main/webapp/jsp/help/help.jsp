<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="modal fade" id="modal-help">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">  &times;   </button>
                <h4 class="modal-title">Help</h4>
            </div>
            <div class="modal-body">
               <p>Существующие команды:</p>
                <br>
                connect|databaseName|userName|password"<br>
                для подключения к базе данных, с которой будем работать<br>
                <br><br>
                tables<br>
                для получения списка всех таблиц базы, к которой подключились<br>
                <br><br>
                clear|tableName<br>
                для очистки всей таблицы<br>
                <br><br>
               create|tableName|column1|value1|column2|value2|...|columnN|valueN"<br>
               для создания записи в таблице<br>
                <br><br>
                find|tableName<br>
                для получения содержимого таблицы 'tableName'<br>
                <br><br>
                help<br>
                для вывода этого списка на экран<br>
                <br><br>
                exit<br>
                для выхода из программы<br>
            </div>
            <div class="modal-footer">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Отмена</button>
            </div>
        </div>
    </div>
</div>