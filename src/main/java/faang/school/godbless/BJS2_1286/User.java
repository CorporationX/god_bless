package faang.school.godbless.BJS2_1286;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private boolean isOnline;

    @Override
    public String toString() {
        return "user " + this.getName();
    }
}