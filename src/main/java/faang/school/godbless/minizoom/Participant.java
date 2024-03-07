package faang.school.godbless.minizoom;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Participant {

    private String name;

    public void joinConference() {
        System.out.println(String.format("%s joined the conference", name));
    }
}
