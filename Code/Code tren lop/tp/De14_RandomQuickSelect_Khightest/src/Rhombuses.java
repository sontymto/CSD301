public class Rhombuses implements Comparable<Rhombuses> {
    double d1;
    double d2;
    String color;
    Rhombuses(double d1, double d2, String color) {
        this.d1 = d1;
        this.d2 = d2;
        this.color = color;
    }
    double area() {
        return d1 * d2 / 2;
    }

    @Override
    public String toString() {
        return "Rhombuses{" +
                "d1=" + d1 +
                ", d2=" + d2 +
                ", color='" + color + '\'' +
                '}';
    }
    @Override
    public int compareTo(Rhombuses o) {
        if (this.area() > o.area()) {
            return 1;
        } else if (this.area() < o.area()) {
            return -1;
        } else {
            return 0;
        }
    }

}
