package school.BJS2_39382;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {

    private ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }
    public String getData(String sectionId) {
        if(!sections.containsKey(sectionId)) {
            return "Данный ключ не найден";
        }
        return sections.get(sectionId);
    }

    public String getDataInfo(String sectionId) {
        return sections.get(sectionId);
    }

    public ConcurrentHashMap<String, String> getSections() {
        return sections;
    }
}
