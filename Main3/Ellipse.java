package Main3;

public class Ellipse extends Rectangle {
    public Ellipse(int x, int y, int width, int height, String color) {
        super(x, y, width, height, color);
    }

    @Override
    String draw() {
        return String.format("Эллипс: x=%d, y=%d, ширина=%d, высота=%d, цвет=%s", this.x, this.y, this.width,
                this.height, this.color);
    }
}