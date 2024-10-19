package school.faang.walmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    private String itemName;
    private int price;

    @Override
    public String toString() {
        return itemName + " " + price;
    }
}
