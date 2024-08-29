package faang.school.godbless.BJS2_25060;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageNotDeliveredException extends Exception {
    private Kingdom kingdom;
}
