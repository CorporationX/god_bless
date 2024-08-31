package work.stop;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.ReadWriteLock;

@Getter
@AllArgsConstructor
public class CustomThread extends Thread {
    private final ReadWriteLock lock;
    private final DesignResources designResources;
    private final MarketingResources marketingResources;
}
