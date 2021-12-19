package entities;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    List<Slots> slots;
    int slot_count;

    public Floor(int slot_count) {
        this.slots = new ArrayList<>(slot_count);
        this.slot_count = slot_count;

        for (int i = 0; i < slot_count; i++){
            if(i == 0){
                slots.add(new Slots("TRUCK"));
            }else if(i == 1 || i == 2){
                slots.add(new Slots("BIKE"));
            }else{
                slots.add(new Slots("CAR"));
            }
        }

    }

    public List<Slots> getSlots() {
        return slots;
    }

    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }
}
