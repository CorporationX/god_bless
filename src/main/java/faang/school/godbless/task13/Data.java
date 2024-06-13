package faang.school.godbless.task13;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@lombok.Data
@AllArgsConstructor
public class Data {
    private int id;
    private String value;
    private LocalDate timestamp;

    public Data(int id, String value) {
        System.out.println();
        this.id = id;
        this.value = value;
        this.timestamp = LocalDate.now();
    }
}
