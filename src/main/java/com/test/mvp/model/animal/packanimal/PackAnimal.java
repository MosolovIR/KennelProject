package com.test.mvp.model.animal.packanimal;

import com.test.mvp.model.animal.Animal;

import java.time.LocalDate;

public class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public void carryLoad() {
        System.out.println(getName() + " is carrying a load");
    }

    @Override
    public String toString() {
        return "PackAnimal {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }
}
