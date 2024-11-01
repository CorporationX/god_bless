package stop_work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingResources extends ResourseManager {
    @Override
    public String getResourceType() {
        return "MarketingResources";
    }
}
