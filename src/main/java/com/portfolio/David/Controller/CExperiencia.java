
import com.portfolio.David.Dto.DtoExperiencia;
import com.portfolio.David.Entity.Experiencia;
import com.portfolio.David.Security.Controller.Mensaje;
import com.portfolio.David.Service.SExperiencia;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author David
 */

@RestController
@RequestMapping("/explab")  
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list,HttpStatus.OK);  
    }
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoXP){
        if(StringUtils.isBlank(dtoXP.getNombreXP()))
            return new ResponseEntity(new Mensaje("nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByNombreXP(dtoXP.getNombreXP())) 
            return new ResponseEntity(new Mensaje("experiencia ya existe"),HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(dtoXP.getNombreXP(),dtoXP.getDescripXP());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("experiencia Agregada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoXP){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        if (sExperiencia.existsByNombreXP(dtoXP.getNombreXP()) && sExperiencia.getByNombreXP(dtoXP.getNombreXP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esa experiencia ya existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoXP.getNombreXP()))
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"),HttpStatus.BAD_REQUEST);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreXP(dtoXP.getNombreXP());
        experiencia.setDescripXP(dtoXP.getDescripXP());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"),HttpStatus.OK);
    }   
        
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("experiencia eliminada"),HttpStatus.OK);
    }
}
