package modelo;

public class LinkedTins<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;



    public int size() {
        return size;
    }

    public boolean isEmpty() {

        return head == null;
    }

    @Override
    public String toString() {

        if (isEmpty())
            return null;

        Node<T> aux = head;

        String values = "[ ";

        while (aux != null) {

            if (aux.getNext() != null)
                values += aux.getData() + ", ";

            else
                values += aux.getData() + " ]";

            aux = aux.getNext();
        }

        return values;
    }

    public void add (T newElement) {

        if (isEmpty()) {

            head = new Node<T>(newElement);

            tail = head;
        }

        else {

            Node<T> aux = tail;

            aux.setNext(new Node<T>(newElement));

            aux.getNext().setPrevious(tail);

            tail = aux.getNext();
        }

        size++;
    }

    public void addFirst (T newElement) {

        if (isEmpty()) {

            head = new Node<T>(newElement);

            tail = head;
        }

        else {

            Node<T> aux = head.getNext();

            head = new Node<T>(newElement);

            head.setNext(aux.getPrevious());

            aux.getPrevious().setPrevious(head);
        }

        size++;
    }

    public void addLast(T newElement) {

        if (isEmpty()) {

            head = new Node<T>(newElement);

            tail = head;
        }

        else {

            Node<T> aux = tail;

            aux.setNext(new Node<T>(newElement));

            aux.getNext().setPrevious(tail);

            tail = aux.getNext();
        }

        size++;
    }

    public void add (T newElement, int index) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            addFirst(newElement);

        else if (index == size())
            addLast(newElement);

        else {

            Node<T> aux = head;

            for (int i = 0; i < size; i++) {

                if (i == index)
                    break;

                aux = aux.getNext();
            }

            if (index == (size()-1)) {

                Node<T> oldPrevious = aux.getPrevious();

                aux = new Node<T>(newElement);

                aux.setNext(oldPrevious.getNext());

                aux.getNext().setPrevious(aux);

                oldPrevious.setNext(aux);

                aux.setPrevious(oldPrevious);
            }

            else {

                Node<T> oldNext = aux.getNext();

                Node<T> oldPrevious = aux.getPrevious();

                aux = new Node<T>(newElement);

                aux.setNext(oldNext.getPrevious());

                oldNext.getPrevious().setPrevious(aux);

                oldPrevious.setNext(aux);

                aux.setPrevious(oldPrevious);
            }

            size++;
        }
    }

    public T remove() {

        if (isEmpty())
            throw new IndexOutOfBoundsException();

        if (size() == 1) {

            Node<T> aux = head;

            head = null;

            tail = null;

            size--;

            return aux.getData();
        }

        else {

            Node<T> removedNode = head;

            Node<T> aux = head.getNext();

            aux.setPrevious(null);

            head = aux;

            size--;

            return removedNode.getData();
        }
    }

    public T removeFirst() {

        if (isEmpty())
            throw new IndexOutOfBoundsException();

        if (size() == 1) {

            Node<T> aux = head;

            head = null;

            tail = null;

            size--;

            return aux.getData();
        }

        else {

            Node<T> removedNode = head;

            Node<T> aux = head.getNext();

            aux.setPrevious(null);

            head = aux;

            size--;

            return removedNode.getData();
        }
    }

    public T removeLast() {

        if (isEmpty())
            throw new IndexOutOfBoundsException();

        if (size() == 1) {

            Node<T> aux = tail;

            head = null;

            tail = null;

            size--;

            return aux.getData();
        }

        else {

            Node<T> removedNode = tail;

            Node<T> aux = tail.getPrevious();

            aux.setNext(null);

            tail = aux;

            size--;

            return removedNode.getData();
        }
    }

    public T remove(int index) {

        if (isEmpty() || index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (size() == 1) {

            Node<T> aux = tail;

            head = null;

            tail = null;

            size--;

            return aux.getData();
        }

        else {

            if (index == 0)
                return removeFirst();

            if (index == (size()-1))
                return removeLast();

            Node<T> nodePosition = head;

            for (int i = 0; i < size(); i++) {

                if (index == i)
                    break;

                nodePosition = nodePosition.getNext();
            }

            Node<T> oldNext = nodePosition.getNext();

            Node<T> oldPrevious = nodePosition.getPrevious();

            oldPrevious.setNext(oldNext);

            oldNext.setPrevious(oldPrevious);

            size--;

            return nodePosition.getData();
        }
    }

    public T getFirst() {

        return head.getData();
    }

    public T getLast() {

        return tail.getData();
    }

    public T get(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> aux = head;

        for (int i = 0; i < size; i++) {

            if (i == index)
                break;

            aux = aux.getNext();

        }

        return aux.getData();
    }


}