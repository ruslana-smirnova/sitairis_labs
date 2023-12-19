package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entities.*;
import xmlmarshalling.AdministrationList;
import xmlmarshalling.EmployeeList;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"ru\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("        <title>Enterprise</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <style>\r\n");
      out.write("        html, body {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        * {\r\n");
      out.write("            font-family: sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("            margin: 30px auto;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("            font-size: 32px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h3 {\r\n");
      out.write("            margin: 22px auto;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-size: 24px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .buttons {\r\n");
      out.write("            margin: 10px auto;\r\n");
      out.write("            padding: 30px 36px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: row;\r\n");
      out.write("            flex-wrap: wrap;\r\n");
      out.write("            justify-content: space-around;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        button {\r\n");
      out.write("            padding: 24px 24px;\r\n");
      out.write("            outline: none;\r\n");
      out.write("            color: #fdfdf2;\r\n");
      out.write("            font-size: 22px;\r\n");
      out.write("            text-transform: uppercase;\r\n");
      out.write("            font-weight: bolder;\r\n");
      out.write("            border: 0;\r\n");
      out.write("            border-radius: 25px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button_1 {\r\n");
      out.write("            background-color: #940622;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button_1:hover {\r\n");
      out.write("            background-color: #680414;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button_2 {\r\n");
      out.write("            background-color: #068001;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button_2:hover {\r\n");
      out.write("            background-color: #006c05;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button_3 {\r\n");
      out.write("            background-color: #be8000;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .button_3:hover {\r\n");
      out.write("            background-color: #8f5e00;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        td, th {\r\n");
      out.write("            padding: 16px 10px;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("            border: 2px solid black;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        th {\r\n");
      out.write("            background-color: #47000c;\r\n");
      out.write("            color: antiquewhite;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        td {\r\n");
      out.write("            background-color: #f1dfa0;\r\n");
      out.write("            color: #000000;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h2>ООО \"Третьекурсница\"</h2>\r\n");
      out.write("        <h3>Администрация:</h3>\r\n");
      out.write("        <div class=\"table_administration table\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>№ п/п</th>\r\n");
      out.write("                    <th>№ пропуска</th>\r\n");
      out.write("                    <th width=\"440\">Ф.И.О.</th>\r\n");
      out.write("                    <th width=\"200\">Должность</th>\r\n");
      out.write("                    <th>Возраст (лет)</th>\r\n");
      out.write("                    <th>Стаж (лет)</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

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
                
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");

            int avgAge = 0, avgStage = 0;
            for (int i = 0; i < erp.getAdministration().size(); i++) {
                avgAge += (erp.getAdministration().get(i).getAge() / erp.getAdministration().size());
                avgStage += (erp.getAdministration().get(i).getStage() / erp.getAdministration().size());
            }
        
      out.write("\r\n");
      out.write("        <h3>Рассчитан средний возраст руководства: ");
      out.print( avgAge);
      out.write(" лет</h3>\r\n");
      out.write("        <h3>Рассчитан средний стаж руководства: ");
      out.print( avgStage);
      out.write(" лет</h3>\r\n");
      out.write("        <h3>Рабочие:</h3>\r\n");
      out.write("        <div class=\"table_employees table\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>№ п/п</th>\r\n");
      out.write("                    <th>№ пропуска</th>\r\n");
      out.write("                    <th width=\"440\">Ф.И.О.</th>\r\n");
      out.write("                    <th>Кол-во часов</th>\r\n");
      out.write("                    <th>Зарплата (BYN)</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

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
                
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");

            int sumHours = 0, sumSalary = 0;
            for (int i = 0; i < erp.getEmployees().size(); i++) {
                sumHours += erp.getEmployees().get(i).getHours();
                sumSalary += erp.getEmployees().get(i).getSalary();
            }
        
      out.write("\r\n");
      out.write("        <h3>Рассчитано кол-во отработанных часов: ");
      out.print( sumHours);
      out.write(" ч</h3>\r\n");
      out.write("        <h3>Рассчитан суммарный доход рабочих: ");
      out.print( sumSalary);
      out.write(" BYN</h3>\r\n");
      out.write("        <div class=\"buttons\">\r\n");
      out.write("            <div class=\"button\">\r\n");
      out.write("                <button type=\"submit\"\r\n");
      out.write("                        class=\"button_1\"\r\n");
      out.write("                        onclick=\"location.href='/administration'\">Просмотреть администрацию</button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"button\">\r\n");
      out.write("                <button type=\"submit\"\r\n");
      out.write("                        class=\"button_2\"\r\n");
      out.write("                        onclick=\"location.href='/employee'\">Просмотреть рабочих</button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"button\">\r\n");
      out.write("                <button type=\"submit\"\r\n");
      out.write("                        class=\"button_3\"\r\n");
      out.write("                        onclick=\"location.href='/count_salary'\">Рассчитать з/п рабочих</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
