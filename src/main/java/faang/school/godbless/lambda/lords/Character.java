package faang.school.godbless.lambda.lords;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Item> itemList = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
