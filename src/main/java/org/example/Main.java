package com.ejercicio102; // Paquete base donde reside Main

import com.ejercicio102.model.Asignatura;
import com.ejercicio102.model.DobleMaster;
import com.ejercicio102.model.Master;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Creando Escenario para Validación de Doble Máster ---");

        // --- 1. Crear Másteres Simples ---
        Master masterIA = new Master("M-IA", "Máster en Inteligencia Artificial");
        Master masterCD = new Master("M-CD", "Máster en Ciencia de Datos");

        // --- 2. Crear Asignaturas para Master IA ---
        Asignatura ia01 = new Asignatura("IA01", "Intro IA", 1, 6);
        Asignatura ia02 = new Asignatura("IA02", "Aprendizaje Automático", 2, 6);
        Asignatura comunM1 = new Asignatura("COM01", "Estadística Aplicada", 1, 6); // Asignatura común
        masterIA.addAsignatura(ia01);
        masterIA.addAsignatura(ia02);
        masterIA.addAsignatura(comunM1);
        System.out.println("\n> Creado Master: " + masterIA.getNombre());
        masterIA.getAsignaturas().forEach(a -> System.out.println("  -> Añadida: " + a));

        // --- 3. Crear Asignaturas para Master CD ---
        Asignatura cd01 = new Asignatura("CD01", "Fundamentos CD", 1, 6);
        Asignatura cd02 = new Asignatura("CD02", "Visualización", 1, 6);
        Asignatura comunM2 = new Asignatura("COM01", "Estadística Aplicada", 1, 6); // Mismo ID que comunM1
        masterCD.addAsignatura(cd01);
        masterCD.addAsignatura(cd02);
        masterCD.addAsignatura(comunM2);
        System.out.println("\n> Creado Master: " + masterCD.getNombre());
        masterCD.getAsignaturas().forEach(a -> System.out.println("  -> Añadida: " + a));

        // --- 4. Crear el Doble Máster ---
        DobleMaster dobleMaster = new DobleMaster("DM-IA-CD", "Doble Máster IA + CD", masterIA, masterCD);
        System.out.println("\n> Creado Doble Master: " + dobleMaster.getNombre());

        // --- 5. Definir Asignaturas del Doble Máster ---
        // Se seleccionan asignaturas de ambos másteres + una común que las agrupa
        Asignatura dm_ia01 = new Asignatura("IA01", "Intro IA", 1, 6);
        Asignatura dm_ia02 = new Asignatura("IA02", "Aprendizaje Automático", 2, 6);
        Asignatura dm_cd01 = new Asignatura("CD01", "Fundamentos CD", 1, 6);
        Asignatura dm_cd02 = new Asignatura("CD02", "Visualización", 1, 6);
        Asignatura dm_comun = new Asignatura("DM_COM", "Estadística Avanzada para IA/CD", 1, 6); // Cubre COM01 de ambos

        dobleMaster.addAsignatura(dm_ia01);
        dobleMaster.addAsignatura(dm_ia02);
        dobleMaster.addAsignatura(dm_cd01);
        dobleMaster.addAsignatura(dm_cd02);
        dobleMaster.addAsignatura(dm_comun);
        System.out.println("\n> Asignaturas añadidas al Doble Máster:");
        dobleMaster.getAsignaturas().forEach(a -> System.out.println("  -> " + a));

        // --- 6. Establecer Mapeos DM -> Master Simple ---
        System.out.println("\n> Estableciendo Mapeos:");
        try {
            // Mapeos a Master IA
            dobleMaster.addMapeoMaster1(dm_ia01, ia01);
            System.out.println("  Mapeo M1: " + dm_ia01.getId() + " -> " + ia01.getId());
            dobleMaster.addMapeoMaster1(dm_ia02, ia02);
            System.out.println("  Mapeo M1: " + dm_ia02.getId() + " -> " + ia02.getId());
            dobleMaster.addMapeoMaster1(dm_comun, comunM1); // dm_comun cubre comunM1
            System.out.println("  Mapeo M1: " + dm_comun.getId() + " -> " + comunM1.getId());

            // Mapeos a Master CD
            dobleMaster.addMapeoMaster2(dm_cd01, cd01);
            System.out.println("  Mapeo M2: " + dm_cd01.getId() + " -> " + cd01.getId());
            dobleMaster.addMapeoMaster2(dm_cd02, cd02);
            System.out.println("  Mapeo M2: " + dm_cd02.getId() + " -> " + cd02.getId());
            dobleMaster.addMapeoMaster2(dm_comun, comunM2); // dm_comun también cubre comunM2
            System.out.println("  Mapeo M2: " + dm_comun.getId() + " -> " + comunM2.getId());

        } catch (IllegalArgumentException e) {
            System.err.println("Error al añadir mapeo: " + e.getMessage());
        }

        // --- 7. (Opcional) Añadir Convalidaciones ---
        // dobleMaster.addConvalidacion(ia02, algunaAsignaturaDeCD);
        // System.out.println("> Convalidaciones añadidas (si las hubiera).");

        // --- 8. Ejecutar Validación ---
        System.out.println("\n--- Ejecutando Validación ---");
        boolean esValido = dobleMaster.validar();

        System.out.println("\n---------------- RESULTADO ----------------");
        System.out.println("¿El Doble Máster es válido según las reglas?: " + (esValido ? "SÍ" : "NO"));
        System.out.println("-------------------------------------------");

        if (!esValido) {
            System.out.println("\nNOTA: Si la validación falló, revisa los mensajes de error 'FALLO...' impresos arriba.");
        }

        // --- Ejemplo de cómo provocar un fallo (descomentar para probar) ---
        /*
        System.out.println("\n\n--- PROVOCANDO UN FALLO DE PRECISIÓN ---");
        Asignatura asignaturaExtra = new Asignatura("EXTRA01", "Asignatura inventada", 3, 3);
        dobleMaster.addAsignatura(asignaturaExtra); // Añadida a DM pero no mapeada
        System.out.println("> Añadida asignatura extra no mapeada: " + asignaturaExtra.getId());
        System.out.println("\n--- Re-validando ---");
        esValido = dobleMaster.validar();
        System.out.println("\n---------------- RESULTADO (con fallo) ----------------");
        System.out.println("¿El Doble Máster es válido ahora?: " + (esValido ? "SÍ" : "NO"));
        System.out.println("-------------------------------------------------------");
        */
    }
}