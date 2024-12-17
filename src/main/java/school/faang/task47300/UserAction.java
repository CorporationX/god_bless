package school.faang.task47300;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class UserAction {
    final int id;
    final String name;
    final String action;
    final LocalDate actionDate;
    final String content;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String name() {
        return action;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public String getContent() {
        return content;
    }

}

