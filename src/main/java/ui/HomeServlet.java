package ui;

import dao.EwalletDaoImpl;
import entities.Ewallet;
import service.EwalletServiceImpl;
import service.IEwalletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("second")
public class HomeServlet extends HttpServlet {
    public class LoginCheckServlet extends HttpServlet {
        private IEwalletService service = new EwalletServiceImpl(new EwalletDaoImpl());

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            HttpSession session = req.getSession();
            PrintWriter writer = resp.getWriter();
            String signedOutVal = req.getParameter("signout");
            boolean sessionDestroyed = false;
            if (signedOutVal != null && signedOutVal.equals("true")) {
                session.invalidate();
                sessionDestroyed = true;
            }
            Object usernameObj = null;
            if (!sessionDestroyed) {
                usernameObj = session.getAttribute("username");
            }

            if (usernameObj == null || usernameObj.toString().isEmpty()) {
                resp.getWriter().println("you are not signed in yet");
                String signInLink = "<a href='form.html'>Sign In </a> ";
                writer.println(signInLink);
                return;
            }
            String username = usernameObj.toString();
            Ewallet user = IEwalletService.getUserByUsername(username);
            String password = user.getPassword();
            writer.println("Welcome " + username + " password=" + password);
            String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
            writer.println(signoutLink);

        }


    }
}











