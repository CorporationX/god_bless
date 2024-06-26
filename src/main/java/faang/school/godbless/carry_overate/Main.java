package faang.school.godbless.carry_overate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.getCombinedItem();

        inventory.getExecutorService().shutdown();

        log.info("Current item list: " + inventory.getItems().toString());
    }
}
