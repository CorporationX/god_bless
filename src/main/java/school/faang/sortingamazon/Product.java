package school.faang.sortingamazon;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(int id, String name, Category category) {
        validateData(name, category);
        this.id = id;
        this.name = name;
        this.category = category;
    }

    private void validateData(String name, Category category) {
        if (name == null) {
            throw new NullPointerException("Значение имени товара не может быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя товара не может быть пустым");
        }

        if (category == null) {
            throw new NullPointerException("Категория товара не может быть null");
        }
    }
}
