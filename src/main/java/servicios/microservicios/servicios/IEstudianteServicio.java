package servicios.microservicios.servicios;

import servicios.microservicios.entities.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteServicio {

    public List<Estudiante> findAll();

    public Optional<Estudiante> findById(Long id);

    public Estudiante save(Estudiante estudiante);

    public void deleteById(Long id);

}
