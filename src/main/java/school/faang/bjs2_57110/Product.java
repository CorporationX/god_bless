package school.faang.bjs2_57110;

import lombok.Data;

@Data
public class Product {

    private int id;
    private String name;
    private Category category;

    public Product(int id, String name, Category category) {
        validateProduct(name, category);
        this.id = id;
        this.name = name;
        this.category = category;
    }

    private void validateProduct(String name, Category category) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Необходимо заполнить наименование продукта");
        }
        if (category == null || category.toString().isBlank()) {
            throw new IllegalArgumentException("Необходимо заполнить информацию о категории продукта");
        }
    }

}
