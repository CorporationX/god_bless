package faang.school.godbless.MicrosoftJob;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, Integer> configValues;

    public Config() {
        configValues = new HashMap<>();
        configValues.put("totalEmails", 1000);
        configValues.put("threadsCount", 5);
    }

    public int get(String key) {
        return configValues.getOrDefault(key, 0);
    }
}