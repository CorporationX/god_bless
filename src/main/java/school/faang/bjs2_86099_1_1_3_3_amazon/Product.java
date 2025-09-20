package school.faang.bjs2_86099_1_1_3_3_amazon;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
public class Product {
    public static int ids = 0;

    private Integer id;
    @Getter
    private String name;
    @Getter
    private Category category;

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) && getCategory() == product.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCategory());
    }
}
