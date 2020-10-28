package com.yswu.daoImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yswu.dao.FacultyDao;
import com.yswu.model.SSA;
import com.yswu.model.StudentAssignment;

@Repository
@Transactional
public class FacultyDaoImpl implements FacultyDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public JSONArray getAssignmentDao() {

		JSONArray array = new JSONArray();

		try {

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<StudentAssignment> criteriaQuery = builder.createQuery(StudentAssignment.class);
			Root<StudentAssignment> root = criteriaQuery.from(StudentAssignment.class);

			CriteriaQuery<StudentAssignment> criteriaQuery2 = criteriaQuery.select(root).where(builder
					.equal(root.get("faculty_username"), request.getSession().getAttribute("username").toString()));
			TypedQuery<StudentAssignment> typedQuery = session.createQuery(criteriaQuery2);

			List<StudentAssignment> list = typedQuery.getResultList();

			for (StudentAssignment studentAssignment : list) {

				JSONArray jsonArray = new JSONArray();

				jsonArray.put(studentAssignment.getTask_id());
				jsonArray.put(studentAssignment.getTask());
				jsonArray.put(studentAssignment.getEnd_date());

				array.put(jsonArray);

			}

		} catch (Exception e) {
			System.out.println("Exception in FacultyDaoImpl : " + e);
		}

		return array;
	}

	@Override
	public String updateStatusDao(String task_id, String question, String last_date) {

		String status = "Error";
		try {

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			Session session = entityManager.unwrap(Session.class);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			StudentAssignment assignment = new StudentAssignment();

			assignment.setTask_id(task_id);
			assignment.setTask(question);
			assignment.setFaculty_username(request.getSession().getAttribute("username").toString());
			assignment.setEnd_date(simpleDateFormat.parse(last_date));

			session.update("task_id", assignment);

			status = "Success";

		} catch (Exception e) {
			System.out.println("Exception in FacutyDaoImpl updateStatusDao() :  " + e);
			status = "Exception";
		}

		return status;
	}

	@Override
	public String deleteStatusDao(String task_id, String question, String last_date) {

		String status = "Error";
		try {

			Session session = entityManager.unwrap(Session.class);

			StudentAssignment assignment = session.get(StudentAssignment.class, task_id);

			if (assignment != null) {
				session.delete(assignment);
				status = "Success";
			}

		} catch (Exception e) {
			System.out.println("Exception in FacutyDaoImpl deleteStatusDao() :  " + e);
			status = "Exception";
		}

		return status;
	}

	@Override
	public String createStatusDao(String question, String dateID) {

		String status = "Error";
		try {

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<StudentAssignment> criteriaQuery = builder.createQuery(StudentAssignment.class);
			Root<StudentAssignment> root = criteriaQuery.from(StudentAssignment.class);

			CriteriaQuery<StudentAssignment> criteriaQuery2 = criteriaQuery.select(root);

			TypedQuery<StudentAssignment> typedQuery = session.createQuery(criteriaQuery2);

			List<StudentAssignment> list = typedQuery.getResultList();

			StudentAssignment sa = list.get(list.size() - 1);

			int n = Integer.parseInt(sa.getTask_id());

			String task_id = String.valueOf(n + 1);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			StudentAssignment assignment = new StudentAssignment();

			assignment.setTask_id(task_id);
			assignment.setTask(question);
			assignment.setFaculty_username(request.getSession().getAttribute("username").toString());
			assignment.setEnd_date(simpleDateFormat.parse(dateID));

			session.save(assignment);

			status = "Success";

		} catch (Exception e) {
			System.out.println("Exception in FacutyDaoImpl createStatusDao() :  " + e);
			status = "Exception";
		}

		return status;
	}

	@Override
	public JSONArray getDownloadAssignmentDao() {

		JSONArray array = new JSONArray();

		try {

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SSA> criteriaQuery = builder.createQuery(SSA.class);
			Root<SSA> root = criteriaQuery.from(SSA.class);

			CriteriaQuery<SSA> criteriaQuery2 = criteriaQuery.select(root).where(builder
					.equal(root.get("faculty_username"), request.getSession().getAttribute("username").toString()));
			TypedQuery<SSA> typedQuery = session.createQuery(criteriaQuery2);

			List<SSA> list = typedQuery.getResultList();

			for (SSA ssa : list) {

				JSONArray jsonArray = new JSONArray();

				jsonArray.put(ssa.getStutask_id());
				jsonArray.put(ssa.getStudent_username());

				array.put(jsonArray);

			}

		} catch (Exception e) {
			System.out.println("Exception in FacultyDaoImpl : " + e);
		}

		return array;
	}

	@Override
	public byte[] getDownloadAssignmentDataDao(String stutaskID) {

		byte[] data = null;

		try {

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SSA> criteriaQuery = builder.createQuery(SSA.class);
			Root<SSA> root = criteriaQuery.from(SSA.class);

			CriteriaQuery<SSA> criteriaQuery2 = criteriaQuery.select(root)
					.where(builder.equal(root.get("stutask_id"), stutaskID));
			TypedQuery<SSA> typedQuery = session.createQuery(criteriaQuery2);

			List<SSA> list = typedQuery.getResultList();

			for (SSA ssa : list) {

				data = ssa.getUploaded_file();
			}

		} catch (Exception e) {
			System.out.println("Exception in FacultyDaoImpl : " + e);
		}

		return data;
	}

}
