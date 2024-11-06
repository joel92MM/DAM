package org.ejercicios.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "PASAJEROS")
public class Pasajero   {

    @Id
    @Column (name = "NUM")
    private int num;

    @JoinColumn(name = "COD_VUELO", referencedColumnName = "COD_VUELO")
    private String codVuelo;

    @Column (name = "TIPO_PLAZA")
    private String tipoPlaza;

    @Column (name = "FUMADOR")
    private String fumador;

}