package faang.school.godbless.BJS2_19021;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Application {
    @Getter
    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("God Bless!");
    }
}