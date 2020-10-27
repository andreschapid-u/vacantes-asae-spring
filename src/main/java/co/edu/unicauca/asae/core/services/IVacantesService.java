package co.edu.unicauca.asae.core.services;

import java.util.List;

import co.edu.unicauca.asae.core.modelo.Vacante;


public interface IVacantesService {
	
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
	
}
