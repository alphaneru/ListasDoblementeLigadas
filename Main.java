public class Main {
    public static void main(String[] args) {
        doubleLinkedList ll = new doubleLinkedList(10);
        ll.append(20);
        ll.append(30);
        ll.append(40);
        ll.append(50);
        ll.printList();

        System.out.println("Datos adicionales.");
        ll.getHead();
        ll.getTail();
        ll.getLength();
        System.out.println("Probando REMOVE 50");
        System.out.println(ll.removeLast().value);
        System.out.println("Probando REMOVE 40");
        System.out.println(ll.removeLast().value);
        System.out.println("Probando REMOVE 30");
        System.out.println(ll.removeLast().value);
        System.out.println("Probando REMOVE 20");
        System.out.println(ll.removeLast().value);
        System.out.println("Probando REMOVE 10");
        System.out.println(ll.removeLast().value);

        System.out.println("Probando REMOVE vacio");
        System.out.println(ll.removeLast());

        ll.append(1);

        System.out.println("Remove first");
        System.out.println(ll.removeFirst());
        ll.printList();

        ll.append(100);
        System.out.println("Imprimiendo lista con 100");
        ll.printList();
        ll.append(200);
        System.out.println("Imprimiendo lista con 100 y 200");
        ll.printList();

        System.out.println("\nGet (índice 0)");
        System.out.println(ll.get(0).value);
        System.out.println("Set (valor 1 en el índice 0)");
        System.out.println(ll.set(0, 1));
        ll.printList();

        System.out.println("\nAppend (valor 30)");
        ll.append(30);
        ll.printList();
        System.out.println("Prepend (valor 30)");
        ll.prepend(30);
        ll.printList();

        System.out.println("\nInsert (Valor 12 en el Índice 2)");
        ll.insert(2, 12);
        ll.printList();
        System.out.println("Remove (Índice 2)");
        ll.remove(2);
        ll.printList();

        System.out.println("\nNodo de en medio");
        System.out.println(ll.medio().value);

        System.out.println("\nVerificar ciclo");
        System.out.println(ll.esCiclo());
        System.out.println("Verificar ciclo (lista ciclada)");
        doubleLinkedList lc = new doubleLinkedList(10);
        lc.append(20);
        lc.append(30);
        lc.get(2).next = lc.get(0);
        lc.get(0).prev = lc.get(2);
        System.out.println(lc.esCiclo());

        System.out.println("Invertir lista");
        ll.printList();
        System.out.println("Lista invertida");
        ll.reverse();
        ll.printList();
    }
}