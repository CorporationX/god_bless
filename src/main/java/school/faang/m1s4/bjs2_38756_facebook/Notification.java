package school.faang.m1s4.bjs2_38756_facebook;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@ToString
public class Notification {
    private final int id;
    private final String message;
}
