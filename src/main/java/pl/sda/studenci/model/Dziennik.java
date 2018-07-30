package pl.sda.studenci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dziennik {
    private Long id;
    private List<Student> listaUczniow;
    private String nazwaKlasy;
    private String nazwaSzkoly;
    private String rocznik;
    private String nazwiskoWychowawcy;


}
