package faang.school.godbless.matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Chat {
    private User userOne;
    private User userTwo;

    public void userOneSendMessage(String message) {
        System.out.printf("%s: %s sent message to %s: %s", Thread.currentThread().getName(), userOne.getName(), userTwo.getName(), message);
    }

    public void userTwoSendMessage(String message) {
        System.out.printf("%s: %s sent message to %s: %s", Thread.currentThread().getName(), userTwo.getName(), userOne.getName(), message);
    }
}
