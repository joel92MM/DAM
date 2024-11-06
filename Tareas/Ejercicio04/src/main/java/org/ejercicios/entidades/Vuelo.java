package org.ejercicios.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "VUELOS")
public class Vuelo {

    @Id
    @Column (name = "COD_VUELO")
    private String codVuelo;

    @Column (name = "HORA_SALIDA")
    private Date horaSalida;

    @Column (name = "DESTINO")
    private String destino;

    @Column (name = "PROCEDENCIA")
    private String procedencia;

    @Column (name = "PLAZAS_FUMADOR")
    private Integer plazasFumador;

    @Column (name = "PLAZAS_NO_FUMADOR")
    private Integer plazasNoFumador;

    @Column (name = "PLAZAS_TURISTA")
    private Integer plazasTurista;

    @Column (name = "PLAZAS_PRIMERA")
    private Integer plazasPrimera;



}