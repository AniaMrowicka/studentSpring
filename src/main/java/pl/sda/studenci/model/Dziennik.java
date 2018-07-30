package pl.sda.studenci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dziennik {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Student> listaUczniow;
    private String nazwaKlasy;
    private String nazwaSzkoly;
    private String rocznik;
    private String nazwiskoWychowawcy;


}
