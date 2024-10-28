package school.faang.BJS2_39199;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TwitterAccount {
    private final String username;
    private int followers;

    public synchronized void addFollower() {
        followers++;
        System.out.printf("Подписчик добавлен к аккаунту %s. Текущее количество подписчиков: %d \n", username, followers);
    }
}
