package school.faang.bjs2_79912;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct("Apple", Category.FOOD);
        pm.addProduct("Banana", Category.FOOD);
        pm.addProduct("Laptop", Category.ELECTRONICS);

        pm.printAllProducts();

        pm.removeProduct("Laptop", Category.ELECTRONICS);

        for (Product product : pm.findProductByCategory(Category.FOOD)) {
            System.out.println(product.getName());
        }
    }
}