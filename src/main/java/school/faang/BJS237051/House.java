package school.faang.BJS237051;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class House {
    private List<String> availableRoles;
    private int availableRoleCount;
}