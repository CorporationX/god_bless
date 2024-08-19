package faang.school.godbless.BJS2_22852;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class JobScraper {

    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

    public Job convertToJob(String json) {
        return gson.fromJson(json, Job.class);
    }
}