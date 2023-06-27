package main.java.faang.school.godbless.spam;

import java.util.List;

public class MessageProcessor {

    public void isValid(String stroke, List<MessageFilter> filter){
        if (stroke == null || stroke.isEmpty()){
            throw new IllegalArgumentException("Пустая строка");
        } else if (filter == null || filter.isEmpty()) {
            throw new IllegalArgumentException("Пустой лист");
        }
    }
    public void processMessage(String stroke, List<MessageFilter> filter) {
        isValid(stroke, filter);
        int count = 1;
        for (MessageFilter message : filter) {
            if (!message.filter(stroke)){
                throw new IllegalArgumentException("Строка: " + stroke+ " не прошел " + count + " фильтр");
            }else {
                System.out.println("Строка: " + stroke+ " прошла " + count + " фильтр");
                count++;
            }
        }
    }
}
