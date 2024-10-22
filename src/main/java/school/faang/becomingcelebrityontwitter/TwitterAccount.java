package school.faang.becomingcelebrityontwitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TwitterAccount {
    private String username; // Уникальное имя учетной записи Twitter
    private int followers; // Количество подписчиков
}

