package servicios.microservicios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicios.microservicios.entities.Estudiante;
import servicios.microservicios.repositorios.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicioImpl implements IEstudianteServicio {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }
}
