public class Bus extends Vehicle implements Servicable {
    private int passengerCapacity;
    public Bus(String model,int year, int basePrice, int passengerCapacity) {
        super(model,year,basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger Capacity must be greater than zero.");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(java.time.Year.now().getValue());
        return passengerCapacity * getBasePrice() * age / 200;
    }

    @Override
    public void performService (){
        System.out.println("Servicing Bus " + getModel() + ": for passenger capacity " + getPassengerCapacity() + " full technical inspection and diagnostics made.");
    }
    @Override
    public int getServiceIntervalKm() {
        return 20000;
    }
}
