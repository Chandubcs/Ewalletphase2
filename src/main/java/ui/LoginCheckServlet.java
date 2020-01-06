package ui;

import dao.EwalletDaoImpl;
import service.EwalletServiceImpl;
import service.IEwalletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "form")

public class LoginCheckServlet extends HttpServlet {
    private IEwalletService service = new EwalletServiceImpl(new EwalletDaoImpl());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean correct = service.credentialsCorrect(username, password);


        if (correct) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("/second");
        } else {
            resp.sendRedirect("form.html");
        }
    }

}










}
