package com.test.db;

import com.test.mvp.model.animal.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void addAnimal(String name, Date birthDate, String animalType) throws SQLException {
        String tableName;
        if (animalType.toLowerCase().equals("dog") ||
            animalType.toLowerCase().equals("cat") ||
            animalType.toLowerCase().equals("hamster")) {
            tableName = "pets";
        } else if (animalType.toLowerCase().equals("horse") ||
                animalType.toLowerCase().equals("camel") ||
                animalType.toLowerCase().equals("donkey")) {
            tableName = "pack_animals";
        } else {
            throw new SQLException("Unsupported animalType: " + animalType);
        }

        String query = "INSERT INTO "+ tableName + " (name, birthDate, animalType) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setDate(2, birthDate);
            statement.setString(3, animalType);
            statement.executeUpdate();
        }
    }

    public List<Animal> getAllAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();
        String query = "SELECT * FROM pets UNION SELECT * FROM pack_animals";
        try (Connection connection = DatabaseConnection.getConnection()) {
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
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }
    }
}
