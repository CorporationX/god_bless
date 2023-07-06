package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    long lastRequestTime;
    int requestCounter;


    public synchronized void sendMessage(String message) throws InterruptedException {
        long timeNow = System.currentTimeMillis();
        long deltaTime = timeNow - lastRequestTime;
        while (deltaTime < 1000) {
            if(requestCounter==REQUEST_LIMIT) {
                wait(1000 - deltaTime);
            }
            deltaTime = System.currentTimeMillis() - lastRequestTime;
            if (deltaTime >= 1000 && requestCounter == REQUEST_LIMIT) {
                System.out.println("обнуление счетчика");
                requestCounter = 0;
            }
        }
        requestCounter++;
        System.out.println(message + " все ху... переделывай !");
        lastRequestTime = System.currentTimeMillis();
        notify();
    }
}
