package graphics;

public class Circle extends Point {
    protected String color;
    protected int radius;

    public Circle(int x, int y, int radius, String color) {
        super(x, y);
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String draw() {
        return String.format("Круг: x=%d, y=%d, радиус=%d, цвет=%s", this.x, this.y, this.radius, this.color);
    }
}