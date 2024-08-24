package faang.school.godbless.StreamAPI2;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class Config {
    private int start;
    private int end;

    public Config() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
            this.start = Integer.parseInt(properties.getProperty("start"));
            this.end = Integer.parseInt(properties.getProperty("end"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}