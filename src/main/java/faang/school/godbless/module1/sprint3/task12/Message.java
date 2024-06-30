package faang.school.godbless.module1.sprint3.task12;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Message {

    private final String text;
    private final LocalTime createTime;

    public Message(){
        this.text = "Hello";
        this.createTime = LocalTime.now();
    }
}
