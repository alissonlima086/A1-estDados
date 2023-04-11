package modelo;

public class ArrayTins<T> {

    private final int SIZE = 10;
    private T[] array = null; // array é uma variável de referência que nesse momento está vazia
    private int lastPosition = 0;

    public ArrayTins() {

        array = ((T[]) new Object[SIZE]);
    }

    @Override
    public String toString() {

        String result = "[ ";

        int flag = 0;

        for (T item : array) {

            if (item != null)
                if (flag < (lastPosition-1)) {

                    result += item + ", ";
                    flag++;
                }

                else {

                    result += item;
                }
        }

        result += " ]";

        return result;
    }

    public boolean isEmpty() {

        return lastPosition == 0; // se for igual retornará true e indicará que está vazio
    }

    public int size() { // irá retornar a quantidade de elementos do array

        return lastPosition;
    }


    public void add (int index, T newElement) {

        if (index < 0 || index > lastPosition)
            throw new IndexOutOfBoundsException();

        if (array.length == size())
            resize();

        for (int i = (lastPosition-1); i >= index; i--) {

            array[i+1] = array[i];
        }

        array[index] = newElement;

        lastPosition++;
    }


    public void add(T newElement) {

        if (array.length == size())
            resize();

        array[lastPosition] = newElement;

        lastPosition++;
    }

    public T remove (int index) {

        if (index < 0 || index >= lastPosition)
            throw new IndexOutOfBoundsException();

        T oldValue = array[index];

        array[index] = null;

        for (int i = index; i < (size()-1); i++) {

            array[i] = array[i+1];
        }

        lastPosition--;

        array[lastPosition] = null;

        return oldValue;
    }

    public T get (int position) {

        if (position < 0 || position >= lastPosition) {

            throw new IndexOutOfBoundsException();
        }

        return array[position];
    }

    private void resize() {

        T[] newArray = (T[]) new Object[(array.length + (array.length / 2))]; // newArray é uma variável de referência que está apontando para um array de objects que é equivalente a largura de array
        // mais a constante SIZE

        for (int position = 0; position < array.length; position++) { // os valores de array estão sendo copiados para o vetor que newArray referencia

            newArray[position] = array[position];
        }

        array = newArray; // array recebe a referência de newArray, para que ao terminar o método o array não se perca. Por outro lado o antigo array se perdeu

        System.gc(); // chama forçadamente o garbage collector
    }
}