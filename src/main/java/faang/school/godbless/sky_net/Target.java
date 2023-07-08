package faang.school.godbless.sky_net;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Target {
    private String name;
    private boolean isAlive = true;

    public Target(String name) {
        this.name = name;
    }
}
