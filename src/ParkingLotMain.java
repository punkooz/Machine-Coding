import controller.ParkingLotController;

import java.util.Scanner;

public class ParkingLotMain {

    public static void main(String[] args){

        ParkingLotController parkingLotController = new ParkingLotController();

        parkingLotController.createParkingLot("create_parking_lot PR1234 2 6");

        Scanner obj = new Scanner(System.in);

        while(true){

            String command = obj.nextLine();

            if (command.equals("exit"))
                break;

            parkingLotController.operator(command);

        }



    }

}
