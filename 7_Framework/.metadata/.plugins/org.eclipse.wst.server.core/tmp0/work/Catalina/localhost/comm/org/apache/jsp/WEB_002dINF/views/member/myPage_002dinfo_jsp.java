/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-04-28 01:58:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myPage_002dinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:split", org.apache.taglibs.standard.functions.Functions.class, "split", new Class[] {java.lang.String.class, java.lang.String.class});
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1682036017000L));
    _jspx_dependants.put("jar:file:/Users/gim-eunjin/workspace/7_Framework/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/comm/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/Users/gim-eunjin/workspace/7_Framework/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/comm/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("    <title>My Page</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/myPage-style.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/a2e8ca0ae3.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <main>\r\n");
      out.write("       ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <!-- 마이페이지 - 내 정보 -->\r\n");
      out.write("        <section class=\"myPage-content\">\r\n");
      out.write("            \r\n");
      out.write("			<!-- 사이드메뉴 include -->\r\n");
      out.write("			<!-- jsp 액션 태그 -->\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/member/sideMenu.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- 오른쪽 마이페이지 주요 내용 부분 -->\r\n");
      out.write("            <section class=\"myPage-main\">\r\n");
      out.write("\r\n");
      out.write("                <h1 class=\"myPage-title\">내 정보</h1>\r\n");
      out.write("                <span class=\"myPage-explanation\">원하는 회원 정보를 수정할 수 있습니다.</span>\r\n");
      out.write("\r\n");
      out.write("				<!-- \r\n");
      out.write("				http://localhost:8080/community/member/myPage/info (GET)\r\n");
      out.write("				http://localhost:8080/community/member/myPage/info (POST) \r\n");
      out.write("				-->\r\n");
      out.write("                <form action=\"info\" method=\"POST\" name=\"myPage-form\" onsubmit=\"return infoValidate()\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"myPage-row\">\r\n");
      out.write("                        <label>닉네임</label>\r\n");
      out.write("                        <input type=\"text\" name=\"updateNickname\"  id=\"memberNickname\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberNickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"10\">              \r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"myPage-row\">\r\n");
      out.write("                        <label>전화번호</label>\r\n");
      out.write("                        <input type=\"text\" name=\"updateTel\"  id=\"memberTel\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginMember.memberTel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"11\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- Member의 필드명과 일치하니까 앞을 update로 변경 -->\r\n");
      out.write("                    \r\n");
      out.write("\r\n");
      out.write("                    <!-- 주소 -->			<!--  fn:split(문자열, '구분자')  -->\r\n");
      out.write("					");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"myPage-row info-title\">\r\n");
      out.write("                        <span>주소</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"myPage-row info-address\">\r\n");
      out.write("                        <input type=\"text\" name=\"updateAddress\" id=\"postcode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addr[0]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"  maxlength=\"6\">\r\n");
      out.write("\r\n");
      out.write("                        <button type=\"button\" id=\"info-address-btn\" onclick=\"return execDaumPostcode()\">검색</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"myPage-row info-address\">\r\n");
      out.write("                        <input type=\"text\" name=\"updateAddress\" id=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addr[1]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"myPage-row info-address\">\r\n");
      out.write("                        <input type=\"text\" name=\"updateAddress\" id=\"detailAddress\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addr[2]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <button id=\"info-update-btn\">수정하기</button>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            </section>\r\n");
      out.write("        </section>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("    <div id=\"layer\" style=\"display:none;position:fixed;overflow:hidden;z-index:11;-webkit-overflow-scrolling:touch;\">\r\n");
      out.write("        <img src=\"//t1.daumcdn.net/postcode/resource/images/close.png\" id=\"btnCloseLayer\" style=\"cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1\" onclick=\"closeDaumPostcode()\" alt=\"닫기 버튼\">\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("		 // 다음 주소 API\r\n");
      out.write("		\r\n");
      out.write("		 // 우편번호 찾기 화면을 넣을 element\r\n");
      out.write("		 var element_layer = document.getElementById('layer');\r\n");
      out.write("		\r\n");
      out.write("		 function closeDaumPostcode() {\r\n");
      out.write("		     // iframe을 넣은 element를 안보이게 한다.\r\n");
      out.write("		     element_layer.style.display = 'none';\r\n");
      out.write("		 }\r\n");
      out.write("		\r\n");
      out.write("		 function execDaumPostcode() {\r\n");
      out.write("		     new daum.Postcode({\r\n");
      out.write("		         oncomplete: function(data) {\r\n");
      out.write("		             // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("		\r\n");
      out.write("		             // 각 주소의 노출 규칙에 따라 주소를 조합한다.\r\n");
      out.write("		             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\r\n");
      out.write("		             var addr = ''; // 주소 변수\r\n");
      out.write("		             var extraAddr = ''; // 참고항목 변수\r\n");
      out.write("		\r\n");
      out.write("		             //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.\r\n");
      out.write("		             if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우\r\n");
      out.write("		                 addr = data.roadAddress;\r\n");
      out.write("		             } else { // 사용자가 지번 주소를 선택했을 경우(J)\r\n");
      out.write("		                 addr = data.jibunAddress;\r\n");
      out.write("		             }\r\n");
      out.write("		\r\n");
      out.write("		             // 우편번호와 주소 정보를 해당 필드에 넣는다.\r\n");
      out.write("		             document.getElementById('postcode').value = data.zonecode;\r\n");
      out.write("		             document.getElementById(\"address\").value = addr;\r\n");
      out.write("		             // 커서를 상세주소 필드로 이동한다.\r\n");
      out.write("		             document.getElementById(\"detailAddress\").focus();\r\n");
      out.write("		\r\n");
      out.write("		             // iframe을 넣은 element를 안보이게 한다.\r\n");
      out.write("		             // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)\r\n");
      out.write("		             element_layer.style.display = 'none';\r\n");
      out.write("		         },\r\n");
      out.write("		         width : '100%',\r\n");
      out.write("		         height : '100%',\r\n");
      out.write("		         maxSuggestItems : 5\r\n");
      out.write("		     }).embed(element_layer);\r\n");
      out.write("		\r\n");
      out.write("		     // iframe을 넣은 element를 보이게 한다.\r\n");
      out.write("		     element_layer.style.display = 'block';\r\n");
      out.write("		\r\n");
      out.write("		     // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.\r\n");
      out.write("		     initLayerPosition();\r\n");
      out.write("		 }\r\n");
      out.write("		\r\n");
      out.write("		 // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는\r\n");
      out.write("		 // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,\r\n");
      out.write("		 // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.\r\n");
      out.write("		 function initLayerPosition(){\r\n");
      out.write("		     var width = 500; //우편번호서비스가 들어갈 element의 width\r\n");
      out.write("		     var height = 400; //우편번호서비스가 들어갈 element의 height\r\n");
      out.write("		     var borderWidth = 5; //샘플에서 사용하는 border의 두께\r\n");
      out.write("		\r\n");
      out.write("		     // 위에서 선언한 값들을 실제 element에 넣는다.\r\n");
      out.write("		     element_layer.style.width = width + 'px';\r\n");
      out.write("		     element_layer.style.height = height + 'px';\r\n");
      out.write("		     element_layer.style.border = borderWidth + 'px solid';\r\n");
      out.write("		     // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.\r\n");
      out.write("		     element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';\r\n");
      out.write("		     element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';\r\n");
      out.write("		 }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- myPage.js 추가 -->\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/member/myPage.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/member/myPage-info.jsp(61,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("addr");
      // /WEB-INF/views/member/myPage-info.jsp(61,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/member/myPage-info.jsp(61,5) '${fn:split(loginMember.memberAddress, ',,')}'",_jsp_getExpressionFactory().createValueExpression(new org.apache.jasper.el.ELContextWrapper(_jspx_page_context.getELContext(),_jspx_fnmap_0),"${fn:split(loginMember.memberAddress, ',,')}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}