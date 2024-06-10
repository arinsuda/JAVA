package models;

import java.util.ArrayList;

public class MenuList {
    private static ArrayList<Category> menu = new ArrayList<>(10);

    static {
        Category category;
        Drink drink;

        category = new Category("Hot Coffee");
        drink = new Drink("Hot Espresso", 30);
        category.addDrink(drink);
        drink = new Drink("Hot Latte", 30);
        category.addDrink(drink);
        drink = new Drink("Hot Mocha", 30);
        category.addDrink(drink);

        menu.add(category);

        category = new Category("Iced Coffee");
        drink = new Drink("Iced Espresso", 35);
        category.addDrink(drink);
        drink = new Drink("Iced Latte", 35);
        category.addDrink(drink);
        drink = new Drink("Iced Mocha", 35);
        category.addDrink(drink);

        menu.add(category);

        category = new Category("Fruity Drink");
        drink = new Drink("Iced Limeade", 40);
        category.addDrink(drink);
        drink = new Drink("Iced Lychee", 40);
        category.addDrink(drink);
        drink = new Drink("Iced Strawberry", 40);
        category.addDrink(drink);

        menu.add(category);
    }

    public static ArrayList<Category> getMenu() {
        return menu;
    }

    public static void setMenu(ArrayList<Category> menu) {
        MenuList.menu = menu;
    }

    public Category find(int id){
        for(Category category: menu){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }

    public Category find(String categoryName){
        for(Category category: menu){
            if(category.getName().equals(categoryName)){
                return category;
            }
        }
        return null;
    }

    public void addMenu(String categoryName, Drink drink){

    }
}
