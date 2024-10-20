package com.test.mvp.model.animal.pet;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Hamster {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }

    @Override
    public void voice() {
        System.out.println(getName() + "doing hamster's sound");
    }
}
