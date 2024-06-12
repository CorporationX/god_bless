package faang.school.godbless.BJS210339;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
public class Notification implements Cloneable {

    private String type;
    private String message;

    @Override
    @SneakyThrows
    protected Notification clone() {
        return (Notification) super.clone();
    }
}
