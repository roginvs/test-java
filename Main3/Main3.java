package Main3;

public class Main3 {
    public static void main(String[] args) {
        var background = new Background("gray", "lolkek");
        var point = new Point(5, 6);
        var circle = new Circle(1, 2, 10, "green");
        var ellipse = new Ellipse(3, 4, 11, 12, "yellow");
        var rectangle = new Rectangle(7, 8, 13, 14, "blue");

        System.out.println(background.draw());
        System.out.println(point.draw());

        System.out.println(circle.draw());
        System.out.println(rectangle.draw());
        System.out.println(ellipse.draw());

        System.out.println("");
        System.out.println("Move rectangle");
        rectangle.move(5, 6);
        System.out.println(rectangle.draw());

        System.out.println("");
        System.out.println("MoveTo rectangle");
        rectangle.moveTo(15, 15);
        System.out.println(rectangle.draw());
    }
}