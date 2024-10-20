package com.test.mvp.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        System.out.println("""
                +---------------------------------+
                |       Kennel program menu       |
                +---------------------------------+
                | 1. Add new animal               |
                | 2. Show all animal's commands   |
                | 3. Add new command to an animal |
                | 4. Show animals list            |
                | 5. Exit the program             |
                +---------------------------------+
                """);
    }

    public int getUserChoice() {
        System.out.println("Choose the command");
        while (!scanner.hasNextInt()) {
            System.out.println("Use only numbers 1-5!");
        }
        return scanner.nextInt();
    }

    public String getAnimalName() {
        System.out.println("Enter animal's name: ");
        return scanner.nextLine();
    }

    public LocalDate getAnimalBirthDate() {
        System.out.println("Enter animals birthdate (YYYY-MM-DD): ");
        while (true) {
            String birthDateString = scanner.next();
            try {
                return LocalDate.parse(birthDateString);
            } catch (DateTimeParseException e) {
                System.out.println("Wrong date format, try again!");
            }
        }
    }

    public String getAnimalType() {
        System.out.println("""
                +-------------------------------+
                | Choose the type of the animal |
                +-------------------------------+
                | 1. Dog                        |
                | 2. Cat                        |
                | 3. Hamster                    |
                | 4. Horse                      |
                | 5. Camel                      |
                | 6. Donkey                     |
                +-------------------------------+
                """);
        while (!scanner.hasNextInt()) {
            System.out.println("Enter the number 1-6");
            scanner.nextInt();
        }
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "dog";
            case 2:
                return "cat";
            case 3:
                return "hamster";
            case 4:
                return "horse";
            case 5:
                return "camel";
            case 6:
                return "donkey";
            default:
                System.out.println("Incorrect choice, try again!");
                return getAnimalType();
        }
    }

    public String getAnimalCommand() {
        System.out.println("Enter new command for an animal: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
