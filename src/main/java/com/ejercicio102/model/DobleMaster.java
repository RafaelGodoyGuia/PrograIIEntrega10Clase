// Archivo: src/main/java/com/ejercicio102/model/DobleMaster.java
package com.ejercicio102.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Collections;
import java.util.Set;

public class DobleMaster extends Master {
    private final Master master1;
    private final Master master2;
    private final Map<Asignatura, Asignatura> mapeoDmMaster1;
    private final Map<Asignatura, Asignatura> mapeoDmMaster2;
    private final Map<Asignatura, Asignatura> convalidacionesM1M2;

    public DobleMaster(String id, String nombre, Master master1, Master master2) {
        super(id, nombre);
        this.master1 = Objects.requireNonNull(master1, "El Master 1 no puede ser nulo");
        this.master2 = Objects.requireNonNull(master2, "El Master 2 no puede ser nulo");
        if (master1.equals(master2)) { throw new IllegalArgumentException("Los dos másteres simples no pueden ser el mismo."); }
        this.mapeoDmMaster1 = new HashMap<>();
        this.mapeoDmMaster2 = new HashMap<>();
        this.convalidacionesM1M2 = new HashMap<>();
    }
    public Master getMaster1() { return master1; }
    public Master getMaster2() { return master2; }
    public Map<Asignatura, Asignatura> getMapeoDmMaster1() { return Collections.unmodifiableMap(mapeoDmMaster1); }
    public Map<Asignatura, Asignatura> getMapeoDmMaster2() { return Collections.unmodifiableMap(mapeoDmMaster2); }
    public Map<Asignatura, Asignatura> getConvalidacionesM1M2() { return Collections.unmodifiableMap(convalidacionesM1M2); }
    public void addMapeoMaster1(Asignatura asignaturaDM, Asignatura asignaturaM1) {
        Objects.requireNonNull(asignaturaDM); Objects.requireNonNull(asignaturaM1);
        if (!super.getAsignaturas().contains(asignaturaDM)) { throw new IllegalArgumentException("Asignatura " + asignaturaDM.getId() + " no pertenece a DM."); }
        if (!master1.getAsignaturas().contains(asignaturaM1)) { throw new IllegalArgumentException("Asignatura " + asignaturaM1.getId() + " no pertenece a M1."); }
        this.mapeoDmMaster1.put(asignaturaDM, asignaturaM1);
    }
    public void addMapeoMaster2(Asignatura asignaturaDM, Asignatura asignaturaM2) {
        Objects.requireNonNull(asignaturaDM); Objects.requireNonNull(asignaturaM2);
        if (!super.getAsignaturas().contains(asignaturaDM)) { throw new IllegalArgumentException("Asignatura " + asignaturaDM.getId() + " no pertenece a DM."); }
        if (!master2.getAsignaturas().contains(asignaturaM2)) { throw new IllegalArgumentException("Asignatura " + asignaturaM2.getId() + " no pertenece a M2."); }
        this.mapeoDmMaster2.put(asignaturaDM, asignaturaM2);
    }
    public void addConvalidacion(Asignatura asignaturaM1, Asignatura asignaturaM2) {
        Objects.requireNonNull(asignaturaM1); Objects.requireNonNull(asignaturaM2);
        if (!master1.getAsignaturas().contains(asignaturaM1)) { throw new IllegalArgumentException("Asignatura " + asignaturaM1.getId() + " no pertenece a M1."); }
        if (!master2.getAsignaturas().contains(asignaturaM2)) { throw new IllegalArgumentException("Asignatura " + asignaturaM2.getId() + " no pertenece a M2."); }
        this.convalidacionesM1M2.put(asignaturaM1, asignaturaM2);
    }
    public boolean validar() {
        boolean c1 = validarCoberturaM1(), c2 = validarCoberturaM2(), p = validarPrecision(), s = validarSecuenciacion();
        return c1 && c2 && p && s;
    }
    private boolean validarCoberturaM1() { /* ... (código de validación igual que antes) ... */
        Map<Asignatura, Asignatura> inv = new HashMap<>(); for(var e:mapeoDmMaster1.entrySet()) inv.put(e.getValue(),e.getKey());
        for(var a:master1.getAsignaturas()){ if(!super.getAsignaturas().contains(a) && !inv.containsKey(a)) { System.err.println("F C1:"+a.getId()); return false;}} return true;
    }
    private boolean validarCoberturaM2() { /* ... (código de validación igual que antes) ... */
        Map<Asignatura, Asignatura> inv = new HashMap<>(); for(var e:mapeoDmMaster2.entrySet()) inv.put(e.getValue(),e.getKey());
        for(var a:master2.getAsignaturas()){ if(!super.getAsignaturas().contains(a) && !inv.containsKey(a)) { System.err.println("F C2:"+a.getId()); return false;}} return true;
    }
    private boolean validarPrecision() { /* ... (código de validación igual que antes) ... */
        for(var a:super.getAsignaturas()){ if(!mapeoDmMaster1.containsKey(a) && !mapeoDmMaster2.containsKey(a)) { System.err.println("F P:"+a.getId()); return false;}} return true;
    }
    private boolean validarSecuenciacion() { /* ... (código de validación igual que antes) ... */
        for(var e:mapeoDmMaster1.entrySet()){ if(e.getKey().getSemestre()!=e.getValue().getSemestre()){ System.err.println("F S1:"+e.getKey().getId()); return false;}}
        for(var e:mapeoDmMaster2.entrySet()){ if(e.getKey().getSemestre()!=e.getValue().getSemestre()){ System.err.println("F S2:"+e.getKey().getId()); return false;}} return true;
    }
    @Override public String toString() { /* ... (código toString igual que antes) ... */
        return "DobleMaster{id='"+getId()+"', n='"+getNombre()+"', Asig="+getAsignaturas().size()+" M1="+master1.getNombre()+" M2="+master2.getNombre()+"}";
    }
}