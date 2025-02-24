package school.faang.bsj245090;

import static school.faang.bsj245090.ProductsList.addItem;
import static school.faang.bsj245090.ProductsList.removeItem;
import static school.faang.bsj245090.ProductsList.printAllItems;
import static school.faang.bsj245090.ProductsList.printProductsByCategory;

public class Main {

    public static void main(String[] args) {
        addItem("Category1", "Product1");
        addItem("Category1", "Product2");
        addItem("Category1", "Product3");
        addItem("Category1", "Product4");
        addItem("Category2", "Product5");
        addItem("Category2", "Product6");
        addItem("Category3", "Product7");
        addItem("Category3", "Product8");
        addItem("Category4", "Product9");

        removeItem("Category1", "Product4");

        printProductsByCategory();
    }
}
