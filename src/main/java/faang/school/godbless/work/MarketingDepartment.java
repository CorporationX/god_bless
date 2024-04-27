package faang.school.godbless.work;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@Getter
public class MarketingDepartment extends Thread{

    private MarketingResources marketingResources;
    private DesignResources designResources;
    private boolean isDeadlock;

    public MarketingDepartment(MarketingResources marketingResources, boolean isDeadlock) {
        this.marketingResources = marketingResources;
        this.isDeadlock = isDeadlock;
    }

    @Override
    @SneakyThrows
    public void  run(){
        if(isDeadlock) {
            synchronized (marketingResources) {
                System.out.println("Use marketing resources by MarketingDepartment");
                TimeUnit.SECONDS.sleep(5);
                synchronized (designResources) {
                    System.out.println("Use design resources by MarketingDepartment");
                }
            }
        }else{
            System.out.println("Use marketing resources by MarketingDepartment");
            marketingResources.getFolder();
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            designResources.writeNameOfDocument("Marketing resource");
            System.out.println("Use design resources by MarketingDepartment");
        }
    }

    public void callDesignDeportment(DesignDepartment designDepartment){
        this.designResources = designDepartment.getDesignResources();
    }
}
