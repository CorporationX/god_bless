package school.faang.bjs279877;

public class Main {
    public static void main(String[] args) {
        ProductManager dataBase = new ProductManager();
        //Попытка вывести все значения при пустых значения
        dataBase.printAllProducts();
        System.out.println("----------------------------------");
        // Проверка на добавления значений
        dataBase.addProduct(Category.FOOD, "Курятина");
        dataBase.addProduct(Category.FOR_CAR, "Дворник");
        dataBase.addProduct(Category.FOOD, "Говядина");
        System.out.println("----------------------------------");
        //проверка на добавления такого же продукта
        dataBase.addProduct(Category.FOOD, "Курятина");
        dataBase.addProduct(Category.FOR_CAR, "Дворник");
        System.out.println("----------------------------------");
        //Поиск по категории товара
        System.out.println(dataBase.findProductsByCategory(Category.FOOD));
        System.out.println("----------------------------------");
        //Поиск по каталогам в которых нету товара
        System.out.println(dataBase.findProductsByCategory(Category.CLOTHES));
        //Вывод товара и заодно проверка метода groupProductsByCategory
        dataBase.printAllProducts();
    }

}
