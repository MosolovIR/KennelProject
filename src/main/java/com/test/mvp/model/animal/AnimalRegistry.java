package com.test.mvp.model.animal;

import com.test.db.AnimalDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class AnimalRegistry {
    private AnimalDAO animalDAO;
    private List<Animal> animals;

    public AnimalRegistry() {
        this.animalDAO = new AnimalDAO();
    }

    public void addAnimal(String name, Date birthDate, String animalType) {
        try {
            animalDAO.addAnimal(name, birthDate, animalType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> getAllAnimals() {
        try {
            return animalDAO.getAllAnimals();
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    public Animal findAnimalByName (String name) {
        for (Animal animal: animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public void teachAnimalCommand (String name, String command) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animal.learnCommand(command);
        } else {
            System.out.println("Animal with name '" + name + "' not found.");
        }
    }

    public void showAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("There is no animals in list");
        } else {
            System.out.println("Animals list: ");
            for (Animal animal: animals){
                System.out.println(animal);
            }
        }
    }

    public void showAnimalCommands(String name){
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animal.performCommands();
        } else {
            System.out.println("Animal with name '" + name + "' not found.");
        }
    }
}
