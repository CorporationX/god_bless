package school.faang.sortingamazon;

import lombok.Getter;

@Getter
public class Product {
    private final int id;
    private final String name;
    private final Category category;

    public Product(int id, String name, Category category) {
        if (name == null) {
            throw new NullPointerException("Значение имени товара не может быть null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя товара не может быть пустым");
        }

        if (category == null) {
            throw new NullPointerException("Категория товара не может быть null");
        }

        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return name.equals(product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
