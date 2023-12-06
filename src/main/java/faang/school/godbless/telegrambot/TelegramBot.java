package faang.school.godbless.telegrambot;

public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final long TIME_LIMIT = 1000;
    private long lastRequestTime;
    private int requestCounter;

    public TelegramBot(){
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void messageHandler(String message){
        long currentTime = System.currentTimeMillis();
        long timeBetweenRequests = currentTime - lastRequestTime;

        if (timeBetweenRequests < TIME_LIMIT){
            if (requestCounter > REQUEST_LIMIT){
               sleep(message, timeBetweenRequests);
            }
            requestCounter++;
            sendMessage(message);
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
        }
    }

    private void sendMessage(String message){
        System.out.println("Message sent: " + message);
    }

    private void sleep(String message, Long timeBetweenRequests){
        try {
            Thread.sleep(TIME_LIMIT - timeBetweenRequests);
            sendMessage(message);
            System.out.println("waiting time: " + (TIME_LIMIT - timeBetweenRequests));
            requestCounter = 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}