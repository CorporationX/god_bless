package com.multithreading.alchemy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Potion {
    private String name;
    private int requiredIngredients;

    public Potion(String name) {
        this.name = name;
    }
}
