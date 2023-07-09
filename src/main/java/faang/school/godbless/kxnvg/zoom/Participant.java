package faang.school.godbless.kxnvg.zoom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Participant {

    private String name;

    @SneakyThrows
    public void joinConference() {
        Thread.sleep(1000);
        System.out.println(name + " подключился к онлайн-конференции");
    }
}
