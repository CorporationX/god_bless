package school.faang.bjs269209;

import org.junit.jupiter.api.Test;
import school.faang.bjs269209.classes.Archer;
import school.faang.bjs269209.classes.Warrior;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {
    @Test
    public void testCreateArcher() {
        String name = "Robin";
        Archer archer = new Archer(name);

        assertEquals(name, archer.getName());
        assertEquals(Archer.BASE_AGILITY_VALUE, archer.getAgility());
        assertEquals(Archer.BASE_STRENGTH_VALUE, archer.getStrength());
        assertEquals(Archer.BASE_STAT_VALUE, archer.getIntelligence());
    }

    @Test
    public void testCreateWarrior() {
        String name = "Henry";
        Warrior warrior = new Warrior(name);

        assertEquals(name, warrior.getName());
        assertEquals(Warrior.BASE_STAT_VALUE, warrior.getAgility());
        assertEquals(Warrior.BASE_STRENGTH_VALUE, warrior.getStrength());
        assertEquals(Warrior.BASE_INTELLIGENCE_VALUE, warrior.getIntelligence());
    }

    @Test
    public void testArcherAttack() {
        Archer archer = new Archer("Robin");
        Warrior warrior = new Warrior("Henry");
        int warriorHealth = warrior.getHealth();

        archer.attack(warrior);

        assertEquals(warriorHealth - Archer.BASE_AGILITY_VALUE, warrior.getHealth());
    }

    @Test
    public void testWarriorAttack() {
        Archer archer = new Archer("Robin");
        Warrior warrior = new Warrior("Henry");
        int archerHealth = archer.getHealth();

        warrior.attack(archer);

        assertEquals(archerHealth - Warrior.BASE_STRENGTH_VALUE, archer.getHealth());
    }

    @Test
    public void testAttackCantReduceHealthBelowZero() {
        Archer archer = new Archer("Robin");
        Warrior warrior = new Warrior("Henry");
        int attacksCount = (warrior.getHealth() / Archer.BASE_AGILITY_VALUE) - 1;

        while (attacksCount > 0) {
            archer.attack(warrior);
            attacksCount--;
        }

        assertEquals(Archer.BASE_AGILITY_VALUE, warrior.getHealth());
        archer.attack(warrior);
        assertEquals(0, warrior.getHealth());
        archer.attack(warrior);
        assertEquals(0, warrior.getHealth());
    }
}