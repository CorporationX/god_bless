package school.faang.task_50971;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class SalesData {
    private final UUID storeId;
    private final List<Sale> sales;
}
