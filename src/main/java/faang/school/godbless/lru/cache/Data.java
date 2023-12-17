package faang.school.godbless.lru.cache;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Getter
@Setter
public class Data {
    private int id;
    private String value;
    private Timestamp timestamp;

    public Data(int id,String value) {
        this.id = id;
        this.value = value;
    }
}