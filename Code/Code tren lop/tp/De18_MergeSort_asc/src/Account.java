public class Account implements Comparable<Account> {
    String number;
    String owner;
    double balance;

    Account(String number, String owner, double balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "(" + "balance=" + balance + ", number=" + number + ", owner=" + owner + ")";
    }
    @Override
    public int compareTo(Account o) {
        // compare object base on owner and descending by balance
        if(this.owner.compareTo(o.owner) == 0){
            return (int)(o.balance - this.balance);
        }
        return this.owner.compareTo(o.owner);
    }
}
