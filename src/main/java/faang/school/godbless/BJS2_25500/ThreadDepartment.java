package faang.school.godbless.BJS2_25500;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ThreadDepartment extends Thread {
    private DesignResources designResources;
    private MarketingResources marketingResources;
}
