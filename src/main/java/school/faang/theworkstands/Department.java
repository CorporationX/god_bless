package school.faang.theworkstands;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Department implements Runnable {

    protected final MarketingResources marketingResources;
    protected final DesignResources designResources;
}
