public class Circle implements Comparable<Circle> {
    String color;
    double radius;
    int x;
    int y;

    public Circle(String color, double radius, int x, int y) {
        this.color = color;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Circle: " + color + " " + radius + " " + x + " " + y;
    }

    public int compareTo(Circle c) {
        if (this.color.compareTo(c.color) == 0) {
            return (int) (this.radius - c.radius);
        }
        return this.color.compareTo(c.color);
    }
}
