package school.faang.sprint1.task_BJS2_56911;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        System.out.println("Пустые мапы");
        System.out.println(productManager.getCategoryMap());
        System.out.println(productManager.getProducts());

        System.out.println();

        System.out.println("Добавлям продукты");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        System.out.println(productManager.getCategoryMap());
        System.out.println(productManager.getProducts());

        System.out.println();

        System.out.println("Удаляем продукты");
        productManager.removeProduct(Category.ELECTRONICS, "Smartphone");
        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.removeProduct(Category.CLOTHING, "Shirt");
        System.out.println(productManager.getCategoryMap());
        System.out.println(productManager.getProducts());

        System.out.println();

        System.out.println("Групируем продкты по карегориям, хотя и так сгрупированны");
        productManager.groupProductsByCategory();
        System.out.println(productManager.getCategoryMap());
        System.out.println(productManager.getProducts());

        System.out.println();

        System.out.println("Ищем продукты в категории ELECTRONICS");
        System.out.println(productManager.findProductsByCategory(Category.ELECTRONICS));

        System.out.println();

        System.out.println("Ищем продукты в категории OTHER");
        System.out.println(productManager.findProductsByCategory(Category.OTHER));

        System.out.println();

        System.out.println("Выводим все подукты по категориям");
        productManager.printAllProducts();
    }
}
