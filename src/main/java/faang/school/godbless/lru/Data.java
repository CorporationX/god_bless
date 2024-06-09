package faang.school.godbless.lru;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
public class Data {
    private int ID;
    private int value;
    @Setter
    private Long timestamp;

    public Data(int ID, int value) {
        this.ID = ID;
        this.value = value;
        Date date = new Date();
        timestamp = date.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return ID == data.ID && value == data.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, value);
    }

    @Override
    public String toString() {
        return "Data{" +
                "values=" + value +
                ", ID=" + ID +
                '}';
    }
}
