package school.faang.stream3.synchronization.tamagotchivlad;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class TamagotchiVlad implements Runnable {
    private static final int MAX_LEVEL = 10;
    private static final int START_LEVEL = 8;
    private static final int START_COEFFICIENT = 1;

    private final String name;
    private int coefficient = getCoefficient();

    private List<String> needList = Arrays.asList("hygieneIndicator", "hungerIndicator",
            "energyIndicator", "funIndicator");
    private Map<String, Integer> needs =
            needList.stream()
                    .collect(Collectors.toMap(need -> need,
                            need -> START_LEVEL));

    public void feed() {
        synchronized (name) {
            int indicatorValue = inccreaseIndicator("hungerIndicator");
            needs.put("hungerIndicator", indicatorValue);
            System.out.printf("%s is eating. HungerIndicator = %d\n", name, indicatorValue);
        }
    }

    public void sleep() {
        synchronized (name) {
            int indicatorValue = inccreaseIndicator("energyIndicator");
            needs.put("energyIndicator", indicatorValue);
            System.out.printf("%s is sleeping. EnergyIndicator = %d\n", name, indicatorValue);
        }
    }


    public void clean() {
        synchronized (name) {
            int indicatorValue = inccreaseIndicator("hygieneIndicator");
            needs.put("hygieneIndicator", indicatorValue);
            System.out.printf("%s is taking a shower. HygieneIndicator = %d\n", name, indicatorValue);
        }
    }

    public void play() {
        synchronized (name) {
            int indicatorValue = inccreaseIndicator("funIndicator");
            needs.put("funIndicator", indicatorValue);
            System.out.printf("%s is having a good time. FunIndicator = %d\n", name, indicatorValue);
        }
    }

    private void timeRun() {
        needs.forEach((k, v) -> needs.put(k, Math.max(0, v - coefficient)));
        needs = needs.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> Math.max(0, entry.getValue())
                ));
    }

    @Override
    public void run() throws RuntimeException {
        while (true) {
            synchronized (name) {
                try {
                    Thread.sleep(3000);
                    timeRun();
                    if (needs.get("hungerIndicator") == 0) {
                        throw new RuntimeException(String.format("Game is over for %s", name));
                    }
                    if (needs.values().stream().anyMatch(v -> v == 0)) {
                        coefficient++;
                    } else {
                        coefficient = START_COEFFICIENT;
                    }
                    if (needs.get("hungerIndicator") == MAX_LEVEL) {
                        System.out.printf("%s is a well-fed tamagotchi\n", name);
                    }
                    if (needs.get("funIndicator") == MAX_LEVEL) {
                        System.out.printf("%s loves his live\n", name);
                    }
                    if (needs.get("energyIndicator") < 3) {
                        System.out.printf("%s is tired\n", name);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


    private int inccreaseIndicator(String indicator) {
        int indicatorValue = needs.get(indicator);
        if (indicatorValue + 3 > 10) {
            indicatorValue = 10;
        } else {
            indicatorValue = indicatorValue + 3;
        }
        return indicatorValue;
    }
}
