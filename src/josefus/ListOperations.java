
package josefus;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ListOperations {
    JTextArea area;
    public ListOperations(JTextArea area){
        this.area=area;
    }
    
     public Node findTail(Node head) {
        Node tail = head;

        if (head != null) {
            while (tail.getNext() != head) {
                tail = tail.getNext();
            }
        }

        return tail;
    }

    public Node enQueue(Node head, String data) {

        if (head != null) {
            Node tail = findTail(head);

            Node newNode = new Node(data);
            newNode.setNext(head);

            tail.setNext(newNode);
        } else {
            Node newNode = new Node(data);
            newNode.setNext(newNode);
            head = newNode;

        }

        return head;
    }

    public Node deQueue(Node head) {
        if (head.getNext() != head) {

            Node dequeued = head;
            Node next = head.getNext();
            Node tail = findTail(head);

            head = next;
            tail.setNext(head);
            
            area.append("Sacando de la cola a "+dequeued.getData()+"\n");
            System.out.println("Sacando de la cola a "+dequeued.getData());
            
            return head;
        } else {
            return null;
        }
    }

    public void josephus(Node head, int size) {
        area.append("Iniciando Josephus con ciclo de "+size+"\n");
            System.out.println("Iniciando Josephus con ciclo de "+size);
        while (!head.getNext().equals(head)) {
            Node selected = head;
            
            for (int i = 0; i < size-1; i++) {
                selected = selected.getNext();
            }

            head = deQueue(selected);
            print(head);
        }
        
        JOptionPane.showMessageDialog(null,"El ganador es: "+head.getData() );
        area.append("finalizado " + head.getData());
        System.out.println("finalizado " + head.getData());
    }

    public void print(Node head) {
        Node q = head;

        if (q != null) {
            do {
                area.append(q.getData() + " ");
                System.out.print(q.getData() + " ");
                q = q.getNext();
            } while (q != head);
        }

        area.append("\n");
        System.out.println();
    }

}
