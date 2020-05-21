package Main3.Graph;

public class Point extends Graph {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String draw() {
        return String.format("Точка: x=%d, y=%d", this.x, this.y);
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    };

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}