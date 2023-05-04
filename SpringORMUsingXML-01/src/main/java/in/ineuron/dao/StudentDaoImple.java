package in.ineuron.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImple implements IStudentDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int insert(StudentBO bo) {
		int rowAffected = (Integer) hibernateTemplate.save(bo);
		return rowAffected;
	}

	public void delete(int id) {
		StudentBO bo = hibernateTemplate.get(StudentBO.class, id);
		if (bo != null) {
			hibernateTemplate.delete(bo);
			System.out.println("Record deleted succesfully :: " + id);
		} else {
			System.out.println("Record not available for deletion for the id :: " + id);
		}
	}

	public void delete(StudentBO bo) {
		StudentBO stdRecord = hibernateTemplate.get(StudentBO.class, bo.getSid());
		if (stdRecord != null) {
			hibernateTemplate.delete(stdRecord);
		} else {
			System.out.println("Record not available for deletion...");
		}
	}

	public void update(StudentBO bo) {
		hibernateTemplate.saveOrUpdate(bo);
	}

	public StudentBO getStudent(int id) {
		System.out.println(id);
		StudentBO bo = hibernateTemplate.get(StudentBO.class, id);
		return bo;
	}

	public List<StudentBO> getAllStudents() {
		List<StudentBO> students = hibernateTemplate.loadAll(StudentBO.class);
		return students;
	}

}
