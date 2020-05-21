package Main3;

class Point extends Graph {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String draw() {
        return String.format("Точка: x=%d, y=%d", this.x, this.y);
    }

    void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    };

    void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}