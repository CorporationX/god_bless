package faang.school.godbless.workIsStaying;

import lombok.Getter;

@Getter
public class DesignDepartment extends Thread {

    public DesignDepartment() {
    }

    @Override
    public void run() {
        System.out.println("начало работы отдела дизайна");
        DesignResources.init(null);
        DesignResources.write();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MarketingResources.read();
    }
}
