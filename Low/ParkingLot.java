import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int RemoveFromParking(int id){
        // try catch

        this.parkingSpots.stream().filter(parkingSpot -> parkingSpot.getId()== id).forEach(x-> x.setAvailable(true));
        return id;
    }

    private List<ParkingSpot> parkingSpots;
    private int carCapacity;
    private int bikeCapacity;
    private int TruckCapacity;

    public int bookParkingSlot(VehicleType vehicleType){
        ParkingSpot parkingSpotAv = this.parkingSpots.stream().
                filter(parkingSpot -> parkingSpot.getVehicleType().equals(vehicleType) && parkingSpot.isAvailable())
                .findFirst().get();
        this.parkingSpots.stream().filter(parkingSpot -> parkingSpot.getId()==parkingSpotAv.getId()).
                forEach(parkingSpot -> parkingSpot.setAvailable(false));
        return parkingSpotAv.getId();

    }

    public List<ParkingSpot> getAllParkingSpots(){
        return this.parkingSpots;
    }

    public int getVehicleCapacity(VehicleType vehicleType){
        return this.parkingSpots.stream().
                filter(x -> x.getVehicleType().equals(vehicleType) && x.isAvailable()).toList().size();
    }

    public List<ParkingSpot> getParkingSpotsBasedOnVehicleType(VehicleType vehicleType){
        return this.parkingSpots.stream().
                filter(x -> x.getVehicleType().equals(vehicleType) && x.isAvailable()).toList();
    }


    public int getCarCapacity(){
        return this.parkingSpots.stream().
                filter(x -> x.getVehicleType().equals(VehicleType.CAR) && x.isAvailable()).toList().size();
    }

    public int getBikeCapacity(){
        return this.parkingSpots.stream().
                filter(x -> x.getVehicleType().equals(VehicleType.MOTORBIKE) && x.isAvailable()).toList().size();
    }

    public int getTruckCapacity(){
        return this.parkingSpots.stream().
                filter(x -> x.getVehicleType().equals(VehicleType.TRUCK) && x.isAvailable()).toList().size();
    }

}
