package school.faang.java_collection.bjs2_85891;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.CLOTHING, "Cap");
        productManager.addProduct(Category.CLOTHING, "Scarf");
        productManager.addProduct(Category.OTHER, "Armchair");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.OTHER, "Table");
        productManager.addProduct(Category.CLOTHING, "Gloves");
        productManager.addProduct(Category.OTHER, "Cup");

        productManager.removeProduct(Category.CLOTHING, "Scarfk");

        List<String> listProducts;
        listProducts = productManager.findProductsByCategory(Category.CLOTHING);
        System.out.println(listProducts);

        productManager.printAllProducts();
    }
}