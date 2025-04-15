package school.faang.amazon;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(1, Category.FOOD, "water");
        productManager.addProduct(2, Category.FOOD, "cola");
        productManager.addProduct(3, Category.FOOD, "pepsi");
        productManager.addProduct(4, Category.OTHER, "hleb");
        productManager.addProduct(5, Category.ELECTRONICS, "chainik");
        System.out.println(productManager.findProductByCategory(Category.ELECTRONICS).toString());
        productManager.removeProduct(Category.FOOD, "water");
        productManager.groupProductsByCategory();
        productManager.printAllProduct();
    }
}
