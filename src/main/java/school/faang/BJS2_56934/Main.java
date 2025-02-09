package school.faang.BJS2_56934;

public class Main {
    public static void main(String[] args) {
        try {
            ProductManager pm = new ProductManager();
            pm.addProduct(Category.ELECTRONICS, "iphone_14");
            pm.addProduct(Category.FOOD, "apple");
            System.out.println(pm.printAllProducts());
            System.out.println(pm.findProductsByCategory(Category.ELECTRONICS));
            System.out.println(pm.groupProductsByCategory());
            pm.removeProduct(Category.ELECTRONICS, "iphone_14");
            System.out.println(pm.printAllProducts());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
