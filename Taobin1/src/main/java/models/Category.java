package models;

import java.util.ArrayList;

public class Category {
    private static int count;
    private int id;
    private String name;
    private ArrayList<Drink> drinks = new ArrayList<>(10);

    public Category(String name) {
        this.id = ++count;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public Drink find(int id){
        for(Drink drink: drinks){
            if(drink.getId() == id){
                return drink;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drinks=" + drinks +
                '}';
    }
}
