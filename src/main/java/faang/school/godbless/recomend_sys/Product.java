package faang.school.godbless.recomend_sys;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;
    private List<String> tags;
}
