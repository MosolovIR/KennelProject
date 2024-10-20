package com.test.mvp.presenter;

import com.test.mvp.model.animal.Animal;
import com.test.mvp.model.animal.AnimalRegistry;
import com.test.mvp.model.animal.packanimal.Camel;
import com.test.mvp.model.animal.packanimal.Donkey;
import com.test.mvp.model.animal.packanimal.Horse;
import com.test.mvp.model.animal.pet.Cat;
import com.test.mvp.model.animal.pet.Dog;
import com.test.mvp.model.animal.pet.Hamster;
import com.test.mvp.view.ConsoleUI;

import java.sql.Date;
import java.time.LocalDate;

public class Presenter {
    private final AnimalRegistry model;
    private final ConsoleUI view;

    public Presenter(AnimalRegistry model, ConsoleUI view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getUserChoice();
            handleUserChoice(choice);
        }
    }

    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addNewAnimal();
                break;
            case 2:
                showAnimalCommands();
                break;
            case 3:
                teachAnimalNewCommand();
                break;
            case 4:
                showAllAnimals();
                break;
            case 5:
                view.showMessage("Closing the program");
                System.exit(0);
                break;
            default:
                view.showMessage("Unknown command, try again");
        }
    }

    private void addNewAnimal() {
        String name = view.getAnimalName();
        LocalDate birthDate = view.getAnimalBirthDate();
        String animalType = view.getAnimalType();

        model.addAnimal(name, Date.valueOf(birthDate), animalType);
        view.showMessage("Animal successfully added: " + name);

    }

    private Animal createAnimal(String name, LocalDate birthDate, String animalType) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return new Dog(name, birthDate);
            case "cat":
                return new Cat(name, birthDate);
            case "hamster":
                return new Hamster(name, birthDate);
            case "horse":
                return new Horse(name, birthDate);
            case "camel":
                return new Camel(name, birthDate);
            case "donkey":
                return new Donkey(name, birthDate);
            default:
                view.showMessage("Unknown type of animal");
        }
        return null;
    }

    private void showAnimalCommands() {
        String name = view.getAnimalName();
        model.showAnimalCommands(name);
    }

    private void teachAnimalNewCommand() {
        String name = view.getAnimalName();
        String command = view.getAnimalCommand();
        model.teachAnimalCommand(name, command);
    }

    private void showAllAnimals() {
        model.showAllAnimals();
    }
}
