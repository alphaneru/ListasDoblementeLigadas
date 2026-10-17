public class doubleLinkedList {
    // Atributos
    private Node head;
    private Node tail;
    private int length;

    // Se define un nodo en una clase interna
    class Node {
        int value;
        Node next;
        Node prev; // Referencia al nodo anterior (doble enlace)
        public Node(int value) {
            this.value = value;
        }
    }

    // Constructor
    public doubleLinkedList(int value) {
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
    }

    // Imprime el valor de head
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    // Imprime el valor de tail
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    // Imprime la longitud de la lista
    public void getLength() {
        System.out.println("Length: " + length);
    }

    // Regresa el nodo con el índice especificado
    public Node get(int index) {
        if (index >= length || index < 0) { // Verifica que el índice sea válido
            return null;
        }
        int i = 0;
        Node newNode = head;
        while (i != index) { // Recorre la lista hasta que se haya llegado al índice buscado
            i++;
            newNode = newNode.next;
        }

        return newNode;
    }

    // Asigna el valor indicado al nodo con el índice especificado
    public boolean set(int index, int value) {
        if (index >= length || index < 0) {
            return false;
        }

        int i = 0;
        Node newNode = head;
        while (i != index) {
            i++;
            newNode = newNode.next;
        }

        newNode.value = value;
        return true;
    }

    // Imprime los valores de todos los nodos en la lista
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Elimina el primer nodo de la lista
    public Node removeFirst() {
        if (length <= 1) { // Si solo hay un nodo o ninguno, la lista queda vacía
            head = null;
            tail = null;
            length = 0;
            return null;
        }
        Node temp = head; // Se guarda el nodo a eliminar para devolverlo
        head = head.next; // El nuevo nodo head se vuelve el nodo al que apuntaba originalmente
        head.prev = null; // Se corta el enlace previo del nuevo head
        temp.next = null; // Se desconecta el nodo eliminado de la lista
        length--;
        return temp;
    }

    // Elimina el último nodo de la lista
    public Node removeLast() {
        if (length == 0) { // Si el tamaño es de cero, no hay nada que eliminar
            return null;
        }

        Node temp = tail; // Nodo que se eliminará

        if (length == 1) { // Si solo hay un nodo, la lista queda vacía
            head = null;
            tail = null;
        } else {
            tail = tail.prev; // El penúltimo nodo se vuelve tail (ya no hace falta recorrer la lista)
            tail.next = null; // Indica que es el final de la lista
            temp.prev = null; // Se desconecta el nodo eliminado de la lista
        }
        length--;

        return temp;
    }

    // Agrega un nuevo nodo al final con el valor indicado
    public void append(int value) {
        if (length == 0) { // Si no hay nodos, se agregará como primero
            Node newNode = new Node(value);
            length = 1;
            head = newNode;
            tail = newNode;
            return;
        }
        Node newNode = new Node(value);
        newNode.prev = tail; // El nodo anterior al nuevo nodo es el tail actual
        tail.next = newNode; // Agrega el nodo después de tail
        tail = newNode; // El nuevo nodo se vuelve tail
        length++;
    }

    // Agrega un nuevo nodo al principio con el valor indicado
    public void prepend(int value) {
        if (length == 0) {
            Node newNode = new Node(value);
            length = 1;
            head = newNode;
            tail = newNode;
            return;
        }

        Node newNode = new Node(value);
        newNode.next = head; // Asigna el valor previo de head como el siguiente nodo
        head.prev = newNode; // El nodo anterior de head ahora es el nuevo nodo
        head = newNode; // El nuevo nodo ahora es head
        length++;
    }

    // Inserta un nuevo nodo en el índice especificado
    public void insert(int index, int value) {
        if (index > length || index < 0) {
            return;
        }
        if (index == 0) { // Insertar en 0 es lo mismo que hacer prepend
            prepend(value);
            return;
        }
        if (index == length) { // Insertar al final es lo mismo que hacer append
            append(value);
            return;
        }
        int i = 0;
        Node pointerNode = head;
        while (i != index - 1) { // Se detiene un nodo antes del índice esperado
            i++;
            pointerNode = pointerNode.next;
        }
        Node newNode = new Node(value);
        Node temp = pointerNode.next; // Almacena el nodo que sigue
        pointerNode.next = newNode; // Se inserta el nuevo nodo en el índice especificado
        newNode.prev = pointerNode; // Se conecta el enlace previo del nuevo nodo
        newNode.next = temp; // El nuevo nodo se conecta con el que estaba anteriormente en su lugar
        temp.prev = newNode; // El nodo que seguía se conecta de regreso con el nuevo nodo
        length++;
    }

    // Elimina un nodo en el índice indicado
    public void remove(int index) {
        if (index >= length || index < 0) {
            return;
        }
        if (index == 0) { // Eliminar en 0 es lo mismo que hacer removeFirst
            removeFirst();
            return;
        }
        int i = 0;
        Node pointerNode = head;
        while (i != index - 1) {
            i++;
            pointerNode = pointerNode.next;
        }
        Node temp = pointerNode.next; // Almacena el nodo a eliminar
        pointerNode.next = temp.next; // Asigna el nodo previo al siguiente, quitando el nodo a eliminar
        if (temp.next != null) {
            temp.next.prev = pointerNode; // Reconecta el enlace previo del nodo siguiente
        } else {
            tail = pointerNode; // Si se eliminó el último nodo, el previo se vuelve tail
        }
        temp.next = null; // Se desconecta por completo el nodo eliminado
        temp.prev = null;
        length--;
    }

    // Encuentra el nodo medio
    public Node medio() {
        if (length == 0) {
            return null;
        }

        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) { // Si p2 llega al final de la lista, p1 siempre estará a la mitad
            p1 = p1.next; // p1 avanzará 1 posición por ciclo
            p2 = p2.next.next; // p2 avanzará 2 posiciones por ciclo
        }
        return p1;
    }

    // Verifica si la lista está ciclándose
    public boolean esCiclo() {
        if (length <= 1) {
            return false;
        }
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) { // Verifica que no se haya encontrado un null
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) { // Si ambos punteros se encuentran, la lista se está ciclando
                return true;
            }
        }
        return false; // Si se encuentra un null, la lista no se está ciclando
    }

    // Invierte la lista
    public void reverse() {
        if (length <= 1) {
            return;
        }
        Node p1 = null; // Nodo anterior
        Node p2 = head; // Nodo actual
        Node p3; // Nodo posterior
        while (p2 != null) { // Mientras p2 no llegue al final, se seguirán invirtiendo los nodos
            p3 = p2.next; // El nodo se mueve a la derecha
            p2.next = p1; // Se invierte la dirección del enlace siguiente
            p2.prev = p3; // Se invierte la dirección del enlace previo
            p1 = p2; // Se recorre el nodo a la derecha
            p2 = p3; // Se recorre el nodo a la derecha
        }
        tail = head; // Como se invirtió la lista, tail ahora es head
        head = p1; // Head ahora es el nodo del final
    }
}