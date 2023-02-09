public class Food implements Comparable<Food> {
    String code;
    String name;
    String category;
    int price;

    public Food(String code, String name, String category, int price) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food [code=" + code + ", name=" + name + ", category=" + category + ", price=" + price + "]";
    }

    @Override
    public int compareTo(Food o) {
        if (this.category.compareTo(o.category) == 0)
            return this.price - o.price;
        return this.category.compareTo(o.category);

    }

}
