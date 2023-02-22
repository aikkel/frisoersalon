import java.util.Scanner;
import java.util.ArrayList;

public class UI {
    //Indeholder metoder til at scanne input med error handling, kan også potentielt klare menu'er fra Main

    private Scanner s = new Scanner(System.in);

    public void printArray(ArrayList arrayList) {
        for (Object o : arrayList) {
            System.out.println(o.toString());
        }
    }

    public String readString(String inputType){
        String str;
        try{
            while (s.hasNextInt()) {
                System.out.println("Indtast kun " + inputType);
                str = s.next();
            }
            str = s.next();
        } catch (Exception e) {
            System.out.print("Indtast kun " + inputType);
            s.nextLine();
            str = readString(inputType);
        } return str;
    }

    public int readInteger(String inputType, int limit) {
        int i;
        try {
            i = s.nextInt();
            while(i < 0 || i > limit){
                System.out.println("Indtast kun " + inputType);
                i = readInteger(inputType, limit);
            }
        } catch (Exception e) {
            System.out.print("Indtast kun " + inputType + "\n");
            s.nextLine();
            i = readInteger(inputType, limit);
        } return i;
    }

    public double readDouble(String inputType, double limit) {
        double d;
        try {
            d = s.nextInt();
            while(d < 0 || d > limit){
                System.out.println("Indtast kun " + inputType);
                d = readDouble(inputType, limit);
            }
        } catch (Exception e) {
            System.out.print("Indtast kun " + inputType + "\n");
            s.nextLine();
            d = readDouble(inputType, limit);
        } return d;
    }


}
