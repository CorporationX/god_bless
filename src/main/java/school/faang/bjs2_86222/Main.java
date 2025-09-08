package school.faang.bjs2_86222;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ СКЛАДА AMAZON ===\n");

        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Булка");
        productManager.addProduct(Category.FOOD, "Пончик");
        productManager.addProduct(Category.FOOD, "Банан");
        productManager.addProduct(Category.CLOTHING, "Трусы Calvin Klein с базара");
        productManager.addProduct(Category.CLOTHING, "Кепка с пропеллером");
        productManager.addProduct(Category.CLOTHING, "Галоши");
        productManager.addProduct(Category.OTHER, "Свисток");
        productManager.addProduct(Category.OTHER, "Мячик");
        productManager.addProduct(Category.OTHER, "Накладные усы");

        System.out.println("\nТекущее состояние склада:");
        productManager.printAllProducts();

        System.out.println("\n2. Удаление продукта:");
        productManager.removeProduct(Category.CLOTHING, "Галоши");
        productManager.removeProduct(Category.OTHER, "Свисток");

        System.out.println("\nСостояние после удаления:");
        productManager.printAllProducts();

        System.out.println("\n3. Поиск продуктов по категории:");

        System.out.println(productManager.findProductsByCategory(Category.CLOTHING));

        System.out.println("\n4. Тестирование валидации:");
        try {
            productManager.addProduct(Category.OTHER, "    ");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}
