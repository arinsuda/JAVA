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

@WebServlet(name = "addDrinks", value = "/add-drink")
public class AddDrinkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));

        if(name != null && name.length()>0 && price != 0 && categoryName != null && categoryName.length()>0){
            MenuList menuList = new MenuList();
            Category category = menuList.find(categoryName);
            Drink drinks = new Drink(name,price);
            category.addDrink(drinks);
        }
        resp.sendRedirect("category-menu?name=" + categoryName);
    }
}
