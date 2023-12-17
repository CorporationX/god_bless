package faang.school.godbless.BJS2_576;

import lombok.Getter;

@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    public WeatherData(String city, double temperature, double humidity) {
        this.city=city;
        this.temperature=temperature;
        this.humidity=humidity;
    }
    public String toString(){
        return getCity()+" ("+getTemperature()+", "+getHumidity()+")";
    }
}
