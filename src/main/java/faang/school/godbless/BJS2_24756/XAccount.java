package faang.school.godbless.BJS2_24756;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class XAccount {
    private final String name;
    private int followers;

    public synchronized void increment() {
        followers++;
    }
}
