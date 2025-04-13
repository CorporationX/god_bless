package school.faang.amazon;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "water");
        productManager.addProduct(Category.FOOD, "cola");
        productManager.addProduct(Category.FOOD, "pepsi");
        productManager.addProduct(Category.OTHER, "hleb");
        productManager.addProduct(Category.ELECTRONICS, "chainik");
        System.out.println(productManager.findProductByCategory(Category.ELECTRONICS));
        productManager.removeProduct(Category.FOOD, "water");
        productManager.groupProductsByCategory();
        productManager.printAllProduct();
    }
}
