package school.faang;
import school.faang.invetory.Character;
import school.faang.invetory.InventoryManager;
import school.faang.invetory.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Item soulOfAChampion = new Item("Soul of a Champion", 2500);
        Item gotthardTwinswords = new Item("Gotthard Twinswords", 10000);
        Item hollowslayerGreatsword = new Item("Hollowslayer Greatsword", 15000);

        Character anri  = new Character("Anri", new ArrayList<>());
        Character siegward = new Character("Siegward", new ArrayList<>(Arrays.asList(hollowslayerGreatsword)));
        InventoryManager manager = new InventoryManager();


        manager.addItem(
                anri ,
                soulOfAChampion,
                (item) -> System.out.println(anri.getName() + " подобрал " + item.getName())
        );
        manager.addItem(
                siegward ,
                gotthardTwinswords,
                (item) -> System.out.println(siegward.getName() + " подобрал " + item.getName())

        );
        Predicate<Email> importantFilter = email -> email.isImpotant();
        Consumer<Email> printEmail = email ->
                System.out.println("Обработано письмо: " + email.getSubject());

        System.out.println("==================");

        Function<Email, String> toUpperCase = email -> email.getBody().toUpperCase();
        EmailProcessor.processEmails(emails, importantFilter, toUpperCase, printEmail);
        manager.removeItem(
                siegward ,
                (item) -> item.getName().equals("Hollowslayer Greatsword")
        );

        manager.updateItem(
                siegward ,
                (item) -> item.getName().equals("Gotthard Twinswords"),
                (item) -> new Item(item.getName(), item.getValue() * 5)
        );

        anri .getInventory().forEach(item -> System.out.println(anri.getName() + ":" + item.getName() + " : " + item.getValue()));
        siegward .getInventory().forEach(item -> System.out.println(siegward.getName() + ":" + item.getName() + " : " + item.getValue()));
    }
}
