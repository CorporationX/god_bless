package school.faang.split3.bjs2_81377;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SandlerRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо: %s отправленно%n", i);
        }
    }
}