package faang.school.godbless.sendCrow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom gettingKingdom, String message){
        if(message.equals("")){
            throw new IllegalArgumentException("Нет слов в сообщении");
        }
        return name + " отправил сообщение " + gettingKingdom.getName() + ":\n-\"" + message + "\"";
    }
}
