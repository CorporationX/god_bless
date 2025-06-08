package school.faang.bjs2_80226;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(CategoryEnum.ELECTRONICS, "Тесла");
        productManager.addProduct(CategoryEnum.ELECTRONICS, "Лампочка");
        productManager.addProduct(CategoryEnum.FOOD, "Хлеб");
        productManager.addProduct(CategoryEnum.FOOD, "Рататуй");

        System.out.println(productManager.groupProductsByCategory());

        productManager.removeProduct(CategoryEnum.FOOD, "Хлеб");
        productManager.printAllProducts();

    }
}
