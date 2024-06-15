package faang.school.godbless.BJS2_8093;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        if (name.isBlank()){
            System.out.println("Некорректное имя дома");
            return;
        }
        if (sigil.isBlank()){
            System.out.println("Некорректное название герба");
            return;
        }
        this.name = name;
        this.sigil = sigil;
    }
}
