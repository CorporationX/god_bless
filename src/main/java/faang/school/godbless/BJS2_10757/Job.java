package faang.school.godbless.BJS2_10757;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Job {
    @SerializedName("position")
    @Expose
    String positionName;
    @SerializedName("skills")
    @Expose
    List<String> skills;
    @SerializedName("salary")
    @Expose
    int salary;
    @SerializedName("location")
    @Expose
    String location;
    @SerializedName("creation")
    @Expose
    String creationDateTime;
}
