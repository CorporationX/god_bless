package faang.school.godbless.becometwitterceleb3193;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TwitterAccount {
    private String name;
    @Setter private int followers;

    public TwitterAccount(String name) {
        this.name = name;
        this.followers = 0;
    }

    @Override
    public String toString() {
        return String.format("%s - %d followers",
                this.getName(),
                this.getFollowers());
    }
}
