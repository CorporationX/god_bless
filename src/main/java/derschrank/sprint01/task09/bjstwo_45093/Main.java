package derschrank.sprint01.task09.bjstwo_45093;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        System.out.println("1) Add Products to Shop");
        shop.addItem("category1", "product1");
        shop.addItem("category1", "product2");
        shop.addItem("category1", "product3");
        shop.addItem("category1", "product4");
        shop.addItem("category2", "product5");

        System.out.println("2) Print All Products");
        shop.printAllItems();

        System.out.println("3) Print All Products by category");
        shop.printProductsByCategory(shop.groupProductsByCategory(shop.getProducts()));


        System.out.println("\n4) removeItem Product1 from Category3");
        shop.removeItem("category3", "product1");

        System.out.println("\n6) removeItem Product111 from Category1");
        shop.removeItem("category1", "product111");

        System.out.println("\n7) removeItem Product1 from Category1");
        shop.removeItem("category1", "product1");


        System.out.println("8) Print All Products");
        shop.printAllItems();

        System.out.println("9) Print All Products by category");
        shop.printProductsByCategory(shop.groupProductsByCategory(shop.getProducts()));


        System.out.println("10) Find All Products in Category1");
        System.out.println(shop.findItemsByCategory("category1"));

    }
}
