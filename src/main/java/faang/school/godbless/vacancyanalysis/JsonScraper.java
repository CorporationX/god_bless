package faang.school.godbless.vacancyanalysis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class JsonScraper extends JobScraper {

    private final Gson gson;

    public JsonScraper() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        this.gson = gsonBuilder.create();
    }

    public Job parse(String jsonJob) {
        return gson.fromJson(jsonJob, Job.class);
    }
}
