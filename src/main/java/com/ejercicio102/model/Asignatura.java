package com.ejercicio102.model;

import java.util.Objects;

public class Asignatura {
    private final String id;
    private final String nombre;
    private final int semestre;
    private final int creditosECTS;

    public Asignatura(String id, String nombre, int semestre, int creditosECTS) {
        this.id = Objects.requireNonNull(id, "El ID de la asignatura no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre de la asignatura no puede ser nulo");
        if (semestre <= 0) { throw new IllegalArgumentException("El semestre debe ser positivo."); }
        this.semestre = semestre;
        if (creditosECTS <= 0) { throw new IllegalArgumentException("Los créditos ECTS deben ser positivos."); }
        this.creditosECTS = creditosECTS;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getSemestre() { return semestre; }
    public int getCreditosECTS() { return creditosECTS; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(id, that.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
    @Override public String toString() { return "Asignatura{id='" + id + "', nombre='" + nombre + "', semestre=" + semestre + ", creditosECTS=" + creditosECTS + '}'; }
}