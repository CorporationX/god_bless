package school.faang.bjs251335.without_deadlock;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        DesignResources designResources = new DesignResources();
        Stream.of("Design", "Site design")
                .forEach(designResources::addFile);

        MarketingResources marketingResources = new MarketingResources();
        Stream.of("Small markt", "Marketing")
                .forEach(designResources::addFile);

        DesignDepartment designDepartment = new DesignDepartment(designResources, marketingResources);
        MarketingDepartment marketingDepartment = new MarketingDepartment(marketingResources, designResources);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(designDepartment);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(marketingDepartment);

        CompletableFuture.allOf(future1, future2).join();
    }
}
