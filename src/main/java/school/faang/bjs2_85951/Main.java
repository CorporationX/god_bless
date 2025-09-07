package school.faang.bjs2_85951;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.ELECTRONICS, "Phone");
        productManager.addProduct(Category.FOOD, "Fish");
        productManager.addProduct(Category.CLOTHING, "Socks");
        productManager.addProduct(Category.CLOTHING, "Gloves");
        productManager.addProduct(Category.FOOD, "Milk");
        productManager.addProduct(Category.OTHER, "Hummer");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.printAllProducts();
        System.out.println("-------------------------------------------");
        productManager.printProductsByCategory(Category.FOOD);
        productManager.printProductsByCategory(Category.ELECTRONICS);
        System.out.println("-------------------------------------------");
        productManager.removeProduct(Category.OTHER, "Axe");
        productManager.printAllProducts();
        System.out.println("-------------------------------------------");
        productManager.removeProduct(Category.OTHER, "Hummer");
        productManager.printAllProducts();
        System.out.println("-------------------------------------------");
        productManager.printProductsByCategory(Category.OTHER);
        System.out.println("-------------------------------------------");
        productManager.printAllProducts();
    }
}
