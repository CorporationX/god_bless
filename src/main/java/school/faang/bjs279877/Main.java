package school.faang.bjs279877;

public class Main {
    public static void main(String[] args) {
        ProductManager dataBase = new ProductManager();
        dataBase.printAllProducts();
        System.out.println("----------------------------------");
        dataBase.addProduct(CategoryProduct.FOOD, "Курятина");
        dataBase.addProduct(CategoryProduct.FOR_CAR, "Дворник");
        dataBase.addProduct(CategoryProduct.FOOD, "Говядина");
        System.out.println("----------------------------------");
        dataBase.addProduct(CategoryProduct.FOOD, "Курятина");
        dataBase.addProduct(CategoryProduct.FOR_CAR, "Дворник");
        System.out.println("----------------------------------");
        System.out.println(dataBase.findProductsByCategory(CategoryProduct.FOOD));
        System.out.println("----------------------------------");
        System.out.println(dataBase.findProductsByCategory(CategoryProduct.CLOTHES));
        dataBase.printAllProducts();
        dataBase.removeProduct(CategoryProduct.FOR_CAR, "Дворник");
        System.out.println("----------------------------------");
        dataBase.printAllProducts();
    }

}
