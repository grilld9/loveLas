package grillid9.laslib;

import java.util.List;

public class Curve {

    private final String name;
    private final String units;
    private final String description;
    private final List<Float> data;


    Curve(String name, String units, String description, List<Float> data) {
        this.name = name;
        this.units = units;
        this.description = description;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public List<Float> getData() {
        return data;
    }

    public String getUnits() {
        return units;
    }

    public String getDescription() {
        return description;
    }
}
