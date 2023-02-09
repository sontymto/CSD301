public class Course implements Comparable<Course> {
    String code;
    String name;
    int credit;

    public Course(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %d", code, name, credit);
    }

    @Override
    public int compareTo(Course o) {
        if(this.credit == o.credit){
            return o.name.compareTo(this.name);
        }
        return this.credit - o.credit;
    }
}
