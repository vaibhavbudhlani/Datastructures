public class ParkingSpot {


    public ParkingSpot(){

    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private VehicleType vehicleType;

    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public ParkingSpot(int id, VehicleType vehicleType, boolean available) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.available = available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", available=" + available +
                '}';
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
