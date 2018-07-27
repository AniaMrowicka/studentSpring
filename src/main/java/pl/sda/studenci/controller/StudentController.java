package pl.sda.studenci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.sda.studenci.model.Student;
import pl.sda.studenci.service.StudentService;

@RestController
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



}

