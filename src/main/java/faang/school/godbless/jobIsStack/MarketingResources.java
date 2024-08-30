package faang.school.godbless.jobIsStack;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MarketingResources {
    private final List<String> marketingFiles;

    public MarketingResources() {
        this.marketingFiles = new ArrayList<>();
    }

    public void readAllFiles() {
        System.out.println("Marketing files:");
        System.out.println(marketingFiles);
    }

    public void addNewFile(String file) {
        marketingFiles.add(file);
    }
}
