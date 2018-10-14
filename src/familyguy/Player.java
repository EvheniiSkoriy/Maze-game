package familyguy;

import java.io.File;

public class Player {

    String name;
    File character;
    int achievedLevel;
    int positionX;
    int positionY;

    public Player(String name, File character, int achievedLevel, int positionX, int positionY) {
        this.name = name;
        this.character = character;
        this.achievedLevel = achievedLevel;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getCharacter() {
        return character;
    }

    public void setCharacter(File character) {
        this.character = character;
    }

    public int getAchievedLevel() {
        return achievedLevel;
    }

    public void setAchievedLevel(int achievedLevel) {
        this.achievedLevel = achievedLevel;
    }

    @Override
    public String toString() {
        return "Name " + name + ", character " + character + ", achievedLevel " + achievedLevel;
    }

}
