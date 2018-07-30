package pl.sda.studenci.service.bez_bazy;

import org.springframework.stereotype.Service;
import pl.sda.studenci.model.Dziennik;
import pl.sda.studenci.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DziennikService {

    List<Dziennik> listaDziennikow = new ArrayList<>();

    public void dodajDziennik(Dziennik dziennik) {
        listaDziennikow.add(dziennik);
    }

    public Optional<Dziennik> znajdzDziennikNaLiscie(Long id) {
        for (int i = 0; i < listaDziennikow.size(); i++) {
            if (listaDziennikow.get(i).getId().equals(id)) {
                return Optional.of(listaDziennikow.get(i));
            }
        }
        return Optional.empty();
    }

    public Optional<Dziennik> edytujDziennik(Long id, Dziennik dziennik) {
        Optional<Dziennik> dziennikOptional = znajdzDziennikNaLiscie(id);
        if (dziennikOptional.isPresent()) {
            Dziennik doEdycji = dziennikOptional.get();

            if (dziennik.getNazwiskoWychowawcy() != null) {
                doEdycji.setNazwiskoWychowawcy(dziennik.getNazwiskoWychowawcy());
            }
            if (dziennik.getRocznik() != null) {
                doEdycji.setRocznik(dziennik.getRocznik());
            }
            if (dziennik.getNazwaKlasy() != null) {
                doEdycji.setNazwaKlasy(dziennik.getNazwaKlasy());
            }
            if (dziennik.getNazwaSzkoly() != null) {
                doEdycji.setNazwaSzkoly(dziennik.getNazwaSzkoly());
            }
            return Optional.of(doEdycji);

        }
        return Optional.empty();
    }

    public boolean usun(Long id) {
        Optional<Dziennik> dziennikOptional = znajdzDziennikNaLiscie(id);
        if (dziennikOptional.isPresent()) {
            listaDziennikow.remove(dziennikOptional.get());
            return true;
        }
        return false;
    }

    public List<Dziennik> listowanie() {
        return listaDziennikow;
    }

    public Optional<Dziennik> pobierzDziennik(Long id) {
        return znajdzDziennikNaLiscie(id);
    }

    public void dodajStudentaDoDziennika() {



    }
}
