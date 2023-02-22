import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //start på klasser
        //fix en database
        // driver
        //TODO LAV CONTROLLERS ISTEDET FOR AT HAVE ALT I MAIN
        menu();
    }

    public static User opretUser() {

        UI ui = new UI();
        System.out.println("Indtast bruger:");

        System.out.println("fornavn");
        String userfNavn = ui.readString("fornavn");

        System.out.println("efternavn");
        String usereNavn = ui.readString("efternavn");

        System.out.println("adresse");
        String userAdresse = ui.readString("adresse");

        System.out.println("postnummer");
        int userPostnr = ui.readInteger("postnummer", 9999);

        System.out.println("telefonnummer");
        int userTelefonnr = ui.readInteger("Tlf nummer", 999999999);

        System.out.println("email");
        String userEmail = ui.readString("email addresse");

        System.out.println("Password");
        String userPassword = ui.readString("gyldigt password");

        System.out.println("Tryk 1 for kunde, 2 for medarbejder");
        boolean boolMedarbejder = false;
        int userPick = ui.readInteger("1 eller 2", 3);
        if (userPick == 1) {
            boolMedarbejder = false;
        } else if (userPick == 2) {
            boolMedarbejder = true;
        }


            User u = new User(userfNavn, usereNavn, userAdresse, userPostnr, userTelefonnr, userEmail, userPassword, boolMedarbejder);

            return u;
        }

        public static void menu() {

            int valg;
            //skaber kontakt til DBsql klassen ved at lave et objekt
            DBSQL db = new DBSQL();
            //opretter ui til scanner
            UI ui = new UI();
            //fortæller brugeren deres valgmuligheder
            System.out.println(
                    "1. Opret Bruger \n" +
                            "2. Opret Bestilling \n" +
                            "3. Vis en bruger \n" +
                            "4. Vis alle brugere \n" +
                            "5. Vis en bestilling \n" +
                            "6. Vis alle bestllinger \n" +
                            "7. Afslut \n" +
                            "Indtast dit valg");
            valg = ui.readInteger("tal mellem 1 og 7", 8);
            //Et switch statement, hvor at user kan vælge imellem de forskellige cases og hver case gør noget forskelligt
            switch (valg) {
                case 1:
                    //user opretter en bruger
                    //kalder en funktion over i dbsql klassen
                    User u = opretUser();
                    db.addUser(u);

                    break;

                case 2:


                    break;

                case 3:


                    break;

                case 4:
                    //printer alle users/brugere
                    System.out.println("Vis alle brugere");
                    ArrayList<User> userListe;
                    userListe = db.getAllUsers();
                    for (int i = 0; i < userListe.size(); i++) {
                        System.out.println(userListe.get(i));
                    }
                    break;

                case 5:


                    break;

                case 6:
                    //printer alle bestillinger
                    System.out.println("Vis alle bestillinger");
                    ArrayList<Bestilling> bestillingListe;
                    bestillingListe = db.getAllBestilling();
                    for (int i = 0; i < bestillingListe.size(); i++) {
                        System.out.println(bestillingListe.get(i));
                    }

                    break;

                case 7:
                    //user vælger af afslutte og programmet lukker
                    System.out.println("Afslut");
                    //quit
                    break;


            }


        }
    }
