package services;

import entities.*;
import repositories.ParkingLotRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkVehicle {

    public void park(String[] command, ParkingLotRepository parkingLotRepository) {
        String registrationNumber = command[2];
        String vehicleType = command[1];
        String color = command[3];

        HashMap<String, Lot> lots = parkingLotRepository.getLots();

        for (Map.Entry<String, Lot> entry : lots.entrySet()) {
            Lot lot = entry.getValue();


        List<Floor> floors = lot.getFloors();

        boolean parked = false;
        String ticketId = "";

        for (int i = 0; i < floors.size(); i++) {
            Floor f = floors.get(i);

            List<Slots> slots = f.getSlots();

            for (int j = 0; j < slots.size(); j++) {

                Slots s = slots.get(j);

                if (s.isAvailable()) {
                    if (vehicleType.equals("CAR") && s.getVehicle() instanceof Car) {
                        s.setVehicle(new Car(registrationNumber, color));
                        s.setAvailable(false);
                        parked = true;
                    } else if (vehicleType.equals("TRUCK") && s.getVehicle() instanceof Truck) {
                        s.setVehicle(new Truck(registrationNumber, color));
                        s.setAvailable(false);
                        parked = true;
                    } else if (vehicleType.equals("BIKE") && s.getVehicle() instanceof Bike) {
                        s.setVehicle(new Bike(registrationNumber, color));
                        s.setAvailable(false);
                        parked = true;
                    }
                }

                if (parked) {

                    slots.set(j, s);

                    f.setSlots(slots);

                    floors.set(i, f);

                    lot.setFloors(floors);

                    parkingLotRepository.save(lot);

                    System.out.println("Parked vehicle. Ticket ID: " + lot.getId() + "_" + (i + 1) + "_" + (j + 1));

                    break;
                }
            }

            if (parked)
                break;
        }

        if (!parked) {
            System.out.println("Parking Lot Full");
        }
    }

    }
}
