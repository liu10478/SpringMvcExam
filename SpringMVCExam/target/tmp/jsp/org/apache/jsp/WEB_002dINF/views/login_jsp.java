/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.11.v20150529
 * Generated at: 2016-08-21 14:01:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"");
      out.print( request.getContextPath() );
      out.write("/Css/background.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"");
      out.print( request.getContextPath() );
      out.write("/Css/login.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write(" function validate_required(field,alerttxt)\n");
      out.write("{\n");
      out.write("with (field)\n");
      out.write("  {\n");
      out.write("  if (value==null||value==\"\")\n");
      out.write("    {alert(alerttxt);return false}\n");
      out.write("  else {return true}\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\tfunction validate_form(thisform) {\n");
      out.write("\t\twith (thisform) {\n");
      out.write("\t\t\tif (validate_required(first_name, \"用户名不能为空!\") == false) {\n");
      out.write("\t\t\t\tfirst_name.focus();\n");
      out.write("\t\t\t\treturn false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\tif (validate_required(password, \"密码不能为空!\") == false) {\n");
      out.write("\t\t\tpassword.focus();\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t} \n");
      out.write("</script>\n");
      out.write("<body>\n");
      out.write("<div id=\"body\">\n");
      out.write("<div id=\"id\">10478 刘婉婉</div>\n");
      out.write("<div id=\"bodylogin\">\n");
      out.write("\n");
      out.write("\t<div id=\"top\">电影租赁管理系统</div>\n");
      out.write("\t\t<form action=\"login\" id=\"login\" method=\"post\">\n");
      out.write("\t\t<table id=\"login\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t<td>用户名：</td>\n");
      out.write("\t\t<td><input type=\"text\" name=\"first_name\" id=\"username_id\" class=\"input_class\"><div id=\"username_message\"></div></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t<td>密码：</td>\n");
      out.write("\t\t<td><input type=\"password\" name=\"password\" id=\"password_id\" class=\"input_class\"><div id=\"password_message\"></div></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t<td></td>\n");
      out.write("\t\t<td><input type=\"submit\" value=\"登陆\" id=\"submit_id\" onclick=\"return validate_form(this.form)\"> </td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
