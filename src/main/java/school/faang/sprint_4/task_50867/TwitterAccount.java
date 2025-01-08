package school.faang.sprint_4.task_50867;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TwitterAccount {
    private String username;
    private int followers;

    public synchronized void addFollower() {
        followers++;
    }

    @Override
    public String toString() {
        return "Аккаунт: " + username + " Кол-во подписчиков: " + followers;
    }
}
