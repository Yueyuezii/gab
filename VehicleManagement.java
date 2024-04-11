import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class VehicleManagement {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // add vehicle here
                    System.out.println("Enter vehicle details:");
                    System.out.print("Enter registration number: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter year of manufacture: ");
                    int yearOfManufacture = scanner.nextInt();
                    System.out.print("Enter value: ");
                    double value = scanner.nextDouble();
                    Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
                    vehicleList.add(vehicle);
                    System.out.println("Vehicle added successfully!");
                    break;
                case 2:
                    // display vehicle list here
                    for (Vehicle v : vehicleList) {
                        System.out.println("Registration Number: " + v.getRegNo());
                        System.out.println("Make: " + v.getMake());
                        System.out.println("Year of Manufacture: " + v.getYearOfManufacture());
                        System.out.println("Value: " + v.getValue());
                        System.out.println("Age: " + v.calculateAge(2024)); // Assuming the current year is 2024
                        System.out.println();
                    }
                    break;
                case 3:
                    // delete vehicle
                    System.out.println("Enter index of vehicle to delete:");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < vehicleList.size()) {
                        vehicleList.remove(index);
                        System.out.println("Vehicle deleted successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                   int choice2; // sort vehicle list by age
                  do{
                   System.out.println("Sort Menu:");
                   System.out.println("1. Sort by age (ascending)");
                   System.out.println("2. Sort by age (descending)");
                   System.out.println("3. Back to Main Menu");
                   choice2 = scanner.nextInt();
                  switch (choice2){
                  case 1:
                  System.out.println("List of vehicle details sorted by age (ascending):");
                     Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture));
                     for(int i = 0; i < vehicleList.size(); i++){
                        System.out.println(vehicleList.get(i));
                   }
                  break;
                     
                  case 2:
                  System.out.println("List of vehicle details sorted by age (descending):");
                     Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture).reversed());
                     for(int i = 0; i < vehicleList.size(); i++){
                        System.out.println(vehicleList.get(i));
                        }
                  break;
                  
                  case 3:
                  System.out.println("Returning to main menu...");
                  break;
                  default:
                               System.out.println("Invalid choice. Please try again.");
                          
                      }} while (choice2 != 3);
                  
                   
                   
                 break;
              case 5:
                    System.out.println("Exiting program...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }}
         while (choice != 5);

        scanner.close();
    }
}