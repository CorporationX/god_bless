package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.lordoftherings;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Character {

    private String name;

    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }
}
