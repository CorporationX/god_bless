package ru.kraiush.threads.BJS2_24490;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@ToString
public class TelegramBot implements Runnable {

    private int REQUEST_LIMIT;
    private int requestCounter;
    private Date lastRequestTime;

    public TelegramBot(int REQUEST_LIMIT, Date lastRequestTime) {
        this.REQUEST_LIMIT = REQUEST_LIMIT;
        this.lastRequestTime = lastRequestTime;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " --- Start at: " + new Date());
        sendMessage();
        System.out.println("Thread: " + Thread.currentThread().getName() + " --- End at: " + new Date());
    }

    public void sendMessage() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        requestCounter = requestCounter + 1;
        System.out.println("Thread: " + Thread.currentThread().getName() + "  - requestCounter: " + requestCounter);
        if (requestCounter > REQUEST_LIMIT) {
//            System.out.println("> Thread: " + Thread.currentThread().getName() + " upper REQUEST_LIMIT " ) ;
            Date dateNow = new Date();
            while (getDateDiff(dateNow, lastRequestTime, timeUnit) < 1000L) {
                dateNow = new Date();
//                System.out.println("> Thread: " + Thread.currentThread().getName() + " - dateNow: " + dateNow);
            }
            requestCounter = 0;
            lastRequestTime = dateNow;
            System.out.println(">>> Above the limit ==> sended!");
        } else {
            requestCounter = requestCounter - 1;
            System.out.println("<<< Below the limit ==> sended!");
        }
    }

    public static long getDateDiff(Date date2, Date date1, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
//        System.out.println("diffInMillies: " + diffInMillies);
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}