package faang.school.godbless.task.multithreading.async.carry.ate;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Getter
public class Inventory {
    private static final String CHEST_ITEM_PREFIX = "Chest item";
    private static final String STORE_ITEM_PREFIX = "Store item";
    private static final int MAX_ITEM_POWER = 250;
    private static final int MIN_ITEM_POWER = 50;
    private static final int SIGN_MAX_DIG = 9;
    private static final int MIN_CHAR = 65;
    private static final int MAX_CHAR = 90;
    private static final int SLEEP_MIN = 1000;
    private static final int SLEEP_MAX = 3000;

    private final Random random = new Random();
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        log.info("Add {} to inventory", item);
    }

    public Item combineItems(Item itemA, Item itemB) {
        var combItem = new Item(combName(itemA, itemB), itemA.power() + itemB.power());
        log.info("New combined item: {}", combItem);
        return combItem;
    }

    private String combName(Item itemA, Item itemB) {
        String signA = getSign(itemA.name());
        String signB = getSign(itemB.name());
        return "Combined item " + signA + signB;
    }

    private String getSign(String name) {
        return name.substring(name.lastIndexOf(" ") + 1);
    }

    public CompletableFuture<Item> chestGetItem() {
        log.info("Chest get item");
        return CompletableFuture.supplyAsync(() -> createItem(CHEST_ITEM_PREFIX));
    }

    public CompletableFuture<Item> buyItem() {
        log.info("Store, by item");
        return CompletableFuture.supplyAsync(() -> createItem(STORE_ITEM_PREFIX));
    }

    private Item createItem(String itemPrefix) {
        sleep();
        var newItem = new Item(itemPrefix + getNewSign(), getPower());
        log.info("New item: {}", newItem);
        return newItem;
    }

    private String getNewSign() {
        return " " + getChar() + getDigit();
    }

    private char getChar() {
        return (char) (random.nextInt(MAX_CHAR - MIN_CHAR) + MIN_CHAR);
    }

    private int getDigit() {
        return random.nextInt(SIGN_MAX_DIG - 1) + 1;
    }

    private int getPower() {
        return random.nextInt(MAX_ITEM_POWER - MIN_ITEM_POWER) + MIN_ITEM_POWER;
    }

    private void sleep() {
        try {
            Thread.sleep(random.nextInt(SLEEP_MAX - SLEEP_MIN) + SLEEP_MIN);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
