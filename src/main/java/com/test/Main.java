package com.test;

import com.test.mvp.model.animal.AnimalRegistry;
import com.test.mvp.presenter.Presenter;
import com.test.mvp.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry model = new AnimalRegistry();
        ConsoleUI view = new ConsoleUI();
        Presenter presenter = new Presenter(model, view);

        presenter.start();
    }
}