package com.virusoft.draculahrm.dao.employee;

import com.virusoft.draculahrm.model.pim.employee.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDAO {
    private final SessionFactory sessionFactory;

    public EmployeeDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public String generateEmployeeNumber(){
        try (Session session = sessionFactory.openSession()){
            Query<Long> query = session.createQuery("SELECT COUNT(e) FROM Employee e", Long.class);
            Long count = query.getSingleResult();

            return  "EMP-" + String.format("%04d", count != null? count + 1: 1);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void saveEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            employee.setEmployeeNumber(generateEmployeeNumber());  // Assign generated number
            session.save(employee);
            tx.commit();
        }
    }




}
