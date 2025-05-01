# PrograIIEntrega10Clase

# Ejercicio 93. Definiciones y Aplicaciones de Árboles

**Árbol (Tree):**

*   Un árbol es una estructura de datos **no lineal** y **jerárquica** que consiste en un conjunto de elementos llamados **nodos** conectados por **aristas** (o enlaces).
*   Características principales:
    *   Hay un nodo especial llamado **raíz (root)**, que no tiene padre.
    *   Cada nodo (excepto la raíz) tiene exactamente un **nodo padre**.
    *   Un nodo puede tener cero o más **nodos hijos**.
    *   Los nodos sin hijos se llaman **hojas (leaves)**.
    *   No existen **ciclos** (un camino que empiece y termine en el mismo nodo sin repetir aristas).
*   Representa relaciones jerárquicas entre los elementos.

**Árbol Binario (Binary Tree):**

*   Un árbol binario es un tipo particular de árbol donde cada nodo tiene **como máximo dos hijos**.
*   Estos hijos se distinguen como **hijo izquierdo (left child)** e **hijo derecho (right child)**.
*   Un nodo puede tener cero hijos, un hijo izquierdo, un hijo derecho, o ambos.
*   Un caso especial importante es el **Árbol Binario de Búsqueda (Binary Search Tree - BST)**, donde para cada nodo, todos los valores en su subárbol izquierdo son menores o iguales al valor del nodo, y todos los valores en su subárbol derecho son mayores que el valor del nodo.

**Aplicaciones:**

*   **Árboles (Generales):**
    *   Representación de estructuras jerárquicas: sistemas de archivos (directorios y archivos), organigramas de empresas, árbol genealógico.
    *   Estructura del DOM (Document Object Model) en HTML y XML.
    *   Árboles de decisión en inteligencia artificial y aprendizaje automático.
    *   Estructuras de datos para indexación en bases de datos.
*   **Árboles Binarios:**
    *   **Árboles Binarios de Búsqueda (BST):** Implementación eficiente de operaciones de búsqueda, inserción y eliminación (promedio O(log n)). Usados en diccionarios, conjuntos, tablas de símbolos.
    *   **Montículos Binarios (Binary Heaps):** Implementación eficiente de colas de prioridad. Usados en algoritmos como Heapsort.
    *   **Árboles de Expresión:** Representación de expresiones matemáticas o lógicas. Útiles en compiladores para analizar y evaluar expresiones.
    *   **Árboles de Huffman:** Utilizados en algoritmos de compresión de datos (como .zip).
    *   Estructuras de datos espaciales como los árboles BSP (Binary Space Partitioning) en gráficos por computadora.

# Ejercicio 94. Simulación de Inserción en Árbol Binario (de Búsqueda)

Simularemos la inserción de los elementos `2, 1, 3, 8, 5, 2` en un árbol binario de búsqueda vacío, siguiendo la regla: si el valor a insertar es menor o igual al nodo actual, va a la izquierda; si es mayor, va a la derecha.

1.  **Insertar 2:** El árbol está vacío. `2` se convierte en la raíz.
    ```
      2
    ```
2.  **Insertar 1:** `1 <= 2`. Va a la izquierda de `2`.
    ```
      2
     /
    1
    ```
3.  **Insertar 3:** `3 > 2`. Va a la derecha de `2`.
    ```
      2
     / \
    1   3
    ```
4.  **Insertar 8:** `8 > 2`. Va a la derecha de `2` (nodo `3`). `8 > 3`. Va a la derecha de `3`.
    ```
      2
     / \
    1   3
         \
          8
    ```
5.  **Insertar 5:** `5 > 2`. Va a la derecha de `2` (nodo `3`). `5 > 3`. Va a la derecha de `3` (nodo `8`). `5 < 8`. Va a la izquierda de `8`.
    ```
      2
     / \
    1   3
         \
          8
         /
        5
    ```
6.  **Insertar 2:** `2 <= 2`. Va a la izquierda de `2` (nodo `1`). `2 > 1`. Va a la derecha de `1`.
    ```
      2
     / \
    1   3
     \   \
      2   8
         /
        5
    ```

**El árbol final resultante es:**
```
  2 (Raíz)
 / \
1   3
 \   \
  2   8
     /
    5
```


# Ejercicio 95. Reglas para Borrar un Elemento de un Árbol Binario (de Búsqueda)

Para borrar un nodo `N` con un valor específico de un Árbol Binario de Búsqueda (BST), se siguen estas reglas dependiendo de cuántos hijos tenga `N`:

1.  **Caso 1: El nodo a borrar (`N`) es una hoja (no tiene hijos).**
    *   Simplemente se elimina el nodo.
    *   Se establece el puntero del padre que apuntaba a `N` a `null`.

2.  **Caso 2: El nodo a borrar (`N`) tiene un solo hijo.**
    *   Se reemplaza el nodo `N` con su único hijo.
    *   Se actualiza el puntero del padre de `N` para que apunte directamente al hijo de `N`.

3.  **Caso 3: El nodo a borrar (`N`) tiene dos hijos.**
    *   Este es el caso más complejo. Se necesita encontrar un nodo para reemplazar a `N` que mantenga la propiedad del BST. Hay dos opciones comunes:
        *   **Opción A: Encontrar el sucesor inorden de `N`:** Es el nodo con el valor más pequeño en el subárbol derecho de `N`. (Se encuentra yendo al hijo derecho y luego todo a la izquierda hasta encontrar un nodo sin hijo izquierdo).
        *   **Opción B: Encontrar el predecesor inorden de `N`:** Es el nodo con el valor más grande en el subárbol izquierdo de `N`. (Se encuentra yendo al hijo izquierdo y luego todo a la derecha hasta encontrar un nodo sin hijo derecho).
    *   **Pasos (usando la Opción A - Sucesor Inorden):**
        1.  Encuentra el nodo sucesor inorden (`S`) en el subárbol derecho de `N`.
        2.  Copia el valor (dato) del sucesor `S` al nodo `N`.
        3.  Borra recursivamente el nodo sucesor `S` de su posición original en el subárbol derecho. (Importante: el nodo `S`, por definición, tendrá como máximo un hijo - el derecho -, por lo que su borrado caerá en el Caso 1 o Caso 2, que son más simples).

# Ejercicio 96. Análisis del Código Java

## 1. Resultado del método `mostrarFuncionamientoArbolesBinarios` y Estructura del Árbol

El método `mostrarFuncionamientoArbolesBinarios` realiza las siguientes inserciones: `2, 1, 3, 8, 5, 2`. La estructura final del árbol resultante es la misma que se calculó en el Ejercicio 94:
```
  2
 / \
1   3
 \   \
  2   8
     /
    5
```


El método luego ejecuta dos operaciones de impresión:

1.  **`System.out.println(bt);`**: Esto invoca el método `toString()` de la clase `BinaryTree`. El método `toString()` implementa un **recorrido inorden (inorder)** (Izquierda - Nodo - Derecha).
    *   Recorrido: 1 -> 2 (hijo derecho de 1) -> 2 (raíz) -> 3 -> 5 -> 8
    *   **Salida de `println(bt)`:** (Nótese los espacios añadidos por `StringBuilder`)
        ```
         1  2  2  3  5  8 
        ```

2.  **`bt.printPostorder();`**: Este método implementa un **recorrido postorden (postorder)** (Izquierda - Derecha - Nodo).
    *   Recorrido: 2 (hijo derecho de 1) -> 1 -> 5 -> 8 -> 3 -> 2 (raíz)
    *   **Salida de `printPostorder()`:**
        ```
        2 1 5 8 3 2 
        ```
        (Seguido de una nueva línea impresa por `System.out.println()` dentro de `printPostorder()`).

## 2. Análisis de Complejidad Temporal Asintótica

Sea `n` el número de nodos en el árbol y `h` la altura del árbol.
*   En el **mejor caso** (árbol balanceado), `h = O(log n)`.
*   En el **peor caso** (árbol degenerado, como una lista enlazada), `h = O(n)`.
*   En el **caso promedio** (para inserciones aleatorias), `h = O(log n)`.

Análisis de los métodos públicos:

*   **`public void BinaryTree()` (Constructor):**
    *   Simplemente asigna `root = null`.
    *   Complejidad: **O(1)** (Constante).

*   **`public boolean lookup(int data)`:**
    *   Busca un elemento recorriendo un camino desde la raíz hasta una hoja (o hasta encontrar el elemento). La longitud del camino está limitada por la altura del árbol.
    *   Complejidad: **O(h)**.
        *   Peor caso: O(n).
        *   Caso promedio/mejor: O(log n).

*   **`public void insert(int data)`:**
    *   Similar a `lookup`, recorre un camino desde la raíz hasta encontrar la posición de inserción (un nodo `null`). La longitud del camino está limitada por la altura.
    *   Complejidad: **O(h)**.
        *   Peor caso: O(n).
        *   Caso promedio/mejor: O(log n).

*   **`public int size()`:**
    *   Utiliza un helper recursivo `size(Node node)` que visita cada nodo del árbol exactamente una vez para contarlos.
    *   Complejidad: **O(n)** (Debe visitar todos los nodos).

*   **`public int maxDepth()`:**
    *   Utiliza un helper recursivo `maxDepth(Node node)` que visita cada nodo del árbol exactamente una vez para calcular la profundidad máxima. Las llamadas recursivas `maxDepth(node.left)` y `maxDepth(node.right)` aseguran que todos los nodos son visitados.
    *   Complejidad: **O(n)** (Debe visitar todos los nodos).

*   **`public int minValue()`:**
    *   Utiliza un helper `minValue(Node node)` que itera desde la raíz (o un nodo dado) siempre hacia la izquierda hasta encontrar el nodo más a la izquierda. La longitud del camino está limitada por la altura.
    *   Complejidad: **O(h)**.
        *   Peor caso: O(n).
        *   Caso promedio/mejor: O(log n).

*   **`@Override public String toString()`:**
    *   Utiliza un helper recursivo `aStringBuilder(Node node)` que realiza un recorrido inorden, visitando cada nodo exactamente una vez. La concatenación con `StringBuilder` es eficiente (generalmente O(1) amortizado por append).
    *   Complejidad: **O(n)** (Debe visitar todos los nodos para construir el string).

*   **`@Override public boolean equals(Object other)`:**
    *   Utiliza un helper recursivo `sameTree(Node a, Node b)` que compara dos árboles nodo por nodo. En el peor caso (árboles idénticos o diferencia muy profunda), visita todos los nodos del árbol más pequeño. Si `n` y `m` son los tamaños de los dos árboles.
    *   Complejidad: **O(min(n, m))**.

*   **`public void printPostorder()`:**
    *   Utiliza un helper recursivo `printPostorder(Node node)` que realiza un recorrido postorden, visitando cada nodo exactamente una vez para imprimirlo.
    *   Complejidad: **O(n)** (Debe visitar todos los nodos).
    *
# Ejercicio 97. Árbol Rojo-Negro: Definición y Propiedades

**Definición:**

Un **árbol rojo-negro (Red-Black Tree)** es un tipo de **árbol binario de búsqueda auto-balanceable**. Utiliza una propiedad adicional almacenada en cada nodo, el "color" (rojo o negro), para asegurar que el árbol permanezca aproximadamente balanceado durante las operaciones de inserción y eliminación. El objetivo principal es garantizar que las operaciones básicas (búsqueda, inserción, eliminación) mantengan una complejidad temporal en el **peor caso de O(log n)**, donde 'n' es el número de nodos, evitando la degeneración a O(n) que puede ocurrir en árboles binarios de búsqueda simples.

**Propiedades:**

Un árbol binario de búsqueda es un árbol rojo-negro si satisface las siguientes propiedades:

1.  **Propiedad de Color:** Cada nodo es o bien **rojo** o bien **negro**.
2.  **Propiedad de Raíz:** La raíz del árbol es siempre **negra**.
3.  **Propiedad de Hojas:** Todas las hojas (nodos externos o NIL / NULL) son consideradas **negras**. (En muchas implementaciones, no se almacenan explícitamente, pero las reglas operan como si existieran y fueran negras).
4.  **Propiedad Roja:** Si un nodo es **rojo**, entonces ambos de sus hijos deben ser **negros**. (Esto implica que no puede haber dos nodos rojos consecutivos en un camino simple descendente desde la raíz hasta una hoja).
5.  **Propiedad Negra (o de Profundidad Negra):** Para cada nodo, todos los caminos simples desde ese nodo hasta las hojas descendientes (NIL) deben contener el **mismo número de nodos negros**. Este número se conoce como la "altura negra" (black-height) del nodo.

Estas propiedades, en conjunto, aseguran que el camino más largo desde la raíz hasta una hoja no es más del doble de largo que el camino más corto, manteniendo así el balance y la eficiencia logarítmica.

# Ejercicio 98. Inserción en un Árbol Rojo-Negro (Ejemplos)

La inserción en un árbol rojo-negro sigue dos fases principales:

1.  **Inserción Estándar BST:** Se inserta el nuevo nodo como en un árbol binario de búsqueda normal.
2.  **Coloración Inicial y Rebalanceo:**
    *   El nuevo nodo se colorea siempre de **ROJO**.
    *   Si esta inserción viola alguna de las propiedades del árbol rojo-negro (específicamente la Propiedad 2 si el nuevo nodo es la raíz, o la Propiedad 4 si el padre del nuevo nodo también es rojo), se realizan operaciones de **recoloración** y/o **rotaciones** (izquierda o derecha) para restaurar las propiedades.

**Proceso de Rebalanceo (Fixup):**

El rebalanceo se centra en el nuevo nodo insertado (`z`), que es rojo. Si su padre (`p`) también es rojo, tenemos una violación de la Propiedad 4 ("rojo-rojo"). El proceso depende del color del **tío** de `z` (el hermano del padre `p`). Sea `g` el abuelo de `z`.

*   **Caso 1: `z` es la raíz.**
    *   **Violación:** Propiedad 2 (Raíz debe ser negra).
    *   **Solución:** Colorear `z` de NEGRO.

*   **Caso 2: El padre `p` de `z` es NEGRO.**
    *   **Violación:** Ninguna. El árbol sigue siendo válido.
    *   **Solución:** No se hace nada.

*   **Caso 3: El padre `p` de `z` es ROJO.** (Implica que el abuelo `g` debe ser NEGRO, por la Propiedad 4 antes de la inserción).
    *   **Violación:** Propiedad 4 (Padre e hijo rojos).
    *   **Se necesita verificar el color del tío `u` de `z`:**
        *   **Subcaso 3.1: El tío `u` es ROJO.**
            *   **Solución:**
                1.  Colorear el padre `p` de NEGRO.
                2.  Colorear el tío `u` de NEGRO.
                3.  Colorear el abuelo `g` de ROJO.
                4.  Ahora, el abuelo `g` (que es rojo) podría tener un padre rojo. Se repite el proceso de fixup considerando `g` como el nuevo `z`.
        *   **Subcaso 3.2: El tío `u` es NEGRO (o NIL/Hoja).**
            *   **Solución:** Requiere **rotaciones** y recoloraciones. Depende de si `z` es hijo izquierdo/derecho y si `p` es hijo izquierdo/derecho de `g`. Hay 4 sub-subcasos, pero se reducen a dos patrones básicos después de una posible rotación inicial:
                *   **Patrón "Zig-Zag" (LR o RL):** Si `z` es hijo derecho y `p` es hijo izquierdo (LR), o si `z` es hijo izquierdo y `p` es hijo derecho (RL).
                    1.  Realizar una rotación en el padre `p` que convierte el patrón en "Zig-Zig". (Rotación izquierda en `p` para LR, rotación derecha en `p` para RL). `z` toma el lugar de `p`.
                    2.  Proceder como en el caso "Zig-Zig" con el nuevo `z`.
                *   **Patrón "Zig-Zig" (LL o RR):** Si `z` y `p` son ambos hijos izquierdos (LL), o ambos hijos derechos (RR).
                    1.  Colorear el padre `p` de NEGRO.
                    2.  Colorear el abuelo `g` de ROJO.
                    3.  Realizar una rotación en el abuelo `g`. (Rotación derecha para LL, rotación izquierda para RR).
                    4.  Después de esta rotación y recoloración, la violación local se resuelve y el árbol cumple las propiedades.

**Ejemplos:**

*(Usaremos (N) para indicar el valor del nodo, y (B) o (R) para su color. Las hojas NIL son siempre negras)*

**Ejemplo 1: Ilustrando Caso 3.1 (Tío Rojo)**

Secuencia de inserción: 10, 5, 15, 3

1.  **Insertar 10:**
    *   Se inserta 10. Se colorea ROJO.
    *   `10(R)`
    *   **Fixup (Caso 1):** La raíz es roja. Se colorea NEGRA.
    *   Árbol: `10(B)`

2.  **Insertar 5:**
    *   Se inserta 5 a la izquierda de 10. Se colorea ROJO.
    *   `10(B) / 5(R)`
    *   **Fixup (Caso 2):** Padre (10) es negro. No hay violación.
    *   Árbol: `10(B) / 5(R)`

3.  **Insertar 15:**
    *   Se inserta 15 a la derecha de 10. Se colorea ROJO.
    *   `10(B) / \ 5(R) 15(R)`
    *   **Fixup (Caso 2):** Padre (10) es negro. No hay violación.
    *   Árbol: `10(B) / \ 5(R) 15(R)`

4.  **Insertar 3:**
    *   Se inserta 3 a la izquierda de 5. Se colorea ROJO. `z=3(R)`, `p=5(R)`, `g=10(B)`.
    *   Árbol temporal:
        ```
          10(B)
         /  \
        5(R) 15(R)
    /
    3(R)
    ```
    *   **Fixup (Caso 3):** Padre `p=5` es ROJO. Abuelo `g=10` es NEGRO. ¡Violación rojo-rojo!
    *   **Verificar Tío:** Tío `u` (hermano de `p=5`) es `15`. `u=15` es ROJO.
    *   **Aplicar Subcaso 3.1 (Tío Rojo):**
        1.  Colorear padre `p=5` NEGRO.
        2.  Colorear tío `u=15` NEGRO.
        3.  Colorear abuelo `g=10` ROJO.
        ```
          10(R)  <-- Ahora este es el nuevo 'z' para el fixup
         /  \
        5(B) 15(B)
    /
    3(R)
    ```
    *   **Continuar Fixup:** El nuevo `z` es `10(R)`. Es la raíz.
    *   **Aplicar Caso 1:** Colorear la raíz `10` NEGRA.
    *   **Árbol Final:**
        ```
          10(B)
         /  \
        5(B) 15(B)
    /
    3(R)
    ```

**Ejemplo 2: Ilustrando Caso 3.2 (Tío Negro y Rotación)**

Secuencia de inserción: 10, 20, 30

1.  **Insertar 10:** `10(R)` -> Fixup Caso 1 -> `10(B)`
    *   Árbol: `10(B)`

2.  **Insertar 20:**
    *   Insertar 20 a la derecha de 10. Colorear ROJO. `z=20(R)`, `p=10(B)`.
    *   `10(B) \ 20(R)`
    *   **Fixup (Caso 2):** Padre es negro. No hay violación.
    *   Árbol: `10(B) \ 20(R)`

3.  **Insertar 30:**
    *   Insertar 30 a la derecha de 20. Colorear ROJO. `z=30(R)`, `p=20(R)`, `g=10(B)`.
    *   Árbol temporal:
        ```
        10(B)
          \
          20(R)
            \
            30(R)
        ```
    *   **Fixup (Caso 3):** Padre `p=20` es ROJO. Abuelo `g=10` es NEGRO. ¡Violación rojo-rojo!
    *   **Verificar Tío:** Tío `u` (hermano de `p=20`, hijo izquierdo de `g=10`) es NIL (Hoja). Tío es NEGRO.
    *   **Aplicar Subcaso 3.2 (Tío Negro):**
        *   Patrón: `z=30` es hijo derecho, `p=20` es hijo derecho. Es un patrón "Zig-Zig" (RR).
        *   **Solución (RR):**
            1.  Colorear padre `p=20` NEGRO.
            2.  Colorear abuelo `g=10` ROJO.
            3.  Realizar Rotación Izquierda en el abuelo `g=10`.
        *   **Antes de rotar (con colores nuevos):**
            ```
            10(R) <-- g
              \
              20(B) <-- p
                \
                30(R) <-- z (no cambia color en este paso)
            ```
        *   **Después de Rotación Izquierda en 10:** El nodo `20` sube, `10` baja a la izquierda.
            ```
              20(B)  <-- Nueva raíz local
             /  \
            10(R) 30(R) 
            ```
    *   **Fixup Terminado:** La violación local se resolvió. La raíz del subárbol ahora es negra.
    *   **Árbol Final:**
        ```
          20(B)
         /  \
        10(R) 30(R) 
        ```

Estos ejemplos muestran cómo las recoloraciones y rotaciones trabajan juntas para mantener las propiedades del árbol rojo-negro después de una inserción, asegurando el balance.

# Ejercicio 99. Borrado de un Nodo Rojo en Árbol Rojo-Negro

El borrado de un nodo en un árbol rojo-negro sigue inicialmente el procedimiento estándar de borrado de un Árbol Binario de Búsqueda (BST). Este proceso puede implicar la eliminación directa del nodo (si tiene 0 o 1 hijo) o la sustitución de su contenido por el de su sucesor inorden y luego la eliminación del sucesor (que tendrá 0 o 1 hijo). La clave es analizar el color del nodo que *efectivamente* se elimina físicamente del árbol (llamémoslo `y`).

**El caso específico del borrado de un nodo ROJO (`y`) es el más sencillo:**

1.  **Identificar el nodo a eliminar físicamente (`y`):** Siguiendo el algoritmo de borrado de BST, localizamos el nodo `y` que será desconectado del árbol.
2.  **Si `y` es ROJO:**
    *   **Propiedades Conservadas:** La eliminación de un nodo rojo *no viola* ninguna de las propiedades fundamentales del árbol rojo-negro:
        *   **Propiedad Roja (Propiedad 4):** Si `y` era rojo, sus hijos (si los tuviera antes de la reorganización del borrado de BST, que serían hojas NIL en el momento de la eliminación física) deben ser negros. Al eliminar `y`, no se crea una secuencia de dos nodos rojos seguidos. El padre de `y` (si existe) puede ser rojo o negro, pero la eliminación de `y` no afecta esta relación.
        *   **Propiedad Negra (Propiedad 5):** La eliminación de un nodo rojo no cambia el número de nodos negros en ningún camino desde la raíz hasta las hojas que pasaban por `y`. La "altura negra" de los subárboles y ancestros no se ve afectada.
        *   Las propiedades de Raíz Negra y Hojas Negras tampoco se ven afectadas directamente por la simple eliminación de un nodo rojo interno o hoja.
    *   **Acción:** Simplemente se elimina el nodo `y` (o se reemplaza por su único hijo, que debe ser una hoja NIL negra si `y` es el nodo físicamente eliminado y era rojo). No se requieren recoloraciones ni rotaciones adicionales.

**En resumen:** Si el nodo que se elimina físicamente del árbol durante el proceso de borrado es ROJO, basta con realizar la eliminación estándar del BST (desconectarlo o reemplazarlo por su hijo NIL). Las propiedades del árbol rojo-negro se mantienen sin necesidad de pasos adicionales de "fixup" (reparación). La complejidad surge cuando el nodo eliminado físicamente es NEGRO, ya que esto sí altera la Propiedad Negra y requiere recoloraciones y/o rotaciones para restaurar el equilibrio.

# Ejercicio 100. Set Implementado con Árbol Binario

**Definición de Set (Conjunto):**

Un **Set** es una estructura de datos (un tipo abstracto de dato) que almacena una colección de elementos **únicos**, sin un orden particular intrínseco (aunque algunas implementaciones pueden mantenerlos ordenados). Las operaciones fundamentales sobre un set son:

*   **`add(elemento)`:** Añade un elemento al conjunto. Si el elemento ya existe, el conjunto no cambia.
*   **`remove(elemento)`:** Elimina un elemento del conjunto. Si el elemento no existe, no hace nada.
*   **`contains(elemento)`:** Comprueba si un elemento pertenece al conjunto (devuelve verdadero o falso).
*   **`size()`:** Devuelve el número de elementos en el conjunto.
*   Otras operaciones pueden incluir: unión, intersección, diferencia de conjuntos, iteración sobre los elementos.

**Implementación con Árbol Binario:**

Se puede implementar un Set utilizando un **Árbol Binario de Búsqueda (BST)**, y más específicamente, un **Árbol Binario de Búsqueda Auto-balanceable** (como un Árbol AVL o un **Árbol Rojo-Negro**) para garantizar eficiencia.

*   **Estructura:** Cada nodo del árbol almacena uno de los elementos del conjunto. El árbol se organiza según las reglas del BST: para cualquier nodo, todos los elementos en su subárbol izquierdo son menores (o menores o iguales) que el elemento del nodo, y todos los elementos en su subárbol derecho son mayores.
*   **Unicidad:** La propia naturaleza de la inserción en un BST facilita la gestión de la unicidad. Al intentar insertar un elemento que ya existe, la búsqueda previa a la inserción lo encontrará, y simplemente no se realizará una nueva inserción.
*   **Operaciones:**
    *   **`add(elemento)`:** Se busca el elemento en el árbol. Si se encuentra, no se hace nada. Si no se encuentra, se inserta como una nueva hoja en la posición correcta según las reglas del BST. Si se usa un árbol auto-balanceable, se realizan las rotaciones/recoloraciones necesarias después de la inserción para mantener el balance. Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`remove(elemento)`:** Se busca el elemento. Si se encuentra, se elimina utilizando el algoritmo de borrado de BST (manejando los casos de 0, 1 o 2 hijos). Si se usa un árbol auto-balanceable, se realizan las operaciones de balanceo necesarias post-eliminación. Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`contains(elemento)`:** Se realiza una búsqueda estándar en el BST. Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`size()`:** Se puede mantener un contador actualizado en cada `add`/`remove` (O(1)) o recorrer todo el árbol (O(n)).

**Ventajas:** Las operaciones principales son eficientes (logarítmicas si el árbol está balanceado). Permite obtener los elementos en orden (mediante un recorrido inorden).

# Ejercicio 101. Map Implementado con Árbol Binario

**Definición de Map (Diccionario o Mapa Asociativo):**

Un **Map** es una estructura de datos (un tipo abstracto de dato) que almacena una colección de pares **clave-valor**, donde cada **clave** es **única** dentro del map. Permite recuperar eficientemente un valor asociado a una clave dada. Las operaciones fundamentales son:

*   **`put(clave, valor)`:** Asocia el `valor` especificado con la `clave` especificada. Si el map ya contenía una entrada para esa `clave`, el valor antiguo es reemplazado por el nuevo `valor`. Si no, se crea una nueva entrada.
*   **`get(clave)`:** Devuelve el `valor` asociado a la `clave` especificada, o un indicativo (como `null` o una excepción) si la `clave` no existe en el map.
*   **`remove(clave)`:** Elimina la entrada (par clave-valor) asociada a la `clave` especificada, si existe.
*   **`containsKey(clave)`:** Comprueba si el map contiene una entrada para la `clave` especificada.
*   **`size()`:** Devuelve el número de pares clave-valor en el map.
*   Otras operaciones pueden incluir: obtener el conjunto de claves, obtener la colección de valores, iterar sobre los pares clave-valor.

**Implementación con Árbol Binario:**

Se puede implementar un Map utilizando un **Árbol Binario de Búsqueda (BST)**, y preferiblemente un **Árbol Binario de Búsqueda Auto-balanceable** (como AVL o **Rojo-Negro**).

*   **Estructura:** Cada nodo del árbol almacena un par **(clave, valor)**. El árbol se organiza **exclusivamente según las claves**, siguiendo las reglas del BST: para cualquier nodo, todas las claves en su subárbol izquierdo son menores que la clave del nodo, y todas las claves en su subárbol derecho son mayores. El valor simplemente se almacena junto a su clave en el nodo.
*   **Unicidad de Claves:** Al igual que con el Set, la búsqueda inherente al BST asegura que no se inserten claves duplicadas; en lugar de eso, se actualiza el valor si la clave ya existe.
*   **Operaciones:**
    *   **`put(clave, valor)`:** Se busca la `clave` en el árbol.
        *   Si se encuentra un nodo con esa `clave`: se actualiza el `valor` de ese nodo con el nuevo `valor`.
        *   Si no se encuentra: se inserta un nuevo nodo conteniendo el par `(clave, valor)` en la posición correcta según la `clave`. Si se usa un árbol auto-balanceable, se realizan las operaciones de balanceo necesarias.
        *   Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`get(clave)`:** Se busca la `clave` en el árbol. Si se encuentra el nodo, se devuelve su `valor` asociado. Si no, se devuelve `null` o similar. Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`remove(clave)`:** Se busca la `clave`. Si se encuentra el nodo, se elimina utilizando el algoritmo de borrado de BST (operando sobre la clave) y se realizan las operaciones de balanceo necesarias si aplica. Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`containsKey(clave)`:** Se realiza una búsqueda estándar de la `clave` en el BST. Complejidad: O(log n) en promedio y en el peor caso para árboles balanceados.
    *   **`size()`:** Similar al Set, se puede mantener un contador (O(1)) o recorrer el árbol (O(n)).

**Ventajas:** Operaciones eficientes (logarítmicas con balanceo). Permite iterar sobre los pares clave-valor en orden de clave (recorrido inorden).
# Ejercicio 102. El propósito del presente ejercicio es mostrar la aplicación de los set y los map a un problema real. Se pide implementar un validador de doble máster siguiendo los pasos que se muestran a continuación (cree los paquetes que considere oportunos para organizar las diferentes clases):
## 1. Cree la clase Asignatura de tal forma que permita que cualquier asignatura tenga un identificador, un nombre, el número de semestre en que se imparte y el número de créditos ECTS.
## 2. Cree la clase Master de tal forma que permita que cualquier máster tenga un identificador, un nombre y un conjunto de asignaturas.
## 3. Heredando de la clase Master, cree la clase DobleMaster de tal forma que permita que cualquier doble máster tenga un identificador, un nombre, un conjunto de asignaturas, una relación con los dos máster que engloba, y una serie de mappings entre sus asignaturas y las asignaturas de los dos máster simples.
## 4. Añada a la clase DobleMaster una tabla de convalidaciones entre asignaturas de los máster simples.
## 5. Utilizando la técnica de TDD, complete la clase DobleMaster con un método que permita validar cualquier doble máster según las reglas que se muestran a continuación:
### a) Cobertura del máster 1: para toda asignatura del máster 1, bien pertence el conjunto de asignaturas del doble máster, bien tiene una equivalencia con alguna asignatura del doble máster.
### b) Cobertura del máster 2 (análogo al paso anterior).
### c) Precisión del doble máster: para toda asignatura del doble máster, bien pertenece al máster 1 bien pertenece al máster 2.
### d ) Secuenciación correcta: no se da el caso de que una asignatura aparezca en distinto semestre en un máster simple y en el máster doble.
# Ejercicio 103. Explique cómo implementaría un árbol en que cada nudo puede tener más de dos hijos.
Si cada nodo tiene más de 2 hijos significa que cada uno de los nodos debe almacenar la dirección de tantos hijos como tenga el árbol por nodo.
Por lo que simplemente en vez de añadir los atributos Arbol derecha y Arbol izquierda, añadiría Arbol1, Arbol2, ..., Arboln a cada nodo para que tuviera tantos hijos como fuera necesario. 
# Ejercicio 104. Averigüe cómo JDOM estructuraría en forma de árbol el siguiente fragmento de HTML:
```
<TABLE>
<TBODY>
<TR>
<TD>Shady Grove</TD>
<TD>Aeolian</TD>
</TR>
<TR>
<TD>Over the River, Charlie</TD>
<TD>Dorian</TD>
</TR>
</TBODY>
</TABLE>
```
## Estructura del Árbol JDOM para el Fragmento HTML

JDOM representaría el fragmento HTML `<TABLE>...</TABLE>` como un **árbol de objetos** en memoria, siguiendo la jerarquía de las etiquetas:

1.  **Elemento Raíz (`Root Element`):**
  *   Un objeto `Element` con el nombre `TABLE`.

2.  **Hijos del Raíz:**
  *   El `Element` `TABLE` tendría **un** hijo:
    *   Un `Element` con el nombre `TBODY`.

3.  **Hijos de `TBODY`:**
  *   El `Element` `TBODY` tendría **dos** hijos, ambos `Element` con el nombre `TR`.

4.  **Hijos de cada `TR`:**
  *   **Cada** `Element` `TR` tendría **dos** hijos, ambos `Element` con el nombre `TD`.

5.  **Contenido de `TD` (Nodos Hoja):**
  *   **Cada** `Element` `TD` tendría **un** hijo:
    *   Un nodo `Text` que contiene el texto correspondiente (ej: "Shady Grove", "Aeolian", etc.). Estos nodos `Text` son las "hojas" del árbol en esas ramas.
