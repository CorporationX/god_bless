package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CharacterTest {

    @Test
    void test(){
        Character archer =   new Archer("Леголас");
        Character warrior = new Warrior("Арагорн");
        archer.attack(warrior);
        archer.attack(warrior);
        assertThat(warrior.getHealth()).isEqualTo(80);
    }
}