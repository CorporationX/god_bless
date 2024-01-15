package faang.school.godbless.raven;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Kingdom {
    private String name;
    public String sendMessage(Kingdom receiver){
        System.out.printf("%s sends message to %s%n", this.name, receiver.name);
        return "message delivered!";
    }
}
