/*
        3.1:
        Problem for State: En motorisert garasjeport med lås og en fjernkontroll med 2 knapper.
        Den ene knappen er for å åpne og lukke porten, og den andre for å låse og låse opp.
        Garasjen kan ikke låses når porten er åpen og kan ikke åpne når låsen er låst.

        Problem for Strategy: Sortering av datasett. Sorteringshastighet kan være veldig varierende med forskjellige
        sorteringsalgoritmer og størrelser av datasettet som skal sorteres. Ved å ha forskjellige algoritmer som kan
        sortere datasettet basert på lengde og type gjør at vi kan få mye bedre ytelse.

        3.2:
        Kjør Designmønstre.main() for å teste.


 */


package designmønstre;

import static javax.swing.JOptionPane.showInputDialog;

interface PortState {
    PortState lockUnlock();
    PortState openClose();
    String getState();
}

class OpenPortState implements PortState{

    @Override
    public PortState lockUnlock() {

        System.out.println("Porten er åpen! Kan ikke låse.");
        return new OpenPortState();
    }

    @Override
    public PortState openClose() {

        return new ClosedPortState();
    }

    @Override
    public String getState() {
        return "Porten er åpen.";
    }

}

class ClosedPortState implements PortState {

    @Override
    public PortState lockUnlock() {
        return new LockedPortState();
    }

    @Override
    public PortState openClose() {
        return new OpenPortState();
    }

    @Override
    public String getState() {
        return "Porten er lukket.";
    }
}

class LockedPortState implements PortState {
    @Override
    public PortState lockUnlock() {

        return new ClosedPortState();
    }

    @Override
    public PortState openClose() {
        System.out.println("Porten er låst! Kan ikke åpne.");
        return new LockedPortState();
    }

    @Override
    public String getState() {
        return "Porten er låst.";
    }
}

class GarasjePort {

    PortState state = new ClosedPortState();

    public void lockUnlock(){
        state = state.lockUnlock();
    }

    public void openClose(){
        state = state.openClose();
    }

    public void printState(){
        System.out.println(state.getState());
    }
}





public class Designmønstre {

    public static void main(String[] args){

        GarasjePort port = new GarasjePort();

        //Automatisert test
/*
        port.printState();

        System.out.println("Prøver å åpne: ");
        port.openClose();
        port.printState();

        System.out.println("Prøver å låse: ");
        port.lockUnlock();
        port.printState();

        System.out.println("Prøver å lukke: ");
        port.openClose();
        port.printState();

        System.out.println("Prøver å låse: ");
        port.lockUnlock();
        port.printState();

        System.out.println("Prøver å åpne: ");
        port.openClose();
        port.printState();

        System.out.println("Prøver å låse opp: ");
        port.lockUnlock();
        port.printState();

        System.out.println("Prøver å åpne: ");
        port.openClose();
        port.printState();

*/

        //Manuell test

        String input;
        while (true) {
            input = showInputDialog("Lock/Unlock: 1 \nOpen/Close: 2 \nExit: 3 \nType number for operation: ");
            switch (input){
                case "1":{
                    port.lockUnlock();
                    port.printState();
                    break;
                }
                case "2":{
                    port.openClose();
                    port.printState();
                    break;
                }
                case "3":{
                    return;
                }
                default:{
                    System.out.println("Ugyldig input");
                    break;
                }
            }

        }






    }
}
