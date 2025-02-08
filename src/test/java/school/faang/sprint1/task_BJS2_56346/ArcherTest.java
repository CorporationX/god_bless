package school.faang.sprint1.task_BJS2_56346;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест класса Archer")
class ArcherTest {
    private Character archer;
    private Character opponentWarrior;
    private int opponentHealth;
    private int archerAttack;

    @BeforeEach
    public void setUp() {
        archer = new Archer("Леголас");
        opponentWarrior =  new Warrior("Ахилес сын Пелея");
        opponentHealth = opponentWarrior.getHealth();
        archerAttack = archer.getAgility();
    }

    @Test
    public void attack() {
        archer.attack(opponentWarrior);
        assertEquals(opponentHealth - archerAttack, opponentWarrior.getHealth());
    }

    @Test
    public void zeroHealthOpponent() {
        int maxCountAttack = Math.round(((float) opponentHealth / archerAttack));

        for (int i = 0; i < maxCountAttack; i++) {
            archer.attack(opponentWarrior);
        }
        assertEquals(0, opponentWarrior.getHealth());
    }
}