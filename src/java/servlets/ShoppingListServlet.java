package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (username == null || username == "")
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response); 
        } else 
        {
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("register"))
        {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response); 
        } else if (action.equalsIgnoreCase("add"))
        {
            
        } else if (action.equalsIgnoreCase("delete"))
        {
            
        } else if (action.equalsIgnoreCase("logout"))
        {
            session.setAttribute("action", "logout");
        }
    }

}
