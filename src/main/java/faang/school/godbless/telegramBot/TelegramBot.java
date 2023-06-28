package faang.school.godbless.telegramBot;

import java.util.Date;

public class TelegramBot {
    private final int REQUEST_LIMIT;
    private int requestCounter;
    private Date lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT, Date lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.lastRequestTime = lastRequestTime;
    }

    public void sendMessage(){
        long currentTime = new Date().getTime();
        long pastTime = currentTime - lastRequestTime.getTime();
        if(pastTime>1000){
            requestCounter = 0;
            lastRequestTime = null;
        } else {
            requestCounter++;
        }
        if(requestCounter>REQUEST_LIMIT) {
            try {
                Thread.sleep(1000-pastTime);
            } catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Сообщение отправлено");

    }
}
