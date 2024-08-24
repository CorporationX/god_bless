package thread.six;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trial implements Runnable {

    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " начинает свое испытание: " + trialName);

        try {
            Thread.sleep(2000);
            System.out.println(knightName + " завершил испытание: " + trialName);
        } catch (InterruptedException e) {
            System.out.println("Что-то прервало прохождение испытания");
        }
    }
}
