package analysisActivities;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UserAction {

    private final int id;
    private final String name;
    private final String type;
    private final LocalDate actionDate;
    private final String content;
}
