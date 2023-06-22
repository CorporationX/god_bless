package faang.school.godbless.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return notificationType == that.notificationType && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationType, message);
    }
}
