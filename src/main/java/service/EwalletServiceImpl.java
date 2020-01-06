package service;

import dao.IEwalletDao;
import entities.Ewallet;
import exceptions.IncorrectphnoException;

import java.util.Set;

public class EwalletServiceImpl implements IEwalletService {
    private IEwalletDao dao;

    public EwalletServiceImpl(IEwalletDao dao) {
        this.dao = dao;
    }

    @Override
    public void addEmployee(Ewallet e) {
        dao.addEmployee(e);

    }

    @Override
    public Ewallet findEmployeeByphno(String phno) {
        if (phno == null||phno.length()!=10) {
            throw new IncorrectphnoException("phno is incorrect");
        }
        Ewallet e = dao.findEmployeeByphno(phno);
        return e;

    }
    @Override
    public boolean credentialsCorrect(String username,String password)
    {
        boolean correct=dao.credentialsCorrect(username,password);
        return correct;
    }


    @Override
    public Ewallet getUserByUsername(String username)
    {
        Ewallet user=dao.getUserByUsername(username);
        return user;
    }

    @Override
    public Set<Ewallet> allEmployees() {
        Set<Ewallet> employees = dao.allEmployees();
        return employees;
    }
}
