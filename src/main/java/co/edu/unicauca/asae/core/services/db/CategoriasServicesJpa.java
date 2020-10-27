package co.edu.unicauca.asae.core.services.db;

import java.util.List;
import java.util.Optional;

import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.core.modelo.Categoria;
import co.edu.unicauca.asae.core.repository.categoriasRepository;
import co.edu.unicauca.asae.core.services.ICategoriasService;

/**
 * CategoriasServicesJPA
 */
@Service
@Primary
public class CategoriasServicesJpa implements ICategoriasService {

    @Autowired
    private categoriasRepository servicioBDCategorias;

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        // TODO Auto-generated method stub
        Optional<Categoria> optional = servicioBDCategorias.findById(idCategoria);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Categoria> buscarTodas() {
        // TODO Auto-generated method stub
        return this.servicioBDCategorias.findAll();
    }

    @Override
    public void guardar(Categoria categoria) {
        // TODO Auto-generated method stub

        this.servicioBDCategorias.save(categoria);
    }

}