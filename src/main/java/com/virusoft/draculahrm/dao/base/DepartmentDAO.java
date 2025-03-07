package com.virusoft.draculahrm.dao.base;

import com.virusoft.draculahrm.model.base.Department;
import com.virusoft.draculahrm.app.AppConfig;
import org.hibernate.Session;
import java.util.List;

public class DepartmentDAO {
    public List<Department> getAllDepartments() {
        try (Session session = AppConfig.getSessionFactory().openSession()) {
            return session.createQuery("FROM Department", Department.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

