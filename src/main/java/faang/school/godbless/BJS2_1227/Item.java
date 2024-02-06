package faang.school.godbless.BJS2_1227;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Item {
    private final Random random = new Random();
    private final double price;
    private String name;

    public Item(String name) {
        this.name = name;
        this.price = setPrice();
    }

    private double setPrice() {
        return random.nextDouble() * 10 + 1;
    }
}