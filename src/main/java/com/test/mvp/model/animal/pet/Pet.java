package com.test.mvp.model.animal.pet;

import com.test.mvp.model.animal.Animal;

import java.time.LocalDate;

public class Pet extends Animal {
    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public void play() {
        System.out.println(getName() + " is playing now.");
    }

    @Override
    public String toString() {
        return "Pet {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }
}
