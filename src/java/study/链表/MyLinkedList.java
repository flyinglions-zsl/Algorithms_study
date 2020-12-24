package study.链表;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MyLinkedList {
    private int size;
    private Node firstNode;

    private static class Node<E>{
        E element;
        Node<E> nextNode;
        public Node(E element,Node<E> nextNode){
            this.element = element;
            this.nextNode = nextNode;
        }
    }
}
