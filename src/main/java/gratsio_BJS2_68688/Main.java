package gratsio_BJS2_68688;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells spellStorageAndManagementSystem = new HogwartsSpells();
        spellStorageAndManagementSystem.addSpellEvent("Fire Attack Spell",
                "Releases a fireball at the opponent opposite");
        spellStorageAndManagementSystem.addSpellEvent("Ice Attack Spell",
                "Shoots ice needles at the opponent opposite");
        spellStorageAndManagementSystem.addSpellEvent("A protective spell",
                "Creates a barrier that protects against most attacks");
        spellStorageAndManagementSystem.addSpellEvent("Fire Attack Spell",
                "Creates fire arrows and shoots them at one or more opponents");
        spellStorageAndManagementSystem.addSpellEvent("Ice Attack Spell",
                "Releases a trail of ice spikes towards the enemy");
        spellStorageAndManagementSystem.printAllSpellEvents();
        if (spellStorageAndManagementSystem.getSpellEventById(5) != null) {
            System.out.println(spellStorageAndManagementSystem.getSpellEventById(5));
        } else {System.out.println("There is no such spell event in our spell storage and management system!");}
        if (spellStorageAndManagementSystem.getSpellEventById(6) != null) {
            System.out.println(spellStorageAndManagementSystem.getSpellEventById(5));
        } else {System.out.println("There is no such spell event in our spell storage and management system!");}
        spellStorageAndManagementSystem.deleteSpellEventsByType(5);
        if (spellStorageAndManagementSystem.getSpellEventById(5) != null) {
            System.out.println(spellStorageAndManagementSystem.getSpellEventById(5));
        } else {System.out.println("There is no such spell event in our spell storage and management system!");}
        if(!spellStorageAndManagementSystem.getSpellEventByType("Ice Attack Spell").isEmpty()) {
            for (SpellEvent spells : spellStorageAndManagementSystem.getSpellEventByType("Ice Attack Spell")){
                System.out.println(spells);
            }
        }
        spellStorageAndManagementSystem.printAllSpellEvents();
    }
}
