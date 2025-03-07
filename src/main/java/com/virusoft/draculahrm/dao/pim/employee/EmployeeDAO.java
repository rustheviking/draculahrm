package com.virusoft.draculahrm.dao.pim.employee;

import com.virusoft.draculahrm.app.AppConfig;
import com.virusoft.draculahrm.model.base.Department;
import com.virusoft.draculahrm.model.pim.employee.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EmployeeDAO {

    public String generateEmployeeNumber() {
        try (Session session = AppConfig.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(e) FROM Employee e", Long.class);
            Long count = query.getSingleResult();
            return "EMP-" + String.format("%04d", (count != null) ? count + 1 : 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveEmployee(Employee employee) {
        Transaction tx = null;
        try (Session session = AppConfig.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Department> getAllDepartments() {
        try (Session session = AppConfig.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery("FROM Department", Department.class);
            return query.list();
        }
    }
}
