package school.faang.amazonwarehouse;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class ProductManager {
    private final Set<Product> products;

    //: создает новый продукт с указанной категорией и именем, добавляет его в множество продуктов products.
    public Product addProduct(Category category, String name) {
    }

    //: находит продукт с указанным именем в указанной категории и удаляет его из множества продуктов products.
    removeProduct(Category category, String name) {
    }

    //: возвращает список всех продуктов в указанной категории. Если категория отсутствует, метод возвращает пустой список.
    findProductsByCategory(Category category) {
    }

    //: возвращает Map<Category, List<Product>> , где ключом выступает категория,
    // а значением — список продуктов, принадлежащих этой категории.
    // Для этого необходимо сгруппировать все текущие продукты из множества products по их категориям.
    groupProductsByCategory() {
    }

    /*  Категория: FOOD
        Продукты:
        - Apple
        - Bread

        Категория: ELECTRONICS
        Продукты:
        - Laptop
        - Smartphone
        */
    printAllProducts() {

    }

}