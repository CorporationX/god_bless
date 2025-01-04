package school.faang.task_51167;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
public class CollaborativeDocument {

    private Map<String, String> sections = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        if (sectionId != null & data != null) {
            boolean containsKey = sections.containsKey(sectionId);
            if (containsKey) {
                sections.computeIfPresent(sectionId, (key, oldValue) -> oldValue + " " + data);
            } else {
                sections.put(sectionId, data);
            }
        } else {
            log.error("Ошибка добавления в map: sectionId или data равны null");
        }

    }

    public String getData(String sectionId) {
        return sectionId != null ? sections.get(sectionId) : "Ключ не найден в списке";
    }

}
