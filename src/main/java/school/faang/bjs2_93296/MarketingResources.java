package school.faang.bjs2_93296;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MarketingResources {
    private List<String> filesMarketing = new ArrayList<>();

    public MarketingResources() {
        filesMarketing.add("four.pdf");
        filesMarketing.add("five.pdf");
        filesMarketing.add("six.pdf");
    }

    public void addFile(String file) {
        filesMarketing.add(file);
    }

    public List<String> readFiles() {
        return filesMarketing;
    }
}
