package BJS256905;



public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Product firstProduct = new Product("First product", Category.FOOD);
        Product secondProduct = new Product("Second product", Category.CLOTHING);
        Product thirdProduct = new Product("Third product", Category.FOOD);
        Product nullProduct = new Product("Null product", Category.ELECTRONICIS);

        productManager.addProduct(firstProduct.getCategory(), firstProduct.getName());
        productManager.addProduct(secondProduct.getCategory(), secondProduct.getName());
        productManager.addProduct(thirdProduct.getCategory(), thirdProduct.getName());
        productManager.addProduct(nullProduct.getCategory(), nullProduct.getName());

        System.out.println("delete : ");

        productManager.removeProduct(firstProduct.getCategory(), firstProduct.getName());

        System.out.println("\n");
        System.out.println("find product: ");
        System.out.println(productManager.findProductByCategory(Category.FOOD));
    }
}
