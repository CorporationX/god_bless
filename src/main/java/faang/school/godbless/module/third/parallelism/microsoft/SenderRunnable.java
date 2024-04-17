package faang.school.godbless.module.third.parallelism.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    
    @Override
    public void run() {
        System.out.printf("Приняли письма с %d по %d \n", startIndex, endIndex);
        System.out.printf("Успешно отправили письма с %d по %d \n", startIndex, endIndex);
    }
}
