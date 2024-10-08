package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public interface Consumer {
    void accept(String param);
}
