package school.faang.bjs2_69862;

public class Main {
    public static void main(String [] args) {
        var productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Хлеб");
        productManager.addProduct(Category.FOOD, "Чипсы");
        productManager.addProduct(Category.FOOD, "Паста");
        productManager.addProduct(Category.CLOTHING, "Кепка");
        productManager.addProduct(Category.CLOTHING, "Шапка");
        productManager.addProduct(Category.CLOTHING, "Пальто");
        productManager.addProduct(Category.ELECTRONICS, "Айфон");
        productManager.addProduct(Category.ELECTRONICS, "Макбук");
        productManager.addProduct(Category.ELECTRONICS, "Нокиа");
        productManager.addProduct(Category.OTHER, "Ложка для обуви");

        productManager.printAllProducts();

        for (Product product : productManager.findProductsByCategory(Category.FOOD)) {
            System.out.println("- " + product.getName());
        }

        productManager.removeProduct(Category.FOOD, "Bread");
        productManager.printAllProducts();
    }
}