package pl.sda.studenci.controller.bez_bazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.studenci.model.Dziennik;
import pl.sda.studenci.service.bez_bazy.DziennikService;

import java.util.Optional;

@RestController
public class DziennikController {


    @Autowired
    private DziennikService dziennikService;


    @RequestMapping(path = "/dodajDziennik", method = RequestMethod.POST)
    public ResponseEntity dodajDziennik(@RequestBody Dziennik dziennik) {
        dziennikService.dodajDziennik(dziennik);
        return ResponseEntity.ok(dziennik);
    }

    @GetMapping(path = "/listowanie")
    public ResponseEntity listowanie() {
        return ResponseEntity.ok(dziennikService.listowanie());

    }

    @GetMapping(path = "/usunDziennik/{idDziennika}")
    public ResponseEntity usun(@PathVariable(name = "idDziennika") Long id) {
        boolean usun = dziennikService.usun(id);
        if (usun) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(path = "/edytujDziennik/{idDziennika}", method = RequestMethod.POST)
    public ResponseEntity edytujDziennik(@PathVariable(name = "idDziennika") Long id,
                                         @RequestBody Dziennik dziennik) {
        Optional<Dziennik> dziennikOptional = dziennikService.edytujDziennik(id, dziennik);
        if (dziennikOptional.isPresent()) {
            return ResponseEntity.ok(dziennikOptional.get());
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping(path = "/pobierz/{idDziennika}")
    public ResponseEntity pobierzDziennik(@PathVariable(name= "idDziennika") Long id){
        return ResponseEntity.ok(dziennikService.pobierzDziennik(id));
    }
//    @RequestMapping(path = "/dodajStudentaDoDziennika/{idDziennika}/{idStudenta}", method = RequestMethod.POST)
//    public ResponseEntity dodajStudentaDoDziennika(@PathVariable(name="idDziennika")Long idDziennik,
//      @PathVariable  (name="idDziennika")Long idStudent){
//        return ResponseEntity.ok(dziennikService.dodajStudentaDoDziennika())
//    }                                         )
}
