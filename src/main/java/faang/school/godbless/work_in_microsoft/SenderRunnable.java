package faang.school.godbless.work_in_microsoft;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++){
            System.out.println("Email " + i + " is sent. " + Thread.currentThread().getName());
        }
    }


}
