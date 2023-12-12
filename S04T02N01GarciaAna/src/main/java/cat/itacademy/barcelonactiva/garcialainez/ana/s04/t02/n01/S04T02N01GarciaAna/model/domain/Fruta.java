package cat.itacademy.barcelonactiva.garcialainez.ana.s04.t02.n01.S04T02N01GarciaAna.model.domain;

import jakarta.persistence.*;


@Entity
@Table(name="fruta")
public class Fruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cantidadKilos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(int cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }
}

/* @Id ---indica que es PK
   @GeneratedValue(strategy = GenerationType.IDENTITY) --indica que se genere automaticamente el valor
*/
