// Archivo: src/test/java/com/ejercicio102/test/DobleMasterTest.java

import com.ejercicio102.model.Asignatura;
import com.ejercicio102.model.DobleMaster;
import com.ejercicio102.model.Master;

// !! Importante: Estas líneas darán error ahora mismo !!
// Se solucionará después de configurar el pom.xml
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DobleMasterTest {

    Master m1, m2;
    DobleMaster dm;
    Asignatura aM1_1, aM1_2, aM1_3;
    Asignatura aM2_1, aM2_2, aM2_3;
    Asignatura aDM_1, aDM_2, aDM_3, aDM_4, aDM_5;

    @BeforeEach
    void setUp() {
        m1 = new Master("M001", "Master en IA");
        m2 = new Master("M002", "Master en Ciencia de Datos");
        dm = new DobleMaster("DM001", "Doble Master IA + CD", m1, m2);

        aM1_1 = new Asignatura("IA01", "Introducción IA", 1, 6);
        aM1_2 = new Asignatura("IA02", "Aprendizaje Automático", 2, 6);
        aM1_3 = new Asignatura("IA03", "Procesamiento Lenguaje Natural", 2, 6);
        m1.addAsignatura(aM1_1); m1.addAsignatura(aM1_2); m1.addAsignatura(aM1_3);

        aM2_1 = new Asignatura("CD01", "Fundamentos CD", 1, 6);
        aM2_2 = new Asignatura("CD02", "Visualización Datos", 1, 6);
        aM2_3 = new Asignatura("CD03", "Big Data", 2, 6);
        m2.addAsignatura(aM2_1); m2.addAsignatura(aM2_2); m2.addAsignatura(aM2_3);

        aDM_1 = new Asignatura("IA01", "Introducción IA", 1, 6);
        aDM_2 = new Asignatura("IA02", "Aprendizaje Automático", 2, 6);
        aDM_3 = new Asignatura("CD01", "Fundamentos CD", 1, 6);
        aDM_4 = new Asignatura("CD03", "Big Data", 2, 6);
        aDM_5 = new Asignatura("DM01", "Proyecto Integrado", 3, 12);

        dm.addAsignatura(aDM_1); dm.addAsignatura(aDM_2);
        dm.addAsignatura(aDM_3); dm.addAsignatura(aDM_4);
    }

    // --- PEGA AQUÍ TODOS LOS MÉTODOS @Test ---
    // (Los métodos de prueba son idénticos a los de la respuesta anterior)
    @Test void validar_CoberturaM1_DirectaYPorMapeo_Ok() { /* ... código test ... */ }
    @Test void validar_CoberturaM1_Falla() { /* ... código test ... */ }
    @Test void validar_CoberturaM2_Falla() { /* ... código test ... */ }
    @Test void validar_Precision_Falla() { /* ... código test ... */ }
    @Test void validar_Precision_Ok() { /* ... código test ... */ }
    @Test void validar_Secuenciacion_FallaM1() { /* ... código test ... */ }
    @Test void validar_Secuenciacion_FallaM2() { /* ... código test ... */ }
    @Test void validar_Secuenciacion_Ok() { /* ... código test ... */ }
    @Test void validar_Completo_Ok() { /* ... código test ... */ }
}