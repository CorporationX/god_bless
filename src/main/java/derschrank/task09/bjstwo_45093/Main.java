package derschrank.task09.bjstwo_45093;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        System.out.println("1) Make Products and Category #1");

        System.out.println("2) Add Products to Shop");
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        shop.addItem("Category1", product1);
        shop.addItem("Category1", product2);

        Category category1 = new Category("Category1");
        Product product3 = new Product(3, "Product3", category1);
        Product product4 = new Product(4, "Product4");
        shop.addItem(product3);
        shop.addItem(product4);

        Product product5 = new Product("Product5");
        shop.addItem(product5);

        //System.out.println("3) Print Products in Category #1");
        //shop.printItemsByCategory("Category1");


        System.out.println("4) Print All Products");
        shop.printAllItems();


        System.out.println("\n5) removeItem Product1 from Category3");
        shop.removeItem("Category3", "Product1");

        System.out.println("\n6) removeItem Product111 from Category1");
        shop.removeItem("Category1", "Product111");

        //System.out.println("\n7) removeItem Product1, Product2 from Category1");
        //shop.removeItem("Category1", "Product1");
        //shop.removeItem(category1, product2);

        System.out.println("8) Print All Products");
        shop.printAllItems();

    }
}
