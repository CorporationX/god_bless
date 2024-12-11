package school.faang.bjs45168;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.addItem("Clothes", "Shoes male");
        productService.addItem("Electronics", "Smartphone");
        productService.addItem("Books", "Novel");
        productService.addItem("Furniture", "Chair");
        productService.addItem("Groceries", "Apples");
        productService.addItem("Electronics", "Mac");

        var groups = productService.groupProductsByCategory((HashSet<Product>) productService.getProducts());
        System.out.println(groups.equals(productService.getCategories()));

        var electronics = productService.findItemsByCategory("Electronics");
        System.out.println(electronics);

        productService.printAllItems();
        productService.removeItem("Books", "Novel");
        productService.removeItem("Electronics", "Smartphone");
        productService.printProductsByCategory(productService.getCategories());
    }
}
