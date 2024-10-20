package com.test.mvp.model.animal;

import com.test.mvp.model.animal.packanimal.Camel;
import com.test.mvp.model.animal.packanimal.Donkey;
import com.test.mvp.model.animal.packanimal.Horse;
import com.test.mvp.model.animal.pet.Cat;
import com.test.mvp.model.animal.pet.Dog;
import com.test.mvp.model.animal.pet.Hamster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private String name;
    private LocalDate birthDate;
    private List<String> commands;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void learnCommand(String command) {
        commands.add(command);
        System.out.println(name + " has learned new command: " + command);
    }

    public void performCommands() {
        if (commands.isEmpty()) {
            System.out.println(name + " doesn't know any commands yet.");
        } else {
            System.out.println(name + " performs the following commands: ");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        }
    }

    public void voice() {
    }

    public static Animal createAnimal() {
        Animal animal = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter animal's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter animal's birthDate (YYYY-MM-DD): ");
        String birthDateString = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateString);

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

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                animal = new Dog(name, birthDate);
                break;
            case 2:
                animal = new Cat(name, birthDate);
                break;
            case 3:
                animal = new Hamster(name, birthDate);
                break;
            case 4:
                animal = new Horse(name, birthDate);
                break;
            case 5:
                animal = new Camel(name, birthDate);
                break;
            case 6:
                animal = new Donkey(name, birthDate);
                break;
            default:
                System.out.println("Incorrect choice!");
                break;
        }

        if (animal != null) {
            System.out.println("Animal successfully created " + animal);
        }

        return animal;
    }

    @Override
    public String toString() {
        return "Animal {Name = '" + name + "' Age = " + getAge() + " (birthDate = " + birthDate + ") , commands = " + commands + "}";
    }
}
