package gratsio_BJS2_68688;

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
        spellStorageAndManagementSystem.getSpellEventById(5);
        spellStorageAndManagementSystem.getSpellEventById(6);
        spellStorageAndManagementSystem.getSpellEventByType("Ice Attack Spell");
        spellStorageAndManagementSystem.getSpellEventByType("Fire Attack Spell");
        spellStorageAndManagementSystem.getSpellEventByType("A protective spell");
        spellStorageAndManagementSystem.deleteSpellEventsByType(5);
        spellStorageAndManagementSystem.getSpellEventById(5);
        spellStorageAndManagementSystem.getSpellEventByType("Ice Attack Spell");
        spellStorageAndManagementSystem.printAllSpellEvents();
    }
}
