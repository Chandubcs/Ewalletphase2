package dao;

import entities.Ewallet;
import exceptions.EmployeeNotFoundException;

import javax.print.DocFlavor;
import java.util.*;

public class EwalletDaoImpl implements IEwalletDao {
    private Map<String, Ewallet> store = new HashMap<>();

    @Override
    public void addEmployee(Ewallet e) {
        store.put(e.getPhno(), e);

    }

    @Override
    public void transferMoney(Ewallet e, double amount) {


    }

    @Override
    public Ewallet findEmployeeByphno(String phno) {
        Ewallet e = store.get(phno);
        if (e == null) {
            throw new EmployeeNotFoundException("Employee not found for phno:" + phno);
        }
        return e;
    }

    @Override
    public boolean credentialsCorrect(String username, String password) {
        Ewallet user = store.get(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);

    }

    @Override
    public Ewallet getUserByUsername(String username) {
        Ewallet user = store.get(username);
        return user;
    }

    @Override
    public Set<Ewallet> allEmployees() {
        Collection<Ewallet> wallets = store.values();
        Set<Ewallet> walletSet = new HashSet<>(wallets);
        return walletSet;

    }
}
