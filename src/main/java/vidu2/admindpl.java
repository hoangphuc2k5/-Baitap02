package vidu2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/admin/home")
public class admindpl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (session != null && session.getAttribute("account") != null) {
            User u = (User) session.getAttribute("account");

            out.println("<html><body>");
            out.println("<h1>Chào mừng, " + u.getUserName() + "!</h1>");
            out.println("</body></html>");
        } else {
            // chưa đăng nhập thì chuyển về login
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
