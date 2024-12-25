package school.faang.task_50724;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>());
        inventory.combiningItems().join();
        inventory.getItems().forEach(System.out::println);
    }
}
