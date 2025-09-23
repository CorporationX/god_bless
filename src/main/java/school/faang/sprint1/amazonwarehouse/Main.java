package school.faang.sprint1.amazonwarehouse;

import java.util.List;

public class Main {

    private final ProductManagerImpl productManager = new ProductManagerImpl();

    public static void main(String[] args) {
        Main tester = new Main();

        tester.testAddProduct();
        tester.testRemoveProduct();
        tester.testRemoveProduct_nullCategory();
        tester.testRemoveProduct_noProductFound();
        tester.testFindProductsByCategory();
        tester.testFindProductsByCategory_nonExistentProduct();
        tester.testGroupProductsByCategory();
        tester.testPrintAllProducts();
    }

    private void testPrintAllProducts() {
        System.out.println("-------------------------------------");
        System.out.println("Printing all products in warehouse:");
        System.out.println("-------------------------------------");

        productManager.printAllProducts();
    }

    private void testGroupProductsByCategory() {
        System.out.println("-------------------------------------");
        System.out.println("Grouping products by Category:");
        System.out.println("-------------------------------------");

        System.out.println(productManager.groupProductsByCategory());
    }

    private void testFindProductsByCategory_nonExistentProduct() {
        System.out.println("-------------------------------------");
        System.out.println("Retrieving empty list of products:");
        System.out.println("-------------------------------------");

        Category category = Category.OTHER;
        System.out.println("Category: " + category);

        List<Product> productsFound = productManager.findProductsByCategory(category);
        System.out.println(productsFound);
    }

    private void testFindProductsByCategory() {
        System.out.println("-------------------------------------");
        System.out.println("Retrieving products by category:");
        System.out.println("-------------------------------------");

        Category category = Category.ELECTRONICS;
        System.out.println("Category: " + category);

        List<Product> productsFound = productManager.findProductsByCategory(category);
        System.out.println(productsFound);
    }

    private void testRemoveProduct_noProductFound() {
        System.out.println("-------------------------------------");
        System.out.println("Removing product with invalid category, correct name:");
        System.out.println("-------------------------------------");

        Category category = Category.FOOD;
        String name = "Laptop";

        boolean removed = productManager.removeProduct(category, name);
        System.out.println("Product removed: " + removed);
    }

    private void testRemoveProduct_nullCategory() {
        System.out.println("-------------------------------------");
        System.out.println("Removing product with category equal null:");
        System.out.println("-------------------------------------");
        try {
            productManager.removeProduct(null, "Bread");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void testRemoveProduct() {
        System.out.println("-------------------------------------");
        System.out.println("Removing existent in system product:");
        System.out.println("-------------------------------------");

        Category category = Category.FOOD;
        String name = "Apple";

        boolean removed = productManager.removeProduct(category, name);
        System.out.println("Product removed: " + removed);
    }

    private void testAddProduct() {
        System.out.println("-------------------------------------");
        System.out.println("Adding 5 products:");
        System.out.println("-------------------------------------");

        Product p1 = productManager.addProduct(Category.FOOD, "Apple");
        Product p2 = productManager.addProduct(Category.FOOD, "Bread");
        Product p3 = productManager.addProduct(Category.ELECTRONICS, "Laptop");
        Product p4 = productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        Product p5 = productManager.addProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("Added: \n" + p1 + "\n" + p2 + "\n" + p3 + "\n" + p4 + "\n" + p5);
    }

}
