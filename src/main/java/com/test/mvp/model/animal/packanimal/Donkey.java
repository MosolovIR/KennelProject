package com.test.mvp.model.animal.packanimal;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Donkey {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }

    @Override
    public void voice() {
        System.out.println(getName() + "doing donkey's sound");
    }
}
