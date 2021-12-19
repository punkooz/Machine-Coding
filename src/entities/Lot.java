package entities;

import java.util.ArrayList;
import java.util.List;

public class Lot {

    List<Floor> floors;
    String id;

    public Lot(String id, int floor_count, int slot_count) {
        this.id = id;
        this.floors = new ArrayList<>(floor_count);

        for(int i = 0; i < floor_count; i++){
            floors.add(new Floor(slot_count));
        }

    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
