package bjs2_62812;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    // key -  это идентификатор раздела документа, value - данные раздела
    private final ConcurrentHashMap<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        sections.put(sectionId, data);
    }

    public String getData(String sectionId) throws SectionNotFoundException {
        var data = sections.get(sectionId);

        if (data == null) {
            throw new SectionNotFoundException(String.format("Секция %s не найдена в документе", sectionId));
        }

        return data;
    }
}
