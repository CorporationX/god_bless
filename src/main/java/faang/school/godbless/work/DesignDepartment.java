package faang.school.godbless.work;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@Getter
public class DesignDepartment extends Thread {

    private DesignResources designResources;
    private MarketingResources marketingResources;
    private boolean isDeadlock;

    public DesignDepartment(DesignResources designResources, boolean isDeadlock) {
        this.designResources = designResources;
        this.isDeadlock = isDeadlock;
    }

    @Override
    @SneakyThrows
    public void run() {
        if (isDeadlock) {
            synchronized (designResources) {
                System.out.println("Use design resources by DesignDepartment");
                TimeUnit.SECONDS.sleep(5);
                synchronized (marketingResources) {
                    System.out.println("Use marketing resources by DesignDepartment");
                }
            }
        }else{
            System.out.println("Use design resources by DesignDepartment");
            designResources.getFolder();
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            marketingResources.writeNameOfDocument("Design resource");
            System.out.println("Use marketing resources by DesignDepartment");
        }
    }

    public void callMarketingDeportment(MarketingDepartment marketingDepartment) {
        this.marketingResources = marketingDepartment.getMarketingResources();
    }
}
