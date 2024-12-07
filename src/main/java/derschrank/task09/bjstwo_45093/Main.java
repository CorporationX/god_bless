package derschrank.task09.bjstwo_45093;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");
        Product product3 = new Product(3, "Product3");

        shop.addItem("Category1", product1);
        shop.addItem("Category1", "product4");

        Category category1 = new Category("Category1");
        shop.addItem(category1, product2);
        shop.addItem(category1, product3);

        shop.addItem("Category2", "product5");

        System.out.println("1) printItemsByCategory");
        shop.printItemsByCategory(category1);
        shop.printItemsByCategory("Category2");

        System.out.println("2) removeItem from Category1");
        shop.removeItem(product1);
        shop.removeItem("product4");
        shop.printItemsByCategory(category1);

        System.out.println("3) printAllItems");
        shop.printAllItems();

    }
}
