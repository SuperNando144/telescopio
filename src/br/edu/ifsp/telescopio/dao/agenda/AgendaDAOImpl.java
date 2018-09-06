package br.edu.ifsp.telescopio.dao.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsp.telescopio.conn.FactoryEntityManager;
import br.edu.ifsp.telescopio.models.Agenda;

public class AgendaDAOImpl implements AgendaDAO {

	private EntityManager manager;

	public AgendaDAOImpl() {
	}

	public void conecta() {
		this.manager = FactoryEntityManager.getEntityManager();
	}

	public void fechar() {
		this.manager.close();
	}

	@Override
	public void persist(Agenda agenda) {
		manager.getTransaction().begin();
		manager.persist(agenda);
		manager.getTransaction().commit();
	}

	@Override
	public void update(Agenda agenda) {
		manager.getTransaction().begin();
		manager.merge(agenda);
		manager.getTransaction().commit();
	}

	@Override
	public void delete(Agenda agenda) {
		manager.getTransaction().begin();
		manager.remove(agenda);
		manager.getTransaction().commit();
	}

	@Override
	public Agenda findById(long id) {
		Query query = manager.createQuery("SELECT a FROM Agenda a WHERE AGE_COD = :id").setParameter("id", id);
		try {
			Agenda agend = (Agenda) query.getSingleResult();
			return agend;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Agenda findByDate(Date data) {
		Query query = manager.createQuery("SELECT a FROM Agenda a WHERE AGE_DATA = :data").setParameter("data", data);
		try {
			Agenda agend = (Agenda) query.getSingleResult();
			return agend;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public ArrayList<Agenda> findbyUsuId(long id) {
		Query query = manager.createQuery("SELECT a FROM Agenda a WHERE USU_COD = :id").setParameter("id", id);
		try {
			ArrayList<Agenda> agend = (ArrayList<Agenda>) query.getResultList();
			return agend;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agenda> findAll() {
		Query query = manager.createQuery("SELECT * FROM Agenda");
		try {
			List<Agenda> agend = query.getResultList();
			return agend;
		} catch (Exception e) {
			return null;
		}
	}

}
