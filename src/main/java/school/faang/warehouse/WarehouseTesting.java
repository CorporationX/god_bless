package school.faang.warehouse;

public class WarehouseTesting {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "banana");
        productManager.addProduct(Category.FOOD, "apple");

        productManager.addProduct(Category.CLOTHING, "shirt");
        productManager.addProduct(Category.CLOTHING, "cap");

        productManager.addProduct(Category.ELECTRONICS, "notebook");
        productManager.addProduct(Category.ELECTRONICS, "smartphone");

        productManager.addProduct(Category.OTHER, "plate");
        productManager.addProduct(Category.OTHER, "wallpaper");

        System.out.println("Текущие продукты: ");
        productManager.printAllProducts();

        productManager.removeProduct(Category.CLOTHING, "cap");
        System.out.println("\nУдаляется кепка: ");
        productManager.printAllProducts();

        System.out.println("\nПоиск по категории food: ");
        for (Product product : productManager.findProductsByCategory(Category.FOOD)) {
            System.out.println(product.getName());
        }
    }
}
