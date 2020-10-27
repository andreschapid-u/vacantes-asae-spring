package co.edu.unicauca.asae.core.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.core.modelo.Usuario;

public interface usuariosRepository extends JpaRepository<Usuario, Integer> {

}
