<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<br>

<p>

<h3>Консольное приложение</h3></p>

<p>
    В примере показана реализация простого консольного приложения Java в JEE.<br>
    Это приложение вводит комманду с клавиатуры, а затем отображает его на консоли.<br>
    <br>
    Исходный текст примера

<pre>
package ua.com.juja.sqlcmd.controller;

import ua.com.juja.sqlcmd.controller.command.*;
import ua.com.juja.sqlcmd.controller.command.impl.*;
import ua.com.juja.sqlcmd.controller.controller.Controller;
import ua.com.juja.sqlcmd.controller.controller.impl.MainController;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.model.sample.JDBCDatabaseManager;
import ua.com.juja.sqlcmd.view.impl.Console;
import ua.com.juja.sqlcmd.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager manager = new JDBCDatabaseManager();
        Command[] commands = new Command[]{
                new Help(view),
                new Exit(view),
                new Connect(manager, view),
                new Create(manager, view),
                new Find(manager, view),
                new Tables(manager, view),
                new Clear(manager, view)
        };
        Controller controller = new MainController(view, manager, commands);
        controller.run();
    }
}

</pre>
<br>
<h4>Немного теории</h4>

Главный класс консольного приложения должен называться точно так же, как и файл исходного текста этого класса.<br>

В этом классе необходимо определить статический метод с именем main. Данный метод играет роль точки входа приложения,
то есть ему будет передано управление сразу после запуска консольного приложения.<br>

В качестве стандартного потока вывода консольное приложение использует поток java.lang.System.out,
а в качестве стандартного потока ввода - java.lang.System.in.
Есть и стандартный поток для вывода сообщений об ошибках - java.lang.System.err.<br>
</p>