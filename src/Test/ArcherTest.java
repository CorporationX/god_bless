package src.Test;

import faang.school.godbless.Archer;
import org.junit.jupiter.api.Test;

public class ArcherTest {
    private Archer archer;
    private static final String ARCHER_NAME="Pantera";

    public void setArcherName(){
        archer=new Archer(ARCHER_NAME);
    }
    @Test
    public void testArcherConstructors(){
        assertEquals(ARCHER_NAME,archer.getName());
        assertEquals(Archer.POWER_OF_Warrior, archer.getPower());
        assertEquals(Archer.AGILITY_OF_Warrior, archer.getAgility());
        assertEquals(Archer.INTELLECT_OF_Warrior, archer.getIntellect());
    }
    @Test
    public void testAttack(){
        Archer archer1=new Archer("Black Warrior");
        int healthValue=archer1.getHealth()-archer.getAgility();
        archer.attack(archer1);
        assertEquals(archer1.getHealth(), healthValue);
    }

    private void assertEquals(int health, int healthValue) {

    }

    private void assertEquals() {
    }
}
