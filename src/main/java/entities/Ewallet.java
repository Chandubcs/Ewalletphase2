package entities;

public class Ewallet {
    private String phno;
    private String name;
    private double balance=0.0;

    private String password;

    public Ewallet() {

    }

    public Ewallet(String phno, String name) {
        this.phno = phno;
        this.name = name;
    }
    public Ewallet(String phno, String name,double balance,String password) {
        this.phno = phno;
        this.name = name;
        this.balance=balance;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }
    public  void transferMoney(Ewallet e,double amount)
    {
        this.balance=this.balance-amount;
        e.balance=e.balance+amount;
    }

    @Override
    public String toString() {
        String display = phno + " " + name;
        return display;
    }

    public boolean equals(Object obj) {
        if (obj.equals(this)) {
            return true;
        }
        if (obj == null || !(obj instanceof Ewallet)) {
            return false;
        }
        Ewallet e = (Ewallet) obj;
        return e.phno == this.phno;
    }

    @Override
    public int hashCode() {
        return phno.hashCode();
    }


}
