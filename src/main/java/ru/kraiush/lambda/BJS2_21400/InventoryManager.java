package ru.kraiush.lambda.BJS2_21400;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InventoryManager {

    Character character;
    Item item;

    public InventoryManager addItem(Character character, Item item) {
//        public List<InventoryManager> addItem(Character character, Item item,) {
        return new InventoryManager(character, item);
    }


    public void addItem(Character character, Item item, Object o) {
    }
}
