package faang.school.godbless.core_split.lru;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

//record Data(int id, String value, Date date) {}

@AllArgsConstructor
@Setter
@Getter
public class Data {

    private int id;

    private String value;

    @Override
    public String toString() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        return "Data{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", timestamp=" + dt.format(timestamp) +
                '}';
    }

    private Date timestamp;

}