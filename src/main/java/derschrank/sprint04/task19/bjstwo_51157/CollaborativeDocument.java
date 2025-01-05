package derschrank.sprint04.task19.bjstwo_51157;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CollaborativeDocument implements  Document {
    Map<String, String> sections;

    public CollaborativeDocument() {
        sections = new ConcurrentHashMap<>();
    }

    @Override
    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    @Override
    public String getData(String sectionId) {
        return sections.get(sectionId);
    }

    @Override
    public int getSize() {
        return sections.size();
    }

    @Override
    public String toString() {
        StringBuilder resulate = new StringBuilder("DOCUMENT:");
        for (String sectionId : sections.keySet()) {
            resulate.append(String.format("[%s] %s%n", sectionId, sections.get(sectionId)));
        }
        return resulate.toString();
    }
}
