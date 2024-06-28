package faang.school.godbless.module1.sprint3.task12;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TelegramBot {
    private final int REQUEST_LIMIT;
    private List<Message> requests;
    @Setter
    private int requestCounter;
    @Setter
    private LocalTime lastRequestTime;
    private final Object object;

    public TelegramBot() {
        this.requestCounter = 0;
        this.REQUEST_LIMIT = 5;
        this.lastRequestTime = LocalTime.now();
        this.object = new Object();
        this.requests = new ArrayList<>();
    }

    public void sentMessage(Message message) throws InterruptedException {
        long creatRequest = message.getCreateTime().toNanoOfDay();
        long deltaRequest = (creatRequest - getLastRequestTime().toNanoOfDay()) / 1000000;
        if (deltaRequest < 1000 && getRequestCounter() < REQUEST_LIMIT) {
            requests = addMessage(message, requests);
        } else if (deltaRequest < 1000 && getRequestCounter() >= REQUEST_LIMIT){
            Thread.sleep(1000 - deltaRequest);
            sentRequests(requests);
        } else {
            requestCounter = 0;
            lastRequestTime = LocalTime.ofSecondOfDay(0);
        }
    }

    private void sentRequests(List<Message> requests) {
        synchronized (object) {
            requests.forEach(text -> System.out.println(text.getText()));
            requests.clear();
            System.out.println("Requests send");
            object.notify();
        }

    }


    public List<Message> addMessage(Message message, List<Message> listOfMessage) throws InterruptedException {
        synchronized (object) {
            if (listOfMessage.size() == REQUEST_LIMIT) {
                System.out.println("Pool filling");
                object.wait();
            }
            listOfMessage.add(message);
            setRequestCounter(listOfMessage.size());
            System.out.println("Message add");
            return listOfMessage;
        }

    }
}