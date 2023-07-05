package faang.school.godbless.homm_army;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@Data
@NoArgsConstructor
public class Army {

    private List<Character> army = new ArrayList<>();
    private int totalPower;

    @SneakyThrows
    public int calculateTotalPower() {
        int totalPower = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (var soldier : army) {
            Future<Integer> power = executorService.submit(soldier);
            totalPower += power.get();
        }
        executorService.shutdown();
        return totalPower;
    }

    public List<Character> generateCharacterList(Class<? extends Character> characterClass, int power, int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> createCharacter(characterClass, power))
                .toList();
    }

    @SneakyThrows
    private Character createCharacter(Class<? extends Character> characterClass, int power) {
        return characterClass.getConstructor(int.class).newInstance(power);
    }

    public void addUnit(Character character) {
        army.add(character);
    }

    public void addUnits(List<Character> characters) {
        army.addAll(characters);
    }
}