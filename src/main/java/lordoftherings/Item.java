package lordoftherings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Item {

    @NonNull
    private String name;
    private int value;
}
