package co.edu.unicauca.asae.core.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.core.modelo.Vacante;
import co.edu.unicauca.asae.core.repository.VacantesRepository;
import co.edu.unicauca.asae.core.services.IVacantesService;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {
	
	@Autowired
	private VacantesRepository servicioBDVacantes;


	@Override
	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return servicioBDVacantes.findAll();
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		Optional<Vacante> optional= servicioBDVacantes.findById(idVacante);
		if(optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		servicioBDVacantes.save(vacante);
	}

}
