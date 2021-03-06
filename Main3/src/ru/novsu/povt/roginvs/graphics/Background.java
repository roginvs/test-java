package ru.novsu.povt.roginvs.graphics;

public class Background extends Graph {
    private String color;
    private String texture;

    public Background(String color, String texture) {
        super();
        this.color = color;
        this.texture = texture;
    }

    @Override
    public String draw() {
        return String.format("Фон: цвет=%s, текстура=%s", this.color, this.texture);
    }
}