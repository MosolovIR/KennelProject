package com.test.mvp.model.animal.pet;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Cat {Name = '" + getName() + "' Age = " + getAge() + " (birthDate = " + getBirthDate() + ") , commands = " + getCommands() + "}";
    }

    @Override
    public void voice() {
        System.out.println(getName() + "said 'Meow'");
    }
}
