package services;

import entities.*;
import repositories.ParkingLotRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unpark {

    public void unparkVehicle(String[] command, ParkingLotRepository parkingLotRepository){

        String ticketId = command[1];

        String[] arr = ticketId.split("_");

        int floorNum = Integer.parseInt(arr[1]);
        int slotNum = Integer.parseInt(arr[2]);

        HashMap<String, Lot> lots = parkingLotRepository.getLots();

        for (Map.Entry<String, Lot> entry : lots.entrySet()) {
            Lot lot = entry.getValue();

            List<Floor> floors = lot.getFloors();

            if (floorNum > floors.size()){
                System.out.println("Invalid Ticket");
                return;
            }

            Floor f = floors.get(floorNum - 1);

            List<Slots> slots = f.getSlots();

            if (slotNum > slots.size()){
                System.out.println("Invalid Ticket");
                return;
            }

            Slots slot = slots.get(slotNum - 1);

            if (slot.isAvailable()){
                System.out.println("Invalid Ticket");
                return;
            }

            String vehicleName = "";

            if (slot.getVehicle() instanceof Car){
                vehicleName = "CAR";
            }else if (slot.getVehicle() instanceof Truck){
                vehicleName = "TRUCK";
            }else if (slot.getVehicle() instanceof Bike){
                vehicleName = "BIKE";
            }

            System.out.println("Unparked vehicle with Registration Number: " + slot.getVehicle().getRegistrationNumber() +  "and Color: " + slot.getVehicle().getColor());

            slot = new Slots(vehicleName);

            slots.set(slotNum - 1, slot);

            f.setSlots(slots);

            floors.set(floorNum - 1, f);

            lot.setFloors(floors);

            parkingLotRepository.save(lot);

        }
    }

}
