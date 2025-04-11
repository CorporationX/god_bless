package school.faang.bjs2_69541;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
@EqualsAndHashCode
public class Product {
    public static final String ID_IS_EMPTY = "Product id is empty;";
    public static final String NAME_IS_EMPTY = "Product name is empty;";
    public static final String CATEGORY_IS_EMPTY = "Product category is empty;";

    private final Integer id;
    private final String name;
    private final Category category;

    public Product(Integer id, String name, Category category) {
        validateInputData(id, name, category);
        this.id = id;
        this.name = name;
        this.category = category;
    }

    private void validateInputData(Integer id, String name, Category category) {
        StringBuilder error = new StringBuilder();
        if (id == null) {
            appendError(error, ID_IS_EMPTY);
        }
        if (name == null || name.isBlank()) {
            appendError(error, NAME_IS_EMPTY);
        }
        if (category == null) {
            appendError(error, CATEGORY_IS_EMPTY);
        }
        if (!error.isEmpty()) {
            throw new NoSuchElementException(error.toString());
        }
    }

    private void appendError(StringBuilder error, String errorMessage) {
        if (!error.isEmpty()) {
            error.append(" ");
        }
        error.append(errorMessage);
    }
}
