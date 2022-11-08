package de.tekup.locationappb.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonIdentityInfo(property = "model",generator = ObjectIdGenerators.PropertyGenerator.class)
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serie;

    private LocalDate dateDeMiseEnMarche;

    private String model;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

    public Voiture(String serie, LocalDate dateDeMiseEnMarche, String model) {
        this.serie = serie;
        this.dateDeMiseEnMarche = dateDeMiseEnMarche;
        this.model = model;
    }
}
