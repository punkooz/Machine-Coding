package controller;

import repositories.ParkingLotRepository;
import services.ServicePickerService;

public class ParkingLotController {

    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

    public void createParkingLot(String command){

        String[] arr = command.split(" ");

        parkingLotRepository.saveLots(arr);
    }

    public void operator(String command){

        ServicePickerService servicePickerService = new ServicePickerService();

        servicePickerService.pickService(command, parkingLotRepository);

    }

}
