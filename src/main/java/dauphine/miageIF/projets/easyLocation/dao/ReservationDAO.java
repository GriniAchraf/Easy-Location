package dauphine.miageIF.projets.easyLocation.dao;

import java.util.List;

import dauphine.miageIF.projets.easyLocation.model.Reservation;

public interface ReservationDAO {
	public void addReservation(Reservation r);
	public Reservation getReservationByID(int idReservation);
	public void updateReservation(Reservation r);
	public List<Reservation> getAllReservations();
	public void removeReservation(int idReservation);
}
