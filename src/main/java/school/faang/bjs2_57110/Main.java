package school.faang.bjs2_57110;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();

        pm.addProduct(Category.FOOD, "Мороженное");
        pm.addProduct(Category.FOOD, "Колбаса");
        pm.addProduct(Category.ELECTRONICS, "Ноутбук");
        pm.addProduct(Category.ELECTRONICS, "Смартфон");
        pm.addProduct(Category.CLOTHING, "Футболка мужская");

        pm.removeProduct(Category.FOOD, "Мороженное");
        pm.removeProduct(Category.CLOTHING, "Куртка");

        pm.findProductsByCategory(Category.ELECTRONICS);
        pm.groupProductsByCategory();

        pm.printAllProducts();
    }
}
