package services;

import repositories.ParkingLotRepository;

public class ServicePickerService {

    public void pickService(String command, ParkingLotRepository parkingLotRepository){

        String[] arr = command.split(" ");

        switch (arr[0]) {
            case "display":

                Display display = new Display();

                switch (arr[1]) {
                    case "free_count":
                        display.freeCount(arr, parkingLotRepository);
                        break;
                    case "free_slots":
                        display.freeSlots(arr, parkingLotRepository);
                        break;
                    case "occupied_slots":
                        display.occupiedSlots(arr, parkingLotRepository);
                        break;
                }

                break;
            case "park_vehicle":
                ParkVehicle parkVehicle = new ParkVehicle();
                parkVehicle.park(arr, parkingLotRepository);
                break;
            case "unpark_vehicle":
                Unpark unpark = new Unpark();
                unpark.unparkVehicle(arr, parkingLotRepository);
                break;
        }

    }

}
