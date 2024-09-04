package faang.school.godbless.dolbahlop;

import faang.school.godbless.dolbahlop.Abstractions.Archer;
import faang.school.godbless.dolbahlop.Abstractions.Warrior;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
public class AttackTest {
    @ParameterizedTest
    @CsvSource({
            "Conan, 10, Legolas, 100, 90",  // Warrior attack Archer
            "Legolas, 10, Conan, 100, 90"   // Archer attack Warrior
    })
    void testCharacterAttack(String attackerName, int attackerDamage, String defenderName, int initialHealth, int expectedHealthAfterAttack) {
        // Arrange
        Warrior warrior = new Warrior(attackerName);
        Archer archer = new Archer(defenderName);

        if (attackerName.equals("Conan")) {
            // Act
            warrior.attack(archer);
        } else if (attackerName.equals("Legolas")) {
            // Act
            archer.attack(warrior);
        }

        // Assert
        assertEquals(expectedHealthAfterAttack, (attackerName.equals("Conan") ? archer.getVitality() : warrior.getVitality()), "Health should be updated correctly after attack");
    }
}
