package faang.school.godbless.VacancyAnalyzer;

import com.google.gson.Gson;

public class JobScraper {
    public static Job jsonToJob(String jsonString) {
        return new Gson().fromJson(jsonString, Job.class);
    }
}
