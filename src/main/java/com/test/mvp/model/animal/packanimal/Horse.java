package com.test.mvp.model.animal.packanimal;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Horse {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }

    @Override
    public void voice() {
        System.out.println(getName() + "doing horse's sound");
    }
}
