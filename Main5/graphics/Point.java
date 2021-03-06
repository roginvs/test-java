package graphics;

public class Point extends Graph implements Movable {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println(String.format("Точка: x=%d, y=%d", this.x, this.y));
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    };

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX(){
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}