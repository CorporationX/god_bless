package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TelegramBot {
    private final static int REQUEST_LIMIT = 5;
    long lastRequestTime;
    int requestCounter;


    public synchronized void sendMessage(String message) {
        long timeNow = System.currentTimeMillis();
        long deltaTime = timeNow - lastRequestTime;
        if (deltaTime<1000){
            requestCounter++;
            if(requestCounter>REQUEST_LIMIT){
                try{
                    Thread.sleep(1000 - deltaTime);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = 0;
        }
        System.out.println(message + " все ху... переделывай !");
    }
}
