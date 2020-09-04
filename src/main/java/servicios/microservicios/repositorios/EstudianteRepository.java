package servicios.microservicios.repositorios;

import org.springframework.data.repository.CrudRepository;
import servicios.microservicios.entities.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
