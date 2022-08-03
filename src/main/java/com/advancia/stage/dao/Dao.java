package com.advancia.stage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.advancia.stage.model.Employee;

public class Dao {

	private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

	static {
		initEmps();
	}

	private static void initEmps() {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		Employee emp4 = new Employee();
		Employee emp5 = new Employee();
		Employee emp6 = new Employee();
		Employee emp7 = new Employee();
		Employee emp8 = new Employee();
		Employee emp9 = new Employee();

		empMap.put(emp1.getFirsn(), emp1);
		empMap.put(emp2.getLastn(), emp2);
		empMap.put(emp3.getEmail(), emp3);
		empMap.put(emp4.getPhone(), emp4);
		empMap.put(emp5.getPhone(), emp5);
		empMap.put(emp6.getPhone(), emp6);
		empMap.put(emp7.getPhone(), emp7);
		empMap.put(emp8.getPhone(), emp8);
		empMap.put(emp9.getPhone(), emp9);
	}

	public static List<Employee> getAllEmployees() {
		EntityManager entityManager = (EntityManager) Dao.getAllEmployees();
		TypedQuery<Employee> query = entityManager.createQuery("SELECT i FROM EMPLOYEES i", Employee.class);
		List<Employee> employees = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return employees;
	}

	public static Employee getEmployee(String empNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Employee addEmployee(Employee emp) {
		EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee student = new Employee();
		entityManager.persist(addEmployee(null));
		entityManager.getTransaction().commit();
		entityManager.close();
		return null;
	}

	public static Employee updateEmployee(Employee emp) {

		EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println("employee id :: " + employee.getId());
		System.out.println("employee firstname :: " + employee.getFirsn());
		System.out.println("employee lastname :: " + employee.getLastn());
		System.out.println("employee email :: " + employee.getJob());
		System.out.println("employee email :: " + employee.getEmail());
		System.out.println("employee email :: " + employee.getPhone());
		System.out.println("employee email :: " + employee.getHiredate());
		System.out.println("employee email :: " + employee.getSalary());
		System.out.println("employee email :: " + employee.getCommission());

		// The entity object is physically updated in the database when the transaction
		// is committed
		employee.setFirsn(0);
		employee.setLastn(0);
		employee.setJob(0);
		employee.setEmail(0);
		employee.setPhone(0);
		employee.setHiredate(0);
		employee.setSalary(0);
		employee.setCommission(0);
		entityManager.getTransaction().commit();
		entityManager.close();

		return null;
	}

	public static void deleteEmployee(String empNo) {
		EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Employee student = entityManager.find(Employee.class, 1);
		entityManager.remove(Employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
