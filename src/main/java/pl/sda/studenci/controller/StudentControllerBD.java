package pl.sda.studenci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.studenci.model.Student;
import pl.sda.studenci.service.StudentServiceBD;

import javax.xml.ws.Response;
import java.util.Optional;

@RestController
public class StudentControllerBD {

    @Autowired
    private StudentServiceBD studentServiceBD;

    @GetMapping(path = "/listaStudentow")
    public ResponseEntity listaStudentow(){
        return ResponseEntity.ok(studentServiceBD.pobierzListeStudentow());
    }
    @RequestMapping(path = "/dodawanie", method = RequestMethod.POST)
    public ResponseEntity dodawanie (@RequestBody Student student){
        return ResponseEntity.ok(studentServiceBD.zapiszStudenta(student));
    }
    @GetMapping (path = "/usunStudenta/{id_studenta}")
    public ResponseEntity usuwanieStudenta (@PathVariable (name="id_studenta")Long id){
        boolean sukces= studentServiceBD.usunStudenta(id);
        if(sukces){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping(path = "/szukajPoPeselu")
    public ResponseEntity szukajPoPeselu (@RequestParam(name = "pesel")String pesel){
        Optional<Student> szukanyStudent= studentServiceBD.szukajPoPeselu(pesel);
        if (szukanyStudent.isPresent()){
            return ResponseEntity.ok(szukanyStudent.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
