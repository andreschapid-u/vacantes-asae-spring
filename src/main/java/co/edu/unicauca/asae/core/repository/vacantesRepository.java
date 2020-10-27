package co.edu.unicauca.asae.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.core.modelo.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}
