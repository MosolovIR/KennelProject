package com.test.mvp.model.animal.packanimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Camel {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }

    @Override
    public void voice() {
        System.out.println(getName() + "doing camel's sound");
    }
}
