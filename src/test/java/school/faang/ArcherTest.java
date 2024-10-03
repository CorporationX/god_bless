package school.faang;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArcherTest {

    @Test
    void attack_shouldDecreaseHealthOfCharacterByDexterity(){
        // given
        int expectedHealth = 90;
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");

        // when
        archer.attack(warrior);

        // then
        assertThat(warrior.health).isEqualTo(expectedHealth);
    }

}