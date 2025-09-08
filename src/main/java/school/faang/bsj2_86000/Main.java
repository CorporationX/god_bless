package school.faang.bsj2_86000;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "FOOD1");
        productManager.addProduct(Category.FOOD, "FOOD2");
        productManager.addProduct(Category.FOOD, "FOOD3");
        productManager.addProduct(Category.CLOTHING, "CLOTHING1");
        productManager.addProduct(Category.CLOTHING, "CLOTHING2");
        productManager.addProduct(Category.CLOTHING, "CLOTHING3");
        productManager.addProduct(Category.ELECTONICS, "ELECTONICS1");
        productManager.addProduct(Category.ELECTONICS, "ELECTONICS2");
        productManager.addProduct(Category.ELECTONICS, "ELECTONICS3");
        productManager.addProduct(Category.OTHER, "OTHER1");
        productManager.addProduct(Category.OTHER, "OTHER2");
        productManager.addProduct(Category.OTHER, "OTHER3");

        System.out.println(productManager.isRemoveProduct(Category.FOOD, "FOOD4"));
        System.out.println(productManager.isRemoveProduct(Category.FOOD, "FOOD3"));

        System.out.println("");

        System.out.println(productManager.findProductsByCategory(Category.FOOD));
        System.out.println(productManager.findProductsByCategory(Category.CLOTHING));
        System.out.println(productManager.findProductsByCategory(Category.ELECTONICS));

        System.out.println("");

        productManager.printAllProducts();

    }
}
