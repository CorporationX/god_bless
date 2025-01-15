package school.faang.task_51234;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.merge(sectionId, data, (oldData, newData) -> oldData + newData);
        System.out.println("Data added to section " + sectionId + ": " + data);
    }

    public String getData(String sectionId) {
        return sections.getOrDefault(sectionId, "");
    }
}
