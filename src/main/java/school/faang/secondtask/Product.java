package school.faang.secondtask;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private Category category;
}
