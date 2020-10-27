package co.edu.unicauca.asae.core.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.core.modelo.Categoria;
import co.edu.unicauca.asae.core.repository.CategoriasRepository;
import co.edu.unicauca.asae.core.services.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {

	@Autowired
	private CategoriasRepository servicioBDCategorias;
	
	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		servicioBDCategorias.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return servicioBDCategorias.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional= servicioBDCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}

		
		return null;
	}

}
