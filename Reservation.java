public class Reservation {

    private String customerName;
    private Room room;
    private int numberOfDays;
    private double totalAmount;

    public Reservation(String customerName,
                       Room room,
                       int numberOfDays) {

        this.customerName = customerName;
        this.room = room;
        this.numberOfDays = numberOfDays;

        this.totalAmount =
                room.getPricePerNight() * numberOfDays;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {

        return customerName + "," +
                room.getRoomNumber() + "," +
                numberOfDays + "," +
                totalAmount;
    }
}