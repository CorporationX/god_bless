package school.faang.bjs2_68689;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Shawarma");
        productManager.addProduct(Category.FOOD, "Salad");
        productManager.addProduct(Category.ELECTRONICS, "Computer");
        productManager.addProduct(Category.ELECTRONICS, "Headphones");
        productManager.addProduct(Category.CLOTHING, "Dress");
        productManager.addProduct(Category.CLOTHING, "Pants");
        productManager.addProduct(Category.OTHER, "Pencil");
        productManager.addProduct(Category.OTHER, "Toy");

        productManager.printAllProducts();

        productManager.removeProduct(Category.CLOTHING, "Pants");
        productManager.removeProduct(Category.OTHER, "Toy");

        productManager.findProductsByCategory(Category.CLOTHING).forEach(System.out::println);

        System.out.println(productManager.groupProductsByCategory());
        productManager.printAllProducts();
    }
}
