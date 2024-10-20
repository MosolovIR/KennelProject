package com.test.db;

import com.test.mvp.model.animal.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/friends_of_human";
    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = "password";

    private void addAnimal(Animal animal, String tableName) throws SQLException {
        String query = "INSERT INTO " + tableName + " (name, birthDate, animalType) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, animal.getName());
            statement.setDate(2, Date.valueOf(animal.getBirthDate()));
            statement.setString(3, animal.getClass().getSimpleName());
            statement.executeUpdate();
        }
    }

    public List<Animal> getAllAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();
        String query = "SELECT * FROM Animals";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Date birthDate = resultSet.getDate("birthDate");
                String animalType = resultSet.getString("animalType");
                animals.add(new Animal(name, birthDate.toLocalDate()));
            }
        }
        return animals;
    }

    public void deleteCamel() throws SQLException {
        String query = "DELETE FROM pack_animals WHERE animalType = 'Camel'";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }
    }
}
