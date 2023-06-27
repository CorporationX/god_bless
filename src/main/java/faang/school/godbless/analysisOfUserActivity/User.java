package faang.school.godbless.analysisOfUserActivity;

import lombok.Value;

import java.time.LocalDateTime;


@Value
public class User {
    private int id;
    private String name;
    private actionType actionType; // тип активности
    private LocalDateTime actionDate; // время деятельности
    private String content; // какой контент потребляет
}
