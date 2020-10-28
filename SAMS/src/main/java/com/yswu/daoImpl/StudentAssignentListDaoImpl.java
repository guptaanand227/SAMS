package com.yswu.daoImpl;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.yswu.dao.StudentAssignentListDao;
import com.yswu.model.SSA;
import com.yswu.model.StudentAssignment;

@Repository
@Transactional
public class StudentAssignentListDaoImpl implements StudentAssignentListDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public JSONArray getAssignmentDao() {

		JSONArray array = new JSONArray();

		try {

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<SSA> criteriaQuery1 = criteriaBuilder.createQuery(SSA.class);
			Root<SSA> root1 = criteriaQuery1.from(SSA.class);

			String username = request.getSession().getAttribute("username").toString();

			CriteriaQuery<SSA> criteriaQuery3 = criteriaQuery1.select(root1)
					.where(criteriaBuilder.equal(root1.get("student_username"), username.trim()));

			TypedQuery<SSA> typedQuery1 = session.createQuery(criteriaQuery3);

			List<SSA> list1 = typedQuery1.getResultList();

			List<String> arrayList = null;
			arrayList = new ArrayList<String>();

			if (!list1.isEmpty()) {

				for (SSA ssa : list1) {
					arrayList.add(ssa.getTask_id());
				}

			} else {
				arrayList.add("a");
			}

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<StudentAssignment> criteriaQuery = builder.createQuery(StudentAssignment.class);
			Root<StudentAssignment> root = criteriaQuery.from(StudentAssignment.class);

			CriteriaQuery<StudentAssignment> criteriaQuery2 = criteriaQuery.select(root)
					.where(builder.and(builder.greaterThanOrEqualTo(root.get("end_date"),
							format.parse(format.format(new Date())))),
							builder.not(builder.in(root.get("task_id")).value(arrayList)));

			TypedQuery<StudentAssignment> typedQuery = session.createQuery(criteriaQuery2);

			List<StudentAssignment> list = typedQuery.getResultList();

			for (StudentAssignment studentAssignment : list) {

				JSONArray jsonArray = new JSONArray();

				jsonArray.put(studentAssignment.getTask());
				jsonArray.put(studentAssignment.getEnd_date());
				jsonArray.put(studentAssignment.getFaculty_username());
				jsonArray.put(studentAssignment.getTask_id());

				array.put(jsonArray);

			}

		} catch (Exception e) {
			System.out.println("Exception in StudentAssignmentDaoimpl : " + e);
		}

		return array;
	}

	@Override
	public String getUploadAssignmentDao(MultipartFile file, String faculty_username, String task_id,
			String student_username) {

		String status = "Error";

		try {

			FileInputStream inputStream = (FileInputStream) file.getInputStream();
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<SSA> criteriaQuery = builder.createQuery(SSA.class);
			Root<SSA> root = criteriaQuery.from(SSA.class);

			CriteriaQuery<SSA> criteriaQuery2 = criteriaQuery.select(root);

			TypedQuery<SSA> typedQuery = session.createQuery(criteriaQuery2);

			List<SSA> list = typedQuery.getResultList();

			SSA s = list.get(list.size()-1);
			
			int n = Integer.parseInt(s.getStutask_id());

			SSA ssa = new SSA();

			ssa.setFaculty_username(faculty_username);
			ssa.setStudent_username(student_username);
			ssa.setStutask_id(String.valueOf(n + 1));
			ssa.setTask_id(task_id);
			ssa.setUploaded_file(data);

			session.save(ssa);

			status = "Success";

		} catch (Exception e) {
			System.out.println("Exception in StudentAssignment getUploadAssignmentDao() : " + e);
			status = "Exception";
		}

		return status;
	}

}
