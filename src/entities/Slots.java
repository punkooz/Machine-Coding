package entities;

public class Slots {

    Vehicle vehicle;
    boolean available;

    public Slots(String vehicleName) {

        switch (vehicleName) {
            case "CAR":
                this.vehicle = new Car();
                break;
            case "BIKE":
                this.vehicle = new Bike();
                break;
            case "TRUCK":
                this.vehicle = new Truck();
                break;
        }

        this.available = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
