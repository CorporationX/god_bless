package derschrank.sprint04.task12.bjstwo_50778;

import java.util.Random;

public class Service {
    public static final Random RND = new Random();
    private static final int MAX_POWER = 10;
    private static final String[] ITEMS_FIRST_WORDS = getItemsFirstWords();
    private static final String[] ITEMS_SECOND_WORDS = getItemsSecondWords();

    public static void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillItemsInProvider(ProviderItemsInterface inBox, int count) {
        for (int i = 0; i < count; i++) {
            inBox.addItem(new Item(generateName(i), generatePower()));
        }
    }

    private static int generatePower() {
        return RND.nextInt(MAX_POWER);
    }

    private static String generateName(int index) {
        String firstWord = ITEMS_FIRST_WORDS[index % ITEMS_FIRST_WORDS.length];
        String secondWord = ITEMS_SECOND_WORDS[(index + index / ITEMS_SECOND_WORDS.length) % ITEMS_SECOND_WORDS.length];

        return firstWord + " " + secondWord;
    }

    private static String[] getItemsFirstWords() {
        return new String[]{
                "Ancient", "Enchanted", "Shadow", "Mystic", "Flaming",
                "Frozen", "Thunder", "Crystal", "Dark", "Holy",
                "Venomous", "Golden", "Steel", "Phantom", "Ethereal",
                "Blood", "Storm", "Infernal", "Cursed", "Radiant"
        };
    }

    private static String[] getItemsSecondWords() {
        return new String[]{
                "Blade", "Shield", "Amulet", "Bow", "Ring",
                "Staff", "Orb", "Helmet", "Boots", "Gauntlets",
                "Armor", "Dagger", "Axe", "Crown", "Pendant",
                "Lantern", "Spear", "Tome", "Cape", "Quiver"
        };
    }
}
