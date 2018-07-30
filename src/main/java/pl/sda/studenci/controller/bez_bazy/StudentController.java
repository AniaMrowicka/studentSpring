package pl.sda.studenci.controller.bez_bazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.studenci.model.Student;
import pl.sda.studenci.service.bez_bazy.StudentService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/staryStudent/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "/dodajStudenta", method = RequestMethod.POST)
    public ResponseEntity dodajStudenta(@RequestBody Student student){
        studentService.dodajStudenta(student);
        return ResponseEntity.ok(student);
    }
    @GetMapping(path = "/listowanieStudentow")
    public ResponseEntity listowanie(){
        return ResponseEntity.ok(studentService.listowanie());

    }
    @GetMapping(path = "/usunStudenta/{parametr}")
    public ResponseEntity usun(@PathVariable(name = "parametr") Long id){
        boolean udalosie= studentService.usun(id);
        if (udalosie){
            return ResponseEntity.ok().build();
        }else{
          return ResponseEntity.badRequest().build();
        }
    }
    @RequestMapping(path = "/edytujStudenta/{id_studenta}", method = RequestMethod.POST)
    public ResponseEntity edytujStudenta(@PathVariable(name="id_studenta")Long id,
                                         @RequestBody Student student){
        Optional<Student> studentOptional=studentService.edytujStudenta(id,student);
        if(studentOptional.isPresent()){
            return ResponseEntity.ok(studentOptional.get());
        }
        return ResponseEntity.badRequest().build();
    }
    @RequestMapping(path = "/pobierzStudenta/{id_studenta}", method = RequestMethod.GET)
    public ResponseEntity pobierzStudenta(@PathVariable(name = "id_studenta")Long id){
        return ResponseEntity.ok(studentService.pobierzStudenta(id));
    }
    @RequestMapping(path = "/urodzeni/{rok}", method = RequestMethod.GET)
    public ResponseEntity urodzeni(@PathVariable(name = "rok")String rok){
        return ResponseEntity.ok(studentService.szukajStudenta(rok));
    }



}

