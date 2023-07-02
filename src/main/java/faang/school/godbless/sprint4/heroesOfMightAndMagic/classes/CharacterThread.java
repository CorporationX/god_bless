package faang.school.godbless.sprint4.heroesOfMightAndMagic.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CharacterThread extends Thread {
    private int totalPower;

    public void run() {
        //some logic?
        System.out.println("Calculate...");
    }
}
