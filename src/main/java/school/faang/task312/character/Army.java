package school.faang.task312.character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army {
    private List<Character> characters = new ArrayList<>();
    private ExecutorService service = Executors.newFixedThreadPool(5);

    public int calculateTotalPower() throws ExecutionException, InterruptedException {
        int totalStrength = 0;

        for (Character c : characters) {
            Future<Integer> strength = service.submit(new StrengthCalculator(c));
            totalStrength += strength.get();
        }

        service.shutdown();
        return totalStrength;
    }

    public void addUnit(Character character) {
        characters.add(character);
    }


}
