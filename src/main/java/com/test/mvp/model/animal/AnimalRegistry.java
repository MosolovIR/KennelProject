package com.test.mvp.model.animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAllAnimals() {
        return animals;
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
