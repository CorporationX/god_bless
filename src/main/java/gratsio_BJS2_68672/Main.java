package gratsio_BJS2_68672;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct(Category.FOOD, "Milk");
        pm.addProduct(Category.FOOD, "Apple");
        pm.addProduct(Category.FOOD, "Orange");
        pm.addProduct(Category.FOOD, "Water");
        if(!pm.findProductsByCategory(Category.FOOD).isEmpty()){
            for(Product p : pm.findProductsByCategory(Category.FOOD)){
                System.out.println(p);
            }
        } else {
            System.out.println("There are no products in this category");
        }
        pm.addProduct(Category.ELECTRONICS, "TV");
        pm.addProduct(Category.ELECTRONICS, "Tablet");
        if(!pm.findProductsByCategory(Category.ELECTRONICS).isEmpty()){
            for(Product p : pm.findProductsByCategory(Category.ELECTRONICS)){
                System.out.println(p);
            }
        } else {
            System.out.println("There are no products in this category");
        }
        if(!pm.findProductsByCategory(Category.CLOTHING).isEmpty()){
            for(Product p : pm.findProductsByCategory(Category.CLOTHING)){
                System.out.println(p);
            }
        } else {
            System.out.println("There are no products in this category");
        }
        pm.printAllProducts();
    }
}
