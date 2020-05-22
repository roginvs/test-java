import graphics.*;

public class Main5 {

    private static void swapXY(Movable target)
            // Lol, sonarlint complains:
            // Remove the declaration of thrown exception
            // 'java.lang.NullPointerException' which is a runtime exception
            throws NullPointerException {
        if (target == null) {
            throw new NullPointerException("Object is not created");
        }
        int tempX = target.getX();
        int tempY = target.getY();
        System.out.format("Swapping x=%d y=%d... ", tempX, tempY);
        target.moveTo(tempY, tempX);
        System.out.format("swapped x=%d y=%d", target.getX(), target.getY());
        System.out.println();
    }

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

        Movable[] myMovables = { window, circle, ellipse, null, rectangle };

        for (var target : myMovables) {
            try {
                Main5.swapXY(target);
            } catch (NullPointerException ex) {
                System.out.println("Error while swapping coordinates.");
                ex.printStackTrace();
            }
        }

        System.out.println("Done!");
    }
}