package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.MenuList;

import java.io.IOException;

@WebServlet(name ="ManuByCategory", value = "/menu-by-category")
public class MenuByCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuList menuList = new MenuList();
        req.setAttribute("menu", menuList.getMenu());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/menu_by_category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
