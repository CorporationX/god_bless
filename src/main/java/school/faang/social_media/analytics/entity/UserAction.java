package school.faang.social_media.analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserAction {
    private final int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
