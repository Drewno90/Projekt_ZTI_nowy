/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2015-04-12 13:55:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<<style>\n");
      out.write("<!--\n");
      out.write("body {\r\n");
      out.write("  padding-top: 40px;\r\n");
      out.write("  padding-bottom: 40px;\r\n");
      out.write("  background-color: #eee;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-signin {\r\n");
      out.write("  max-width: 330px;\r\n");
      out.write("  padding: 15px;\r\n");
      out.write("  margin: 0 auto;\r\n");
      out.write("}\r\n");
      out.write(".form-signin .form-signin-heading,\r\n");
      out.write(".form-signin .checkbox {\r\n");
      out.write("  margin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write(".form-signin .checkbox {\r\n");
      out.write("  font-weight: normal;\r\n");
      out.write("}\r\n");
      out.write(".form-signin .form-control {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  height: auto;\r\n");
      out.write("  -webkit-box-sizing: border-box;\r\n");
      out.write("     -moz-box-sizing: border-box;\r\n");
      out.write("          box-sizing: border-box;\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("}\r\n");
      out.write(".form-signin .form-control:focus {\r\n");
      out.write("  z-index: 2;\r\n");
      out.write("}\r\n");
      out.write(".form-signin input[type=\"email\"] {\r\n");
      out.write("  margin-bottom: -1px;\r\n");
      out.write("  border-bottom-right-radius: 0;\r\n");
      out.write("  border-bottom-left-radius: 0;\r\n");
      out.write("}\r\n");
      out.write(".form-signin input[type=\"password\"] {\r\n");
      out.write("  margin-bottom: 10px;\r\n");
      out.write("  border-top-left-radius: 0;\r\n");
      out.write("  border-top-right-radius: 0;\r\n");
      out.write("}\n");
      out.write("-->\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("   <form class=\"form-signin\" role=\"form\" action=\"j_spring_security_check\" method=\"POST\">\r\n");
      out.write("        <h2 class=\"form-signin-heading\">Please sign in</h2>\r\n");
      out.write("        <label for=\"inputEmail\" class=\"sr-only\">Email address</label>\r\n");
      out.write("        <input type=\"text\" name=\"j_username\" class=\"form-control\" placeholder=\"Name\" required autofocus>\r\n");
      out.write("        <label for=\"inputPassword\" class=\"sr-only\">Password</label>\r\n");
      out.write("        <input type=\"password\" name=\"j_password\" class=\"form-control\" placeholder=\"Password\" required>\r\n");
      out.write("        <div class=\"checkbox\">\r\n");
      out.write("          <label>\r\n");
      out.write("            <input type=\"checkbox\" value=\"remember-me\"> Remember me\r\n");
      out.write("          </label>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Sign in</button>\r\n");
      out.write("      </form>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}