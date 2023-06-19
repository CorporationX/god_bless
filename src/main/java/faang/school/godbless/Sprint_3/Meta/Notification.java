package faang.school.godbless.Sprint_3.Meta;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class Notification {
    private String type;
    private String message;
    Set<String> blackList = new HashSet<>(List.of(new String[]{"Yandex","yandex", "Fakng", "fakng"}));

    public Notification(String type, String message) {
        this.type = type;
        for(String x : blackList) {
            if(message.contains((x))) message = message.replace(x, "*".repeat(x.length()));
        }
        this.message = message;
    }
}
