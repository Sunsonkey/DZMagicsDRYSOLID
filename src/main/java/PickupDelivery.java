public class PickupDelivery implements DeliveryMethod {

    @Override
    public String getDescription() {
        return "Самовывоз из магазина";
    }

    @Override
    public double calculateCost(double orderWeight) {
        return 0.0; // Самовывоз бесплатный
    }
}