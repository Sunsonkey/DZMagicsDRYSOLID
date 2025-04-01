public class CourierDelivery implements DeliveryMethod {
    //Использование магических чисел
    private final double baseCost = 15.0; // Базовая стоимость курьерской доставки
    private final double costPerKg = 2.0; // Стоимость за кг веса заказа

    @Override
    public String getDescription() {
        return "Доставка курьером";
    }

    @Override
    public double calculateCost(double orderWeight) {
        return baseCost + (orderWeight * costPerKg);
    }
}