package school.faang.catchingEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        List<String> spellNames = new ArrayList<>(List.of("Protego", "Protego Totalum", "Expelliarmus",
                "Stupefy", "Sectumsempra", "Reducto",
                "Avada Kedavra", "Cruciatus", "Imperius"));
        List<String> spellTypes = new ArrayList<>(List.of("Defensive Spells", "Offensive Spells",
                "Unforgivable Curses", "Non-existent type"));
        List<String> spellDescriptions = new ArrayList<>(List.of("Creates a magical shield that deflects spells",
                "A stronger version of Protego, creates protection over a large area",
                "Disarms the opponent, causing their wand or weapon to fly away",
                "Stuns the opponent, rendering them unconscious", "Causes deep cuts and bleeding",
                "Breaks or shatters an object, can be used to damage enemies.",
                "Instantly kills the target", "Causes unbearable pain", "Controls the victim's will"));

        int idxFoType = -1;
        for (int i = 0; i < spellNames.size(); i++) {
            idxFoType = i % 3 == 0 ? ++idxFoType : idxFoType;
            hogwartsSpells.addSpellEvent(spellNames.get(i), spellTypes.get(idxFoType), spellDescriptions.get(i));
        }
        hogwartsSpells.printAllSpellEvents();
        for (String spellType : spellTypes) {
            try {
                System.out.println(spellType + " " + hogwartsSpells.getSpellsByType(spellType));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.println(i + " " + hogwartsSpells.getSpellEventById(i));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        hogwartsSpells.deleteSpellEvent(4);
        hogwartsSpells.printAllSpellEvents();
    }

}
