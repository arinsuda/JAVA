package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Category;
import models.Drink;
import models.MenuList;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryMenu", value = "/category-menu")
public class CategoryMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));
        MenuList menuList = new MenuList();
        Category category = menuList.find(categoryId);
        List<Drink> drinks = category.getDrinks();

        req.setAttribute("category", category);
        req.setAttribute("drinks", drinks);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/category_menu.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
