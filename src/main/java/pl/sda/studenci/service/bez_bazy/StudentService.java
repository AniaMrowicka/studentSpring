package pl.sda.studenci.service.bez_bazy;

import org.springframework.stereotype.Service;
import pl.sda.studenci.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    List<Student> listaStudentow = new ArrayList<>();

    public void dodajStudenta(Student student) {
        listaStudentow.add(student);
    }

    public List<Student> listowanie() {
        return listaStudentow;
    }

    public boolean usun(Long id) {
        Optional<Student> studentOptional = znajdzStudentaNaLiscie(id);
        if (studentOptional.isPresent()) {
            listaStudentow.remove(studentOptional.get());
            return true;
        }
        return false;
    }


    public Optional<Student> znajdzStudentaNaLiscie(Long id) {
        for (int i = 0; i < listaStudentow.size(); i++) {
            if (listaStudentow.get(i).getId() == id) {
                return Optional.of(listaStudentow.get(i));
            }
        }
        return Optional.empty();
    }

    public Optional<Student> edytujStudenta(Long id, Student student) {
        Optional<Student> studentOptional = znajdzStudentaNaLiscie(id);
        if (studentOptional.isPresent()) {
            Student doEdycji = studentOptional.get();

            if (student.getImie() != null) {
                doEdycji.setImie(student.getImie());
            }
            if (student.getNazwisko() != null) {
                doEdycji.setNazwisko(student.getNazwisko());
            }
            if (student.getPesel() != null) {
                doEdycji.setPesel(student.getPesel());
            }
            if (student.getIndeks() != null) {
                doEdycji.setIndeks(student.getIndeks());
            }
            return Optional.of(doEdycji);

        }
        return Optional.empty();
    }

    public Optional<Student> pobierzStudenta(Long id) {
        return znajdzStudentaNaLiscie(id);

    }
    public List<Student> szukajStudenta(String rok) {
        List<Student> urodzeniW = new ArrayList<>();
        for (int i = 0; i < listaStudentow.size(); i++) {
            if (listaStudentow.get(i).getPesel().startsWith(rok)) {
                urodzeniW.add(listaStudentow.get(i));
            }
        }
        return urodzeniW;
    }

}
