package school.faang.sprint_1.task_44831.entity;

import org.apache.commons.lang3.StringUtils;

public record WeatherData(String city, double temperature, double humidity, long timestamp) {
    public WeatherData {
        if (StringUtils.isBlank(city)) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
    }
}
