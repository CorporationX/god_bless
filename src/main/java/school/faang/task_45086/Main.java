package school.faang.task_45086;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addItem("Category1", "Product1");
        productManager.addItem("Category2", "Product2");
        productManager.addItem("Category3", "Product3");
        productManager.addItem("Category2", "Product2");
        productManager.addItem("Category5", "Product5");

//        productManager.removeItem("Category1", "Product1");
//        productManager.printAllItems();

//        productManager.findItemsByCategory("Category2");

//        Map<String, Set<Product>> groupedProducts = productManager.groupProductsByCategory();
//        productManager.printProductsByCategory(groupedProducts);
    }
}
