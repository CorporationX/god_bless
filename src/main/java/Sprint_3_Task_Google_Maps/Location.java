package Sprint_3_Task_Google_Maps;

import lombok.Data;

@Data
public class Location {
    private String name;
    private String latitude;
    private String longitude;

    public Location(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
