package com.test.mvp.model.animal.pet;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Dog {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }

    @Override
    public void voice() {
        System.out.println(getName() + " is barking");
    }
}
