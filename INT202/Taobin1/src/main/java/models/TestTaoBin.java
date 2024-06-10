package models;

public class TestTaoBin {
    public static void main(String[] args) {
        MenuList menuList = new MenuList();
        for(Category category: menuList.getMenu()){
            System.out.println(category);
        }
    }
}
