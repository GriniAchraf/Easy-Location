package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import org.hibernate.Session;

import dauphine.miageIF.projets.easyLocation.model.HibernateUtils;
import dauphine.miageIF.projets.easyLocation.model.Reservation;

public class ReservationDAOImpl implements ReservationDAO {

	Session session;
	@Override
	public void addReservation(Reservation r) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();
	    session.close();			
	}

	@Override
	public Reservation getReservationByID(int idReservation) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();		
		Reservation r =  (Reservation) session.get(Reservation.class, idReservation);
		session.close();
		return r;
	}

	@Override
	public void updateReservation(Reservation r) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Reservation rsrv = (Reservation) session.get(Reservation.class, r.getIdReserv());
		rsrv.setClient(r.getClient());
		rsrv.setDateLimiteRetour(r.getDateLimiteRetour());
		rsrv.setDateRsrv(r.getDateRsrv());
		rsrv.setDureeLocation(r.getDureeLocation());
		rsrv.setLocation(r.getLocation());
		rsrv.setProduit(r.getProduit());
		session.getTransaction().commit();
	    session.close();		
		
	}

	@Override
	public List<Reservation> getAllReservations() {
		String hql="from Reservation";
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Reservation> reservations = session.createQuery(hql).list();
		session.close();
		return reservations;
	}

	@Override
	public void removeReservation(int idReservation) {
		session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Reservation r = (Reservation)session.get(Reservation.class, idReservation);
		session.delete(r);
		session.getTransaction().commit();
	    session.close();
	}

}
