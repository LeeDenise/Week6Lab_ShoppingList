package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        String action = request.getParameter("action");
        
        if (username == null || username == "")
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
            return;
        }
        
        if (action != null && action.equalsIgnoreCase("logout"))
        {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
            return;
        }
        
        request.setAttribute("username", username);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
            .forward(request, response); 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        
        ArrayList itemLists;
        if (session.getAttribute("itemLists") == null)
        {
            itemLists = new ArrayList();
        } else {
            itemLists = (ArrayList) session.getAttribute("itemLists");
        }
        
        if (action.equalsIgnoreCase("register"))
        {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response); 
        } else if (action.equalsIgnoreCase("add"))
        {
            String item = request.getParameter("item");
            itemLists.add(item);
            session.setAttribute("itemLists", itemLists);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response); 
        } else if (action.equalsIgnoreCase("delete"))
        {
            
        } 
    }

}
