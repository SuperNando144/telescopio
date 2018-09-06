package br.edu.ifsp.telescopio.dao.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifsp.telescopio.models.Agenda;

public interface AgendaDAO {
	public void persist(Agenda entity);
	public void update(Agenda entity);	
    public Agenda findById(long id);
    public Agenda findByDate(Date data);
    public ArrayList<Agenda> findbyUsuId(long id);
    public void delete(Agenda entity);	     
    public List<Agenda> findAll();
}
