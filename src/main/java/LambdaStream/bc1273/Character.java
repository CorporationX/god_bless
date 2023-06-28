package LambdaStream.bc1273;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
