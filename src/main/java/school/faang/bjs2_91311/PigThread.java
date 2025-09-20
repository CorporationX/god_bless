package school.faang.bjs2_91311;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PigThread extends Thread {
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    private final int BUILDING_TIME = 7000;
    private String pigName;
    private String material;
}
