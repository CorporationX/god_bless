package ru.kraiush.BJS2_33640;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private List<Item> inventories;
}
