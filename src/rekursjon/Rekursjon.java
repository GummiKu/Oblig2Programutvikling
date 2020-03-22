package rekursjon;

public class Rekursjon {



    static int sum(int x){
        int sum = 0;
        for(int i = x; i > 0; i--){
            sum = sum + i;
        }
        return sum;
    }

    //Oppgave 1.1
    static int rekursivSum(int x){
        if(x == 1){
            return x;
        }
        return x + rekursivSum(--x);
    }

    //Oppgave 1.2
    static int pow(int base, int exponent){
        if (exponent == 1){
            return base;
        }
        return base * pow(base, --exponent);
    }

    //Oppgave 1.3
    static void printInverted(int[] ints, int lenght){

        System.out.print(ints[lenght-1]);
        System.out.print(" ");

        if (lenght == 1){
            return;
        }

        printInverted(ints, --lenght);
    }

    //Oppgave 1.4
    static int returnLowestInt(int[] ints, int length){

        if (length == 1) {
            return ints[0];
        }
        int low = returnLowestInt(ints, length-1);
        int lowest = ints[length-1];

        if (low < lowest){
            lowest = low;
        }
        return lowest;
    }

    //Oppgave 1.5
    static int findIntPosition(int[] ints, int findInt , int length){
        int intPosition = length - 1;

        if (intPosition == -1){
            return intPosition;
        }

        if (ints[intPosition] == findInt) {
            return intPosition;
        }
        intPosition = findIntPosition(ints,findInt, intPosition);
        return intPosition;
    }

    public static void main(String[] args){

        //Oppgave 1.1
        int testTall = 5;

        System.out.println("Uten rekursjon:" + sum(testTall));
        System.out.println();

        //Test oppgave 1.1
        System.out.println("Med rekursjon: "+rekursivSum(testTall));
        System.out.println();

        //Test oppgave 1.2
        int base = 2;
        int exponent = 8;
        System.out.println(base + " opphøyd i " + exponent + ": " + pow(base, exponent));
        System.out.println();

        int[] ints = {38,71,32,43,42,58};
        System.out.println("Heltallstabell: ");
        for (int i : ints){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        //Test oppgave 1.3
        System.out.println("Reversert tabell: ");
        printInverted(ints, ints.length);

        System.out.println();
        System.out.println();

        //Test oppgave 1.4
        System.out.println("Lowest int: " + returnLowestInt(ints, ints.length));
        System.out.println();

        //Test oppgave 1.5
        int findInt = 44;
        System.out.println("Searching for: " + findInt);
        int intPosition = findIntPosition(ints,findInt,ints.length);
        if (intPosition != -1) {
            System.out.println("Found int " + ints[intPosition] + " at position " + intPosition);
        } else {
            System.out.println("Did not find " + findInt);
        }

        findInt = 32;
        System.out.println("Searching for: " + findInt);
        intPosition = findIntPosition(ints,findInt,ints.length);
        if (intPosition != -1) {
            System.out.println("Found int " + ints[intPosition] + " at position " + intPosition);
        } else {
            System.out.println("Did not find " + findInt);
        }
    }
}
