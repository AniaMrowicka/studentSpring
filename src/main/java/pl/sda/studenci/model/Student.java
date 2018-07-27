package pl.sda.studenci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String index;

}
