package org.clases.ejercicio01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    //definicion de tipos de variables
    private int codigo;
    private String nombre;
    private String direccion;
    private float salario;
    private float comision;

    @Override
    public String toString() {
        return "Empleado: " + nombre + " con codigo "+
                + codigo + ", direccion " + direccion +
                " tiene un salario de " + salario +
                "€ y una comision de " + comision +"€"+'\n';
    }
}
