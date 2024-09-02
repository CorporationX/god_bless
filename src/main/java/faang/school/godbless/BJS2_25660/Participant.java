package faang.school.godbless.BJS2_25660;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Participant {
    private final String name;
    public void joinConference() {
        System.out.println(name + " присоединился к конференции");
    }
}
