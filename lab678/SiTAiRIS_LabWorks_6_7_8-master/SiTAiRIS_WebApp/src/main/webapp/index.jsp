<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="Entities.*" %>
<%@ page import="XMLMarshalling.*" %>

<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Enterprise</title>
    </head>
    <style>
        html, body {
            margin: 0;
            padding: 0;
        }

        * {
            font-family: sans-serif;
        }

        h2 {
            margin: 30px auto;
            text-align: center;
            text-transform: uppercase;
            font-size: 32px;
        }

        h3 {
            margin: 22px auto;
            text-align: center;
            font-size: 24px;
        }

        .buttons {
            margin: 10px auto;
            padding: 30px 36px;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        button {
            padding: 24px 24px;
            outline: none;
            color: #fdfdf2;
            font-size: 22px;
            text-transform: uppercase;
            font-weight: bolder;
            border: 0;
            border-radius: 25px;
        }

        .button_1 {
            background-color: #940622;
        }

        .button_1:hover {
            background-color: #680414;
        }

        .button_2 {
            background-color: #068001;
        }

        .button_2:hover {
            background-color: #006c05;
        }

        .button_3 {
            background-color: #be8000;
        }

        .button_3:hover {
            background-color: #8f5e00;
        }

        table {
            border-collapse: collapse;
        }

        .table {
            margin: 16px auto;
            display: flex;
            flex-wrap: wrap;
            flex-direction: row;
            justify-content: center;
        }

        td, th {
            padding: 16px 10px;
            border-collapse: collapse;
            border: 2px solid black;
        }

        th {
            background-color: #47000c;
            color: antiquewhite;
        }

        td {
            background-color: #f1dfa0;
            color: #000000;
        }
    </style>
    <body>
        <h2>ООО "Третьекурсница"</h2>
        <h3>Администрация:</h3>
        <div class="table_administration table">
            <table>
                <tr>
                    <th>№</th>
                    <th>№ пропуска</th>
                    <th width="440">ФИО</th>
                    <th width="200">Должность</th>
                    <th>Возраст (лет)</th>
                    <th>Стаж (лет)</th>
                </tr>
                <%
                    Enterprise erp = new Enterprise();
                    erp.setAdministration(AdministrationList.getAdministrationList("D:\\SiTAiRIS_WebApp\\src\\main\\resources\\Enterprise.xml"));
                    for (int i = 0; i < erp.getAdministration().size(); i++) {
                        out.println("<tr>" +
                                    "<td>" +
                                    (i + 1)
                                    + "</td>" +
                                    "<td>" +
                                    erp.getAdministration().get(i).getPassNumber()
                                    + "</td>" +
                                    "<td width=\"440\">" +
                                    erp.getAdministration().get(i).getFullName()
                                    + "</td>" +
                                    "<td width=\"200\">" +
                                    erp.getAdministration().get(i).getPost()
                                    + "</td>" +
                                    "<td>" +
                                    erp.getAdministration().get(i).getAge()
                                    + "</td>" +
                                    "<td>" +
                                    erp.getAdministration().get(i).getStage()
                                    + "</td>" +
                                    "</tr>");
                    }
                %>
            </table>
        </div>
        <%
            int avgAge = 0, avgStage = 0;
            for (int i = 0; i < erp.getAdministration().size(); i++) {
                avgAge += (erp.getAdministration().get(i).getAge() / erp.getAdministration().size());
                avgStage += (erp.getAdministration().get(i).getStage() / erp.getAdministration().size());
            }
        %>
        <h3>Средний возраст руководителя: <%= avgAge%> лет</h3>
        <h3>Средний стаж руководителя: <%= avgStage%> лет</h3>
        <h3>Рабочие:</h3>
        <div class="table_employees table">
            <table>
                <tr>
                    <th>№</th>
                    <th>№ пропуска</th>
                    <th width="440">ФИО</th>
                    <th>Часы</th>
                    <th>Зарплата (BYN)</th>
                </tr>
                <%
                    erp.setEmployees(EmployeeList.getEmployeeList("D:\\SiTAiRIS_WebApp\\src\\main\\resources\\Enterprise.xml"));
                    for (int i = 0; i < erp.getEmployees().size(); i++) {
                        out.println("<tr>" +
                                "<td>" +
                                (i + 1)
                                + "</td>" +
                                "<td>" +
                                erp.getEmployees().get(i).getPassNumber()
                                + "</td>" +
                                "<td width=\"440\">" +
                                erp.getEmployees().get(i).getFullName()
                                + "</td>" +
                                "<td>" +
                                erp.getEmployees().get(i).getHours()
                                + "</td>" +
                                "<td>" +
                                erp.getEmployees().get(i).getSalary()
                                + "</td>" +
                                "</tr>");
                    }
                %>
            </table>
        </div>
        <%
            int sumHours = 0, sumSalary = 0;
            for (int i = 0; i < erp.getEmployees().size(); i++) {
                sumHours += erp.getEmployees().get(i).getHours();
                sumSalary += erp.getEmployees().get(i).getSalary();
            }
        %>
        <h3>Общее кол-во отработанных часов: <%= sumHours%> ч</h3>
        <h3>Общие доходы рабочих: <%= sumSalary%> BYN</h3>
        <div class="buttons">
            <div class="button">
                <button type="submit"
                        class="button_1"
                        onclick="location.href='/administration'">Просмотреть администрацию</button>
            </div>
            <div class="button">
                <button type="submit"
                        class="button_2"
                        onclick="location.href='/employee'">Просмотреть рабочих</button>
            </div>
            <div class="button">
                <button type="submit"
                        class="button_3"
                        onclick="location.href='/count_salary'">Рассчитать з/п рабочих</button>
            </div>
        </div>
    </body>
</html>

