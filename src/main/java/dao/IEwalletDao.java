package dao;

import entities.Ewallet;

import java.util.Set;

public interface IEwalletDao {
    void addEmployee(Ewallet e);

    Ewallet findEmployeeByphno(String phno);
    void transferMoney(Ewallet e,double amount);
    boolean credentialsCorrect(String username,String password);

    Ewallet getUserByUsername(String username);
    Set<Ewallet> allEmployees();


}
