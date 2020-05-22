import graphics.*;

public class Main5 {
    public static void main(String[] args) {
        var background = new Background("gray", "lolkek");
        var point = new Point(5, 6);
        var circle = new Circle(1, 2, 10, "green");
        var ellipse = new Ellipse(3, 4, 11, 12, "yellow");
        var rectangle = new Rectangle(7, 8, 13, 14, "blue");

        background.draw();
        point.draw();

        circle.draw();
        rectangle.draw();
        ellipse.draw();

        System.out.println("");
        System.out.println("Move rectangle");
        rectangle.move(5, 6);
        rectangle.draw();

        System.out.println("");
        System.out.println("MoveTo rectangle");
        rectangle.moveTo(15, 15);
        rectangle.draw();

        System.out.println("");
        System.out.println("Moving window");
        var window = new MyWindow(8, 9);
        window.moveTo(11, 12);
    }
}