package school.BJS2_38819;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {

    private String name;
    private int power;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}