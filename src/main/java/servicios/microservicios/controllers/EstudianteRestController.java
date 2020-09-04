package servicios.microservicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicios.microservicios.entities.Estudiante;
import servicios.microservicios.servicios.IEstudianteServicio;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class EstudianteRestController {

    @Autowired
    IEstudianteServicio iEstudianteServicio;

    @GetMapping("estudiantes")
    public ResponseEntity<?> index(){
        return ResponseEntity.ok().body(iEstudianteServicio.findAll());
    }

    @GetMapping("estudiantes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Optional<Estudiante> o = iEstudianteServicio.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping("estudiantes")
    public ResponseEntity<?> create(@RequestBody Estudiante estudiante){
        Estudiante estudiantDb = iEstudianteServicio.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudiantDb);
    }

    @PutMapping("estudiantes/{id}")
    public ResponseEntity<?> update(@RequestBody Estudiante estudiante, @PathVariable Long id){
        Optional<Estudiante> o = iEstudianteServicio.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Estudiante estudianteActual = o.get();
        estudianteActual.setApellido(estudiante.getApellido());
        estudianteActual.setNombre(estudiante.getNombre());
        estudianteActual.setEmail(estudiante.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(iEstudianteServicio.save(estudianteActual));
    }

    @DeleteMapping("estudiantes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        iEstudianteServicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
