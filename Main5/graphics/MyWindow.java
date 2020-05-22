package graphics;

public class MyWindow implements Movable {
    protected int x;
    protected int y;

    public MyWindow(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(int x, int y) {
        System.out.println(String.format("MyWindows moved x=%d y=%d", x, y));
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}