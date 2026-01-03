public class Car extends Vehicle implements Servicable{
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors) {
        if  (numberOfDoors < 0) {
            throw new IllegalArgumentException("numberOfDoors cannot be negative");
        }
        this.numberOfDoors = numberOfDoors;
    }
    @Override
    public double calculateInsuranceFee() {
        int age = getAge(java.time.Year.now().getValue());
        return numberOfDoors * getBasePrice() * age / 100;
    }
    @Override
    public void performService() {
        System.out.println("Service is running ");
        System.out.println("Servicing car " + getModel() + " " + getYear() +" with "+numberOfDoors+" doors"+": oil changed and diagnostics made, car ready to go");
    }
    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }
}
