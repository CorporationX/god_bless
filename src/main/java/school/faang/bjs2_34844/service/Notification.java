package school.faang.bjs2_34844.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    private TypeNotification type;
    private String message;

}
