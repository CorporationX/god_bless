package abstractionAbstractionTest;

import abstractionAbstraction.Archer;
import abstractionAbstraction.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {

    private Archer archer;

    @BeforeEach
    void setUp(){
        archer = new Archer("Silvana");
    }

    @Test
    @DisplayName("Positive test")
    void attackTest() {
        // Arrange
        Warrior warrior = new Warrior("Grommash");
        // Act
        archer.attack(warrior);
        // Assert
        assertEquals(90, warrior.getHp());
    }
}
