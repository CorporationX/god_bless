package faang.school.godbless.CacheCache2006;

public class OpenWeather {

    private OpenWeather() {
    }

    public static void cacheWeatherFromOpenSource(String url, String city) {
        // fake
        String parse_json_from_url_get_info_put_it_into_cachemap_city_is_key_method;

        Main.weatherDataCache.put(city, new WeatherData(city, 20.0, 60.0));
    }
}
