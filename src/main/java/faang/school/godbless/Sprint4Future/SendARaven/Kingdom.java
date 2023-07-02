package faang.school.godbless.Sprint4Future.SendARaven;

import lombok.Getter;

@Getter
public class Kingdom {
    private String name;
    private String message;

    public Kingdom(String name) {
        this.name = name;
    }

    public void sendMessage(Kingdom kingdom){
        kingdom.message = "Message";
    }
}
