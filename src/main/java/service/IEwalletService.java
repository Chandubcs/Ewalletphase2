package service;

import entities.Ewallet;

import java.util.Set;

public interface IEwalletService {
    void addEmployee(Ewallet e);

    public Ewallet findEmployeeByphno(String phno);
    boolean credentialsCorrect(String username,String password);

   Ewallet getUserByUsername(String username);
    Set<Ewallet> allEmployees();

}
