import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Refresh extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  HttpSession session = request.getSession(true);
  response.setIntHeader("Refresh", 5);
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  Integer count = new Integer(0);
  String head;
  if (session.isNew()) {
   head = "This is the New Session";
  } else {
   head = "This is the old Session";
   Integer oldcount = (Integer) session.getValue("count");
   if (oldcount != null) {
    count = new Integer(oldcount.intValue() + 1);
   }
  }
  session.putValue("count", count);
  out.println("<HTML><BODY BGCOLOR=#FDF5E6>" + "<H2 ALIGN=CENTER>" + head + "</H2>"
    + "<TABLE BORDER=1 ALIGN=CENTER>" + "<TR BGCOLOR=#FFAD00>" + "  <TH>Information Type<TH>Session Count "
    + "<TR>" + " <TD>Total Session Accesses" + "<TD>" + count + "</TABLE>" + "</BODY></HTML>");
 }
}