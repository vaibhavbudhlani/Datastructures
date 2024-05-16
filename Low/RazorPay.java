import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RazorPay {
    public static void main(String[] args) {
        ParkingSpot parkingSpot1 = new ParkingSpot(1,VehicleType.CAR,true);
        ParkingSpot parkingSpot2 = new ParkingSpot(2,VehicleType.CAR,true);
        ParkingSpot parkingSpot3 = new ParkingSpot(3,VehicleType.MOTORBIKE,true);
        ParkingSpot parkingSpot4 = new ParkingSpot(4,VehicleType.TRUCK,true);

        ParkingLot parkingLot = new ParkingLot();
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(parkingSpot1);
        parkingSpotList.add(parkingSpot2);
        parkingSpotList.add(parkingSpot3);
        parkingSpotList.add(parkingSpot4);
        parkingLot.setParkingSpots(parkingSpotList);

        System.out.println(parkingLot.getParkingSpots());

        System.out.println(parkingLot.bookParkingSlot(VehicleType.CAR));
        System.out.println(parkingLot.getParkingSpots());

        System.out.println(parkingLot.bookParkingSlot(VehicleType.MOTORBIKE));
        System.out.println(parkingLot.getParkingSpots());
        System.out.println(parkingLot.bookParkingSlot(VehicleType.CAR));
        System.out.println(parkingLot.getParkingSpots());

        String vb = "Vaibhav";
        Optional<String> stringOptional = Optional.of(vb);
        //stringOptional.map(s -> s.to)


    }
}
