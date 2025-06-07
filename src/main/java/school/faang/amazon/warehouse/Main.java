package school.faang.amazon.warehouse;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        System.out.println("add products in product manager");
        System.out.println("__________________");
        Product iphone15 = pm.addProduct(Category.ELECTRONIC, "iphone 15");
        System.out.println(iphone15);

        Product iphone16 = pm.addProduct(Category.ELECTRONIC, "iphone 16");
        System.out.println(iphone16);

        Product apple = pm.addProduct(Category.FOOD, "apple");
        System.out.println(apple.toString());

        Product appleDuplicate = pm.addProduct(Category.FOOD, "apple");
        System.out.println(appleDuplicate.toString());

        Product tshirt = pm.addProduct(Category.CLOTHING, "t-shirt");
        System.out.println(tshirt);
        System.out.println("------------------");
        System.out.println();

        System.out.println("grouping products by category");
        System.out.println("__________________");
        Map<Category, List<Product>> productsByCategory = pm.groupProductsByCategory();
        System.out.println(productsByCategory);
        System.out.println("------------------");
        System.out.println();

        System.out.println("get products by category");
        System.out.println("__________________");
        List<Product> electronicList = pm.findProductsByCategory(Category.ELECTRONIC);
        System.out.println("category: ELECTRONIC");
        System.out.println(electronicList.toString());

        System.out.println("category: OTHER");
        List<Product> otherList = pm.findProductsByCategory(Category.OTHER);
        System.out.println(otherList.toString());
        System.out.println("------------------");
        System.out.println();

        System.out.println("remove iphone 15 from pm");
        System.out.println("__________________");
        System.out.println("products in ELECTRONICS category");
        pm.removeProduct(Category.ELECTRONIC, "iphone 15");
        System.out.println(electronicList);
        System.out.println("------------------");
        System.out.println();

        System.out.println("print all products");
        System.out.println("__________________");
        pm.printAllProducts();
        System.out.println("------------------");
    }
}
