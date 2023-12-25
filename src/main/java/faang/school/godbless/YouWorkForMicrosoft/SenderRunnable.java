package faang.school.godbless.YouWorkForMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    public void run() {
        System.out.println("Письмa от " + startIndex + " до " + endIndex + " обработаны потоком " + Thread.currentThread().getName());
    }
}
