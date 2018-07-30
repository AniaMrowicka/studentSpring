package pl.sda.studenci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.studenci.model.Student;
import pl.sda.studenci.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceBD {


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> pobierzListeStudentow(){
        return studentRepository.findAll();
    }
    public Student zapiszStudenta (Student student){
        student= studentRepository.save(student);
        return student;
    }

    public Optional<Student> znajdzPoId (Long id){
       return studentRepository.findById(id) ;
    }
    public boolean usunStudenta(Long id){
        if (studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Student> szukajPoPeselu(String pesel) {
        return studentRepository.findByPesel(pesel);
    }
}
