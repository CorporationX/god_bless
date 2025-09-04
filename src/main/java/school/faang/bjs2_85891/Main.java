package school.faang.bjs2_85891;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Product.Category.FOOD, "Apple");
        productManager.addProduct(Product.Category.FOOD, "Bread");
        productManager.addProduct(Product.Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Product.Category.CLOTHING, "Cap");
        productManager.addProduct(Product.Category.CLOTHING, "Scarf");
        productManager.addProduct(Product.Category.OTHER, "Armchair");
        productManager.addProduct(Product.Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Product.Category.OTHER, "Table");
        productManager.addProduct(Product.Category.CLOTHING, "Gloves");
        productManager.addProduct(Product.Category.OTHER, "Cup");

        productManager.removeProduct(Product.Category.CLOTHING, "Scarf");

        List<String> listProducts;
        listProducts = productManager.findProductsByCategory(Product.Category.CLOTHING);
        System.out.println(listProducts);

        productManager.printAllProducts();
    }
}