package graphics;

public class Rectangle extends Point {
    protected String color;
    protected int width;
    protected int height;

    public Rectangle(int x, int y, int width, int height, String color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String draw() {
        return String.format("Прямоугольник: x=%d, y=%d, ширина=%d, высота=%d, цвет=%s", this.x, this.y, this.width,
                this.height, this.color);
    }
}