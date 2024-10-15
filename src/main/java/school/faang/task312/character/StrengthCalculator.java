package school.faang.task312.character;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class StrengthCalculator implements Callable<Integer> {
    Character character;

    @Override
    public Integer call() throws Exception {
        return character.getStrength();
    }

}
