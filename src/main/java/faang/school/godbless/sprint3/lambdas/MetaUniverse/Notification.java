package faang.school.godbless.sprint3.lambdas.MetaUniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Notification {
    private String type;
    private String message;

    public static boolean isNull(Notification notification){
        return notification == null;
    }
}
