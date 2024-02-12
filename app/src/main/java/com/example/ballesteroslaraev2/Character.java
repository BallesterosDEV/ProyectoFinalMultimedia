package com.example.ballesteroslaraev2;

/**
 * The Character class represents a character entity with its attributes.
 */
public class Character {

    private String id;
    private String name;
    private String race;
    private float height;
    private float weight;

    /**
     * Constructor to create a Character object.
     * @param id The ID of the character.
     * @param name The name of the character.
     * @param race The race of the character.
     * @param height The height of the character.
     * @param weight The weight of the character.
     */
    public Character(String id, String name, String race, float height, float weight) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters

    /**
     * Retrieves the ID of the character.
     * @return The ID of the character.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the character.
     * @param id The ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the character.
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the character.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the race of the character.
     * @return The race of the character.
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the race of the character.
     * @param race The race to set.
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Retrieves the height of the character.
     * @return The height of the character.
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the height of the character.
     * @param height The height to set.
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Retrieves the weight of the character.
     * @return The weight of the character.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the character.
     * @param weight The weight to set.
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }
}