package com.ejercicio102.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Collections;

public class Master {
    private final String id;
    private final String nombre;
    private final Set<Asignatura> asignaturas;

    public Master(String id, String nombre) {
        this.id = Objects.requireNonNull(id, "El ID del máster no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre del máster no puede ser nulo");
        this.asignaturas = new HashSet<>();
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public Set<Asignatura> getAsignaturas() { return Collections.unmodifiableSet(asignaturas); }
    public boolean addAsignatura(Asignatura asignatura) { return this.asignaturas.add(Objects.requireNonNull(asignatura, "La asignatura no puede ser nula")); }
    public boolean removeAsignatura(Asignatura asignatura) { return this.asignaturas.remove(asignatura); }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return Objects.equals(id, master.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
    @Override public String toString() { return "Master{id='" + id + "', nombre='" + nombre + "', numAsignaturas=" + asignaturas.size() + '}'; }
}