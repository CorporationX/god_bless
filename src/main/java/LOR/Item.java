package LOR;

import lombok.Getter;

@Getter
public class Item {
    private final String name;
    private final int value;

    Item(String name, int value){
        this.name = name;
        this.value = value;
    }
}

