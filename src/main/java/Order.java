public class Order {
    private DeliveryMethod deliveryMethod;
    private double orderWeight; // Предположим, у заказа есть вес

    public Order(DeliveryMethod deliveryMethod, double orderWeight) {
        this.deliveryMethod = deliveryMethod;
        this.orderWeight = orderWeight;
    }

    public double calculateTotalCost() {
        return deliveryMethod.calculateCost(orderWeight); // Используем метод calculateCost() интерфейса DeliveryMethod
    }

    public String getDeliveryDescription() {
        return deliveryMethod.getDescription(); // Используем метод getDescription() интерфейса DeliveryMethod
    }

}