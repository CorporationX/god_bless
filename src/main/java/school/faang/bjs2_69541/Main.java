package school.faang.bjs2_69541;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(Category.CLOTHING, "ботинки");
        manager.addProduct(Category.CLOTHING, "туфли");
        manager.addProduct(Category.CLOTHING, "сапоги");
        manager.addProduct(Category.CLOTHING, "брюки");
        manager.addProduct(Category.CLOTHING, "сапоги");
        manager.addProduct(Category.FOOD, "хлеб");
        manager.addProduct(Category.FOOD, "молоко");
        manager.addProduct(Category.FOOD, "сметана");
        manager.addProduct(Category.ELECTRONICS, "телефон");
        manager.addProduct(Category.ELECTRONICS, "телевизор");
        manager.addProduct(Category.ELECTRONICS, "планшет");
        manager.addProduct(Category.OTHER, "стол");
        manager.addProduct(Category.OTHER, "стул");
        manager.addProduct(Category.OTHER, "стол");
        manager.printAllProducts();
        manager.removeProduct(Category.OTHER, "телефон");
        manager.removeProduct(Category.ELECTRONICS, "телефон");
        manager.printAllProducts();
    }
}
