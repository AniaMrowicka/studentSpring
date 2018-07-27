package pl.sda.studenci.service;

import org.springframework.stereotype.Service;
import pl.sda.studenci.model.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> listaStudentow = new ArrayList<>();

    public void dodajStudenta(Student student){
        listaStudentow.add(student);
    }
    public List<Student> listowanie(){
        return listaStudentow;
    }
    public boolean usun(Long id){
        for (int i = 0; i < listaStudentow.size(); i++) {
            if (listaStudentow.get(i).getId() == id){
                listaStudentow.remove(listaStudentow.get(i));
                return true;
            }
        }
        return false;
    }
}
