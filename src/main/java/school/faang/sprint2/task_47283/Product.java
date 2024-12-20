package school.faang.sprint2.task_47283;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Product {
    private final int productId;
    private final String name;
    private final String category;
    private final int price;
    private final List<String> tags;

    @JsonCreator
    public Product(
            @JsonProperty("productId") int productId,
            @JsonProperty("name") String name,
            @JsonProperty("category") String category,
            @JsonProperty("price") int price,
            @JsonProperty("tags") List<String> tags) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.tags = tags;
    }
}
