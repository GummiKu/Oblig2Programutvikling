package generiskProgrammering;



class MyArrayList<E> {
    private Object[] elements;

    public MyArrayList(){
        elements = new Object[10];
    }

    public void add(E element){

    }
    public E get(int index){


        return null;
    }

    public int size(){

        return 0;
    }
}


public class GeneriskProgrammering {

    public static <E> void printArray(E[] array){
        for (E elem : array){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static <E> E[] reverseArray(E[] array){
        Object[] reverse = new Object[array.length];

        for (int i = array.length; i > 0; i--){
            reverse[array.length - i] = array[i-1];
        }
        for (int i = 0; i < array.length; i++){
            array[i] = (E) reverse[i];
        }

        return array;
    }


    public static void main(String[] args){
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hei", "Test", "String"};

        printArray(intArray);
        printArray(strArray);

        printArray(reverseArray(intArray));
        printArray(reverseArray(strArray));

    }

}
