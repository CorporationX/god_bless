package school.faang;

import static school.faang.Product.Category.*;

public class Main {
    public static void main(String[] args) {
        Product product1=new Product("apple", FOOD);
        Product product2=new Product("banana", FOOD);
        Product product3=new Product("fridge", ELECTRONICS);
        Product product4=new Product("shorts", CLOTHING);
        Product product5=new Product("makeup", OTHER);
        ProductManager productManager = new ProductManager();
        productManager.addProduct(product1.getCategory(), product1.getName());
        productManager.addProduct(product2.getCategory(), product2.getName());
        productManager.addProduct(product3.getCategory(), product3.getName());
        productManager.addProduct(product4.getCategory(), product4.getName());
        productManager.addProduct(product5.getCategory(), product5.getName());
        productManager.showAllProducts();
        productManager.removeProduct(product3.getCategory(), product3.getName());
        productManager.showAllProducts();
        System.out.println(productManager.findProductsByCategory(FOOD));
    }
}
