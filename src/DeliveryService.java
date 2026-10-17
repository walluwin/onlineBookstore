public class DeliveryService {
    public void arrangeDelivery(String orderId, String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Delivery address is required.");
        }

        System.out.println("Delivery: shipment arranged for " + orderId
                + " to " + address + ".");
    }
}
