package school.faang.three.little.pigs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println("Поросенок " + pigName + " строит дом из " + material);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
