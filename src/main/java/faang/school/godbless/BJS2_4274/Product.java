package faang.school.godbless.BJS2_4274;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class Product {

    private final static Set<Long> ID = new HashSet<>();

    private Long id;
    private String name;
    private String category;

    public Product(String name, String category) {
        validateData(name, category);
        this.id = generateId();
        this.name = name;
        this.category = category;
    }

    private void validateData(String name, String category) {
        if (name.isBlank() || category.isBlank()) {
            throw new IllegalArgumentException("Not be empty");
        }
    }

    private Long generateId() {
        Long id = ID.isEmpty() ? 1 : Collections.max(ID) + 1;
        ID.add(id);
        return id;
    }
}
