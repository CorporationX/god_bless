package faang.school.godbless.Matters_of_the_heart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat {
    private User initiator;
    private User participant;

    public void start() {
        System.out.println("Начинается чат между " + initiator.getName() + " и " + participant.getName());
    }

    public void end() {
        System.out.println("Чат между " + initiator.getName() + " и " + participant.getName() + " закончен.");
    }
}
