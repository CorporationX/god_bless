package org.example.loardOfTheRing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private int value;

    public Item(String name) {
        this.name = name;
    }
}
