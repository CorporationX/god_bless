package faang.school.godbless.sprint5.multithreading_conc.task4_zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Participant {

    private String name;

    public void joinConference() {
        System.out.println(name + " присоединился к конференции!");
    }

}
