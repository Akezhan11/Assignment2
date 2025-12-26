import java.time.Year;
public abstract class Vehicle {
    private int id;
    private static int idGen;
    private String model;
    private int year;
    private double basePrice;

    public Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setYear(year);
        setBasePrice(basePrice);
        setModel(model);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        if(model == null || model.isEmpty()){
            throw new IllegalArgumentException("model cannot be empty");
        }
        this.model = model;
    }


    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if(year > currentYear ||  year < 1800){
            throw new IllegalArgumentException("year cannot be less than 1800");
        }
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        if (basePrice <= 0){
            throw new IllegalArgumentException("basePrice cannot be less than 0");
        }
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear){
        return currentYear - year;
    }
    public abstract double calculateInsuranceFee();
    @Override
    public String toString() {
        return "id:" + id +"\n" +"model:" + model +"\n"+ "year:" + year + "\n"+"basePrice:" + basePrice;
    }
}