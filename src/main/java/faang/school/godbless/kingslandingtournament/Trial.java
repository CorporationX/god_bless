import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @SneakyThrows
    public void run() {
        List<String> result = List.of(" выполнил испытание ", " провалил испытание ");
        System.out.println("Рыцарь " + knightName + " начал выполнять испытание " + trialName);
        Thread.sleep(1000);
        System.out.println("Рыцарь " + knightName + result.get(new Random().nextInt(result.size())) + trialName);
    }
}
