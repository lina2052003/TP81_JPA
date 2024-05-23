package ma.formations.jpa.presentation.controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.servicee.IService;
import ma.formations.jpa.servicee.ServiceImpl;
@WebServlet("/login.do")
public class AuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service=new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String hashedpassword=service.hashPassword(password);

        System.out.println("password: "+password);
        System.out.println("hashedpassword: "+hashedpassword);
        //System.out.println("dbpassword: "+hashedpassword);

        if (!service.checkAccount(username, hashedpassword)) {
            request.setAttribute("AccountIncorrect", "Login or password incorrect !");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
        else {
            request.getSession().setAttribute("username", username);
            request.getRequestDispatcher("/view/main-template.jsp").forward(request, response);
        }
    }
}