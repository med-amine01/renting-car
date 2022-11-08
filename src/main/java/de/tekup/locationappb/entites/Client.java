package de.tekup.locationappb.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false,length = 8)
    private String cin;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;

    private String adresse;
    @OneToMany(mappedBy = "client")
    private List<Location> locations;
}
