package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {

    private String name;
    private long balance;
    private List<User> users;


    public Company(String name, long balance, List<User> users) {
        this.name = name;
        this.balance = balance;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}
