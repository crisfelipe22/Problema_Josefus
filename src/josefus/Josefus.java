/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josefus;

import javax.swing.JTextArea;

/**
 *
 * @author asus
 */
public class Josefus {

    Node head;
    ListOperations list;

    public Josefus(String[] nombres,int salto, JTextArea area) {

        this.head = null;

        list = new ListOperations(area);

        //String[] nombres = {"Pedro", "Juan", "Marco", "Natalia", "Leidy", "Sebastián", "Julián"};

        int size = nombres.length;

        for (int i = 0; i < size; i++) {
            head = list.enQueue(head, nombres[i]);
        }
        System.out.println("Lista inicial");
        //list.print(head);
        list.josephus(head, salto);
    }
}
