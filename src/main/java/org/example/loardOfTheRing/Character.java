package org.example.loardOfTheRing;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor
public class Character {
    private String name;
    private LinkedList<Item> inventory;
}
