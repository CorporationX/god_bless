package faang.school.godbless.multithreading.heroesArmy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class CharacterThread extends Thread {

    private Character character;
    private int power;

    @Override
    public void run() {
        setPower(character.getPower());
    }
}
