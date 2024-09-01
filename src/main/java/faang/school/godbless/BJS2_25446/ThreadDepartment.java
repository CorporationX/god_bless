package faang.school.godbless.BJS2_25446;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class ThreadDepartment extends Thread {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;
}
