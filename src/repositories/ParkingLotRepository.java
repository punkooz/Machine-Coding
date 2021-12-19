package repositories;

import entities.Lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotRepository {

    HashMap<String, Lot> lots;

    public ParkingLotRepository() {
        this.lots = new HashMap<>();
    }

    public void saveLots(String[] arr){

        String id = arr[1];
        int floorCount = Integer.parseInt(arr[2]);
        int slotCount = Integer.parseInt(arr[3]);

        Lot lot = new Lot(id, floorCount, slotCount);

        lots.put(id, lot);

    }

    public void save(Lot lot){
        lots.put(lot.getId(), lot);
    }

    public HashMap<String, Lot> getLots() {
        return lots;
    }
}
