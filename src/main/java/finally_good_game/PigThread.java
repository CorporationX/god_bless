package finally_good_game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;
    private int constructionTime;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(pigName + " is building a house from " + material);
        Thread.sleep(constructionTime);
        System.out.println(pigName + " has finished building the house");
    }
}
