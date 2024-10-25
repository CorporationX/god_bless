package school.faang.Multithreading.sprint_4.Twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter

@AllArgsConstructor
public class TwitterAccount {
    private String username;
    @Setter
    private int followers;

    @Override
    public String toString() {
        return "TwitterAccount{" +
                "followers=" + followers +
                ", username='" + username + '\'' +
                '}';
    }
}
