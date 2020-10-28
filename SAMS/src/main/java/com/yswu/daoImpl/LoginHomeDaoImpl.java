package com.yswu.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yswu.dao.LoginHomeDao;
import com.yswu.model.LoginHome;

@Repository
@Transactional
public class LoginHomeDaoImpl implements LoginHomeDao {

	@Autowired
	private EntityManager entityManager;

	private HttpSession httpSession;

	@Override
	public String getLoginHomeStatusDao(String username, String password, String userType) {

		String status = "nothing";

		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();

			Session session = entityManager.unwrap(Session.class);

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<LoginHome> criteriaQuery = criteriaBuilder.createQuery(LoginHome.class);
			Root<LoginHome> root = criteriaQuery.from(LoginHome.class);

			CriteriaQuery<LoginHome> criteriaQuery2 = criteriaQuery.select(root)
					.where(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("loginHomeEmbeddable").get("username"), username.trim())),
							criteriaBuilder.equal(root.get("loginHomeEmbeddable").get("user_type"), userType.trim()));

			TypedQuery<LoginHome> typedQuery = session.createQuery(criteriaQuery2);

			List<LoginHome> list = typedQuery.getResultList();

			if (!list.isEmpty()) {
				for (LoginHome loginHome : list) {

					byte[] fetchPassword = loginHome.getPassword();
					String fPassword = new String(fetchPassword);					

					if (fPassword.equals(password.trim())) {

						status = "matched";

						if (request.getSession(false) != null) {
							request.getSession(false).invalidate();
							httpSession = request.getSession(true);
						} else {
							httpSession = request.getSession(true);
						}

						httpSession.setAttribute("username", username);
						httpSession.setAttribute("userType", userType);

					} else {
						status = "notMatchedP";
					}
				}
			} else {
				status = "notMatchedU";
			}

		} catch (Exception e) {
			System.out.println("Exception in LoginHomeDaoImpl : getLoginHomeDaoStatus() : " + e);
		}
		

		return status;
	}

}
