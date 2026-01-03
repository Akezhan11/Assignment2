import java.util.ArrayList;
import java.time.Year;
import java.util.Scanner;

public class FleetApp {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to FleetApp");
            System.out.println("Fleet Management System");
            System.out.println("1. Print Vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fee");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");

            int choice = input.nextInt();

            input.nextLine();


            switch (choice) {
                case 1 -> printVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> InsuranceFee();
                case 5 -> VehicleOlder();
                case 6 -> PerformService();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }
    private void printVehicles () {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
        } else {
            for  (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }
    private void addCar() {
        System.out.println("Please enter the model of the car");
        String model = input.nextLine();

        System .out.println("Please enter the year of the car");
        int year = input.nextInt();

        System .out.println("Please enter the price of the car");
        double basePrice = input.nextDouble();

        System.out.println("Please enter the number of doors");
        int numberOfDoors = input.nextInt();
        vehicles.add(new Car(model,year,basePrice, numberOfDoors));
    }


    private void addBus() {
        System.out.println("Please enter the model of the Bus");
        String model = input.nextLine();

        System .out.println("Please enter the year of the Bus");
        int year = input.nextInt();

        System .out.println("Please enter the price of the Bus");
        double basePrice = input.nextDouble();

        System.out.println("Please enter the number of max passengers");
        int passengerCapacity = input.nextInt();
        vehicles.add(new Bus(model,year, basePrice, passengerCapacity));
    }


    private void InsuranceFee() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance fee: " + total);
    }
    private void VehicleOlder() {
        int currentYear = Year.now().getValue();
        System.out.print("N: ");
        int n = input.nextInt();
        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void PerformService() {
        for (Vehicle v : vehicles) {
            if(v instanceof Servicable s) {
                s.performService();
                System.out.println("You can arrive after " + s.getServiceIntervalKm());
            }
        }
    }

    void main(){
        new FleetApp().run();
    }
}