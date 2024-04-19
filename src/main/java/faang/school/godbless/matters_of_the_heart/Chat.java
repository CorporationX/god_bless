package faang.school.godbless.matters_of_the_heart;

import lombok.Data;

@Data
public class Chat {
    private User owner;
    private User secondUser;

    public Chat(User owner) {
        this.owner = owner;
    }
}