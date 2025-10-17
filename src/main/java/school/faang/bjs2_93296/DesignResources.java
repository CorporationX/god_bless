package school.faang.bjs2_93296;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DesignResources {
    private List<String> filesDesign = new ArrayList<>();

    public DesignResources() {
        filesDesign.add("one.pdf");
        filesDesign.add("two.pdf");
        filesDesign.add("three.pdf");
    }

    public void addFile(String file) {
        filesDesign.add(file);
    }

    public List<String> readFiles() {
        return filesDesign;
    }
}
