package school.faang.bjs2_86070;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        try {
            productManager.addProduct(Category.ELECTRONICS, "iPhone 15 Pro");
            productManager.addProduct(Category.ELECTRONICS, "Samsung Galaxy S24");
            productManager.addProduct(Category.CLOTHING, "Джинсы Levi's 501");
            productManager.addProduct(Category.CLOTHING, "Футболка хлопковая");
            productManager.addProduct(Category.FOOD, "Молоко 3.2%");
            productManager.addProduct(Category.FOOD, "Хлеб ржаной");
            productManager.addProduct(Category.OTHER, "Подарочный сертификат");
            productManager.addProduct(Category.OTHER, "Набор для вышивания");
            productManager.removeProduct(Category.CLOTHING, "Футболка хлопковая");
            productManager.removeProduct(Category.CLOTHING, "Платье");
            productManager.findProductsByCategory(Category.CLOTHING);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        productManager.printAllProducts();
    }
}
