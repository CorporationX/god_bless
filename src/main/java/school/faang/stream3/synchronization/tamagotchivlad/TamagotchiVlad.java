package school.faang.stream3.synchronization.tamagotchivlad;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class TamagotchiVlad implements Runnable {
    private final static int MAX_LEVEL = 10;
    private final static int START_LEVEL = 8;
    private final static int START_COEFFICIENT = 1;

    private final String name;
    private int coefficient = getCoefficient();

    private List<String> needList = Arrays.asList("hygieneIndicator", "hungerIndicator",
            "energyIndicator", "funIndicator");
    private Map<String, Integer> needs =
            needList.stream()
                    .collect(Collectors.toMap(need -> need,
                            need -> START_LEVEL));

    public void feed() {
        synchronized (name){
            needs.put("hungerIndicator", needs.get("hungerIndicator") +3);
            System.out.printf("%s is eating\n", name);
        }
    }

    public void sleep() {
        synchronized (name){
            needs.put("energyIndicator", needs.get("energyIndicator") +3);
            System.out.printf("%s is sleeping\n", name);
        }
    }

    public void clean() {
        synchronized (name){
            needs.put("hygieneIndicator", needs.get("hygieneIndicator") +3);
            System.out.printf("%s is taking a shower\n", name);
        }
    }

    public void play() {
        synchronized (name){
            needs.put("funIndicator", needs.get("funIndicator") +3);
            System.out.printf("%s is having a good time\n", name);
        }
    }

    private void timeRun (){
        needs.forEach((k, v) -> needs.put(k, Math.max(0, v - coefficient)));
    }

    @Override
    public void run() {
        while (true) {
            synchronized (name) {
                try {
                    Thread.sleep(3000);
                    timeRun();
                    if (needs.get("hungerIndicator") == 0){
                        throw new RuntimeException(String.format("Game is over for %s", name));
                    }
                    if (needs.values().stream().anyMatch(v -> v == 0)){
                        coefficient++;
                    } else {
                        coefficient = START_COEFFICIENT;
                    }
                    if (needs.get("hungerIndicator") == MAX_LEVEL){
                        System.out.printf("%s is a well-fed tamagotchi\n", name);
                    }
                    if (needs.get("funIndicator") == MAX_LEVEL){
                        System.out.printf("%s loves his live\n", name);
                    }
                    if (needs.get("energyIndicator") < 3){
                        System.out.printf("%s is tired\n", name);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
