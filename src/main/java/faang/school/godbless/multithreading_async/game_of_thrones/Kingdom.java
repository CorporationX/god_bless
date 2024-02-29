package faang.school.godbless.multithreading_async.game_of_thrones;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom kingdom){
        return "Какое то сообщение";
    }
}
