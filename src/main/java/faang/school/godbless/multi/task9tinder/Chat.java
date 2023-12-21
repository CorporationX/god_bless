package faang.school.godbless.multi.task9tinder;

import lombok.Getter;

@Getter
public class Chat {
    private final User user1;
    private final User user2;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        System.out.println("Началась захватывающщая переписка между " + user1.getName() + " и " + user2.getName());
    }

    public boolean containsUser(User user) {
        return user1.equals(user) || user2.equals(user);
    }
}
