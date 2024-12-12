package school.faang.bjs246755;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@ToString
public class Notification {
    private final String type;
    private final String message;
}