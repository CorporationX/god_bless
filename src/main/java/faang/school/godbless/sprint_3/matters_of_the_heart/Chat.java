package faang.school.godbless.sprint_3.matters_of_the_heart;

import lombok.Data;

@Data
public class Chat {
    private User owner;
    private User secondUser;

    public Chat(User owner) {
        this.owner = owner;
    }
}