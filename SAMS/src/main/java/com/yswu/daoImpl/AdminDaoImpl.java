package com.yswu.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.yswu.dao.AdminDao;
import com.yswu.model.StudentAssignment;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public JSONArray getAssignmentDao() {

		JSONArray array = new JSONArray();

		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<StudentAssignment> criteriaQuery = builder.createQuery(StudentAssignment.class);
			Root<StudentAssignment> root = criteriaQuery.from(StudentAssignment.class);

			CriteriaQuery<StudentAssignment> criteriaQuery2 = criteriaQuery.select(root)
					.where(builder.greaterThanOrEqualTo(root.get("end_date"), format.parse(format.format(new Date()))));
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
			System.out.println("Exception in AdminDaoImpl : " + e);
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
			System.out.println("Exception in AdminDaoImpl updateStatusDao() :  " + e);
			status = "Exception";
		}

		return status;
	}

}
