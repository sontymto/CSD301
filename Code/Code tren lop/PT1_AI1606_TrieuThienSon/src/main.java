public class main {
    public static void main(String[] args) {
        GetInput input = new GetInput();
        // input number of food
        int n = input.inputPositiveNumber("Enter number of food: ");
//        int n = 7;
        Food[] foods = new Food[n];
        // input food
        for (int i = 0; i < n; i++) {
            // print index of food
            System.out.printf("Food %d: %n", i + 1);
            String code = input.inputCode("Enter code: ", foods, i);
            String name = input.inputName("Enter name: ");
            String category = input.inputCategory("Enter category: ");
            int price = input.inputPrice("Enter price: ");
            foods[i] = new Food(code, name, category, price);
        }
        // test data
//         foods[0] = new Food("5", "5", "5", 5);
//         foods[1] = new Food("1", "1", "1", 1);
//         foods[2] = new Food("2", "2", "2", 2);
//         foods[3] = new Food("4", "4", "4", 4);
//         foods[4] = new Food("3", "3", "2", 3);
//         foods[5] = new Food("2", "2", "4", 2);
//         foods[6] = new Food("2", "2", "6", 5);

        // input k to select kth smallest food
        int k = input.inputKth("Enter k: ", n);

        // display all food
        System.out.println("All food: ");
        for (Food food : foods) {
            System.out.println(food);
        }
        // select kth smallest food
        Food kthFood = SelectKthOrder.selectKOrder(foods, 0, foods.length - 1, k);
        // display kth smallest food
        System.out.printf("The %dth smallest food is: %s", k, kthFood);
    }
}
