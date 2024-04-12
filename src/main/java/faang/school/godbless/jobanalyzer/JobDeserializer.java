package faang.school.godbless.jobanalyzer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JobDeserializer implements JsonDeserializer<Job> {
    @Override
    public Job deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Job job = new Job();
        job.setName(jsonObject.get("name").getAsString());
        job.setLocation(jsonObject.get("location").getAsString());
        job.setSalary(jsonObject.get("salary").getAsInt());
        job.setName(jsonObject.get("jobAdditions").getAsString());

        JsonArray requirementsForCandidates = jsonObject.getAsJsonArray("requirementsForCandidates");
        List<String> requipments = new ArrayList<>();
        for (JsonElement weapon : requirementsForCandidates) {
            requipments.add(weapon.getAsString());
        }
        job.setRequirementsForCandidates(requipments);

        return job;
    }
}
