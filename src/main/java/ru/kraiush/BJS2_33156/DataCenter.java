package ru.kraiush.BJS2_33156;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}
