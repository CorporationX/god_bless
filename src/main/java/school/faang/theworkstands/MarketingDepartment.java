package school.faang.theworkstands;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MarketingDepartment extends Department {

    public MarketingDepartment(MarketingResources marketingResources, DesignResources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        log.info("Маркетологи читают ресурсы дизайнеров");
        List<String> designerFiles = designResources.getFileNames();
        synchronized (marketingResources) {
            log.info("Маркетологи добавляют файл в свои ресурсы");
            designResources.addFile("Marketing Analysis");
        }
    }
}
