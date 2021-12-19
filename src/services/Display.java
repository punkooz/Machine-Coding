package services;

import entities.*;
import repositories.ParkingLotRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Display {

    public void freeCount(String[] command, ParkingLotRepository parkingLotRepository){

        HashMap<String, Lot> lots = parkingLotRepository.getLots();

        for (Map.Entry<String, Lot> entry : lots.entrySet()) {
            Lot lot = entry.getValue();

            List<Floor> floors = lot.getFloors();

            String vehicleType = command[2];


            for (int i = 0; i < floors.size(); i++) {
                Floor f = floors.get(i);

                List<Slots> slots = f.getSlots();

                int count = 0;

                for (Slots s : slots) {
                    if (s.isAvailable()) {
                        if (vehicleType.equals("CAR") && s.getVehicle() instanceof Car) {
                            count++;
                        } else if (vehicleType.equals("TRUCK") && s.getVehicle() instanceof Truck) {
                            count++;
                        } else if (vehicleType.equals("BIKE") && s.getVehicle() instanceof Bike) {
                            count++;
                        }
                    }
                }

                System.out.println("No. of free slots for " + vehicleType + " on Floor" + (i + 1) + ": " + count);

            }
        }
    }

    public void freeSlots(String[] command, ParkingLotRepository parkingLotRepository){

        HashMap<String, Lot> lots = parkingLotRepository.getLots();

        for (Map.Entry<String, Lot> entry : lots.entrySet()) {
            Lot lot = entry.getValue();

            List<Floor> floors = lot.getFloors();

            String vehicleType = command[2];


            for (int i = 0; i < floors.size(); i++) {
                Floor f = floors.get(i);

                List<Slots> slots = f.getSlots();

                List<Integer> slotslist = new ArrayList<>();

                for (int j = 0; j < slots.size(); j++) {
                    Slots s = slots.get(j);

                    if (s.isAvailable()) {
                        if (vehicleType.equals("CAR") && s.getVehicle() instanceof Car) {
                            slotslist.add(j + 1);
                        } else if (vehicleType.equals("TRUCK") && s.getVehicle() instanceof Truck) {
                            slotslist.add(j + 1);
                        } else if (vehicleType.equals("BIKE") && s.getVehicle() instanceof Bike) {
                            slotslist.add(j + 1);
                        }
                    }
                }

                System.out.println();
                System.out.print("Free slots for " + vehicleType + " on Floor" + (i + 1) + ": ");

                if (slotslist.size() == 1)
                    System.out.print(slotslist.get(0));
                else
                    for (int k = 0; k < slotslist.size(); k++) {
                        int num = slotslist.get(k);
                        if(k == slotslist.size() - 1)
                            System.out.print(num);
                        else
                            System.out.print(num + ",");
                    }
                System.out.println();
            }
        }
    }

    public void occupiedSlots(String[] command, ParkingLotRepository parkingLotRepository) {

        HashMap<String, Lot> lots = parkingLotRepository.getLots();

        for (Map.Entry<String, Lot> entry : lots.entrySet()) {
            Lot lot = entry.getValue();

        List<Floor> floors = lot.getFloors();

        String vehicleType = command[2];


        for (int i = 0; i < floors.size(); i++) {
            Floor f = floors.get(i);

            List<Slots> slots = f.getSlots();

            List<Integer> slotslist = new ArrayList<>();

            for (int j = 0; j < slots.size(); j++) {
                Slots s = slots.get(j);

                if (!s.isAvailable()) {
                    if (vehicleType.equals("CAR") && s.getVehicle() instanceof Car) {
                        slotslist.add(j + 1);
                    } else if (vehicleType.equals("TRUCK") && s.getVehicle() instanceof Truck) {
                        slotslist.add(j + 1);
                    } else if (vehicleType.equals("BIKE") && s.getVehicle() instanceof Bike) {
                        slotslist.add(j + 1);
                    }
                     }
            }
            System.out.println();
            System.out.print("Occupied slots for " + vehicleType + " on Floor" + (i + 1) + ": ");
            for (Integer num : slotslist) {
                System.out.print(num + ",");
            }
        }

        }
    }

}
