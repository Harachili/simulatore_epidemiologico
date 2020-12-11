import java.util.Scanner;

public class TestSimulatoreEpidemiologico { // Main Function
    // Modello epidemiologico Kormack-McKendrick del 1927
    // SIR model -> Susceptible, Infectious, or Recovered

    public static void main(String[] args) {
        vasoDiPetunie();
    }

    public static void vasoDiPetunie() {

        // INTERFACCIA UTENTE (UI per i più studiati)

        // Dichiarazione parametri di input
        long numeroIndividui = 0;
        long risorse = 0;
        int costo = 0;
        int velocita = 0;
        double infettivita = 0;
        double sintomaticita = 0;
        double letalita = 0;
        int durata = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("\nBenvenuto nel nostro simulatore epidemiologico!\n");
        System.out.println("Preferisci usare i dati demografici di un paese noto oppure preferisci crearne uno personalizzato?\n1 ==> Default\n2 ==> Personalizzato");

        int paese = sc.nextInt();

        // Scelta di un paese di default tra Italia, UK, USA, Cina
        while(true) {
            if (paese == 1) {
                System.out.println("\nScegli un paese:\n1 ==> Italia\n2 ==> UK\n3 ==> USA\n4 ==> Cina");
                int sceltaPaese = sc.nextInt();

                if (sceltaPaese == 1) {
                    System.out.println("\nI dati demografici dell'Italia sono:");
                    numeroIndividui = 60359546;
                    risorse = 1_800_000_000L;
                    costo = 30;
                    velocita = 10;
                    System.out.println("Numero individui: " + numeroIndividui + "\nRisorse: " + risorse + "€" + "\nCosto del tampone: " + costo + "€");
                    break;
                }
                if (sceltaPaese == 2) {
                    System.out.println("\nI dati demografici del Regno Unito sono:");
                    numeroIndividui = 67545757;
                    risorse = 2_000_000_000L;
                    costo = 250;  // telegraph.co.uk il prezzo in sterline è di circa 250 £
                    velocita = 10;
                    System.out.println("Numero individui: " + numeroIndividui + "\nRisorse: " + risorse + "£" + "\nCosto del tampone: " + costo + "£");
                    break;
                }
                if (sceltaPaese == 3) {
                    System.out.println("\nI dati demografici degli Stati Uniti sono:");
                    numeroIndividui = 329_311_764L;
                    risorse = 6_500_000_000L;
                    costo = 1000;  // usatoday.com il prezzo in dollari è di circa 1000$
                    velocita = 10;
                    System.out.println("Numero individui: " + numeroIndividui + "\nRisorse: " + risorse + "$" + "\nCosto del tampone: " + costo + "$");
                    break;
                }
                if (sceltaPaese == 4) {
                    System.out.println("\nI dati demografici della Cina sono:");
                    numeroIndividui = 1_433_783_686;
                    risorse = 28_600_000_000L;
                    costo = 180;  // ANSA.it il prezzo in Yuan è di circa 180¥
                    velocita = 10;
                    System.out.println("Numero individui: " + numeroIndividui + "\nRisorse: " + risorse + " ¥" + "\nCosto del tampone: " + costo + " ¥");
                    break;
                } else {
                    System.out.println("Un numero tra 1 e 4, estremi inclusi!");
                }
            }

            // Parametri dello Stato inseriti dall'utente nel caso in cui accanni il default
            else {

                // ASPETTI GENERALI
                System.out.println("Numero individui: ");
                numeroIndividui = sc.nextLong();             // Popolazione iniziale

                System.out.println("Risorse: ");
                risorse = sc.nextLong();                     // Risorse iniziali

                System.out.println("Costo tampone: ");
                costo = sc.nextInt();                        // Costo del singolo tampone

                System.out.println("Velocità: ");
                velocita = sc.nextInt();                     // Numero medio di incontri per persona
            }
        }


        System.out.println("\nPreferisci usare i dati di un virus noto oppure preferisci crearne uno personalizzato?\n1 ==> Default\n2 ==> Personalizzato");
        int sceltaVirus = sc.nextInt();

        // Scelta di un virus di default tra COVID, peste, HIV, ebola
        while(true) {
            if (sceltaVirus == 1) {
                System.out.println("\nScegli un virus:\n1 ==> Coronavirus\n2 ==> Peste\n3 ==> HIV\n4 ==> Ebola");
                int i2 = sc.nextInt();
                if (i2 == 1) { // Coronavirus
                    System.out.println("\nI dati epidemiologici del COVID-19 sono:");
                    infettivita = 60;
                    sintomaticita = 55; // laleggepertutti.it
                    letalita = 5;
                    durata = 21;
                    System.out.println("Infettività: " + (int) infettivita + "%" + "\nSintomaticità: " + (int) sintomaticita + "%" + "\nLetalità: " + (int) letalita + "%" + "\nDurata: " + durata + " giorni");
                    break;
                }
                if (i2 == 2) { // Peste
                    System.out.println("\nI dati epidemiologici della peste sono:");
                    infettivita = 65;
                    sintomaticita = 80;
                    letalita = 50;     // wikipedia.it
                    durata = 20;
                    System.out.println("Infettività: " + (int) infettivita + "%" + "\nSintomaticità: " + (int) sintomaticita + "%" + "\nLetalità: " + (int) letalita + "%" + "\nDurata: " + durata + " giorni");
                    break;
                }
                if (i2 == 3) { // HIV
                    System.out.println("\nI dati epidemiologici dell'HIV sono:");
                    infettivita = 10;
                    sintomaticita = 90;
                    letalita = 50;
                    durata = 20;
                    System.out.println("Infettività: " + (int) infettivita + "%" + "\nSintomaticità: " + (int) sintomaticita + "%" + "\nLetalità: " + (int) letalita + "%" + "\nDurata: " + durata + " giorni");
                    break;
                }
                if (i2 == 4) { // Ebola
                    System.out.println("\nI dati epidemiologici dell'ebola sono:");
                    infettivita = 20;
                    sintomaticita = 90;
                    letalita = 64;     // wikipedia.it
                    durata = 20;
                    System.out.println("Infettività: " + (int) infettivita + "%" + "\nSintomaticità: " + (int) sintomaticita + "%" + "\nLetalità: " + (int) letalita + "%" + "\nDurata: " + durata + " giorni");
                    break;
                } else {
                    System.out.println("Un numero tra 1 e 4, estremi inclusi!");
                }
            }


            // Parametri del virus inseriti dall'utente nel caso in cui accanni i default
            else {

                System.out.println("Creazione del virus personalizzato\n");

                // ASPETTI SANITARI
                System.out.println("Infettività: ");
                infettivita = sc.nextDouble();   // Probabilità che un individuo sano venga infettato

                System.out.println("Sintomaticità: ");
                sintomaticita = sc.nextDouble(); // Probabilità che un contagiato sviluppi sintomi

                System.out.println("Letalità: ");
                letalita = sc.nextDouble();      // Probabilità che un malato sintomatico muoia

                System.out.println("Durata: ");
                durata = sc.nextInt();           // Numero di giorni che intercorrono fra momento del contagio e quello della guarigione
            }
        }

        Virus V = new MyVirus(infettivita, sintomaticita, letalita, durata);
        MyGoverno Conte = new MyGoverno(risorse, costo);
        MyGoverno.Popolazione italiani = new MyGoverno.Popolazione(numeroIndividui, velocita);

        while (true) { // Inizio simulazione
            // Scelta per l'utente di avanzare al giorno successivo, isolare o togliere dall'isolamento o eseguire il tampone ai sani
            System.out.println("\nScegli cosa fare: \n1 ==> Avanza al giorno successivo\n2 ==> Isola/togli dall'isolamento un numero di individui\n3 ==> Esegui il test del tampone");

            int scelta = sc.nextInt();

            if (scelta == 1) {
                V.avanzamento(italiani);
                System.out.println("_________________________________________________");
                System.out.println("| Giorno " + (MyVirus.giornoCorrente - 1));
                System.out.println("| Risorse: " + MyGoverno.risorse);
                System.out.println("| Sani: " + MyGoverno.Popolazione.verdi + ", di cui " + MyGoverno.isolatiVerdi + " isolati");
                System.out.println("| Infetti asintomatici: " + MyGoverno.Popolazione.gialli + ", di cui " + MyGoverno.isolatiGialli + " isolati");
                System.out.println("| Infetti sintomatici: " + MyGoverno.Popolazione.rossi);
                System.out.println("| Guariti: " + MyGoverno.Popolazione.blu);
                System.out.println("| Morti: " + MyGoverno.Popolazione.neri);
                System.out.println("_________________________________________________");
            }

            else if (scelta == 2) {
                System.out.println("Hai scelto 'isolamento'");
                System.out.println("Vuoi far iniziare o finire l'isolamento?\n1 ==> Inizio isolamento\n2 ==> Fine isolamento");
                int s1 = sc.nextInt();
                if (s1 == 1) {
                    System.out.println("\nInserisci il numero di persone sane da isolare: ");
                    long s2 = sc.nextLong();
                    Conte.isolamento(true, s2, 0);
                } else if (s1 == 2) {
                    System.out.println("Inserisci il numero di persone sane da togliere dall'isolamento: ");
                    long s2 = sc.nextLong();
                    Conte.isolamento(false, s2, 0);
                }
            } else if (scelta == 3) {
                System.out.println("Hai scelto 'Test del tampone'");
                System.out.println("Inserisci il numero di persone da sottoporre al test del tampone");
                long s1 = sc.nextLong();
                Conte.tampone(s1);
                System.out.println("Sani: " + MyGoverno.Popolazione.verdi + ", di cui " + MyGoverno.isolatiVerdi + " isolati");
                System.out.println("Infetti asintomatici: " + MyGoverno.Popolazione.gialli + ", di cui " + MyGoverno.isolatiGialli + " isolati");
                System.out.println("Infetti sintomatici: " + MyGoverno.Popolazione.rossi);
                System.out.println("Guariti: " + MyGoverno.Popolazione.blu);
                System.out.println("Morti: " + MyGoverno.Popolazione.neri + "\n");
            }
            // Condizione di bancarotta
            if (MyGoverno.risorse <= 0) {
                System.out.println("Lo stato è andato in bancarotta");
                break;
            }
            //Condizione di estinzione del genere umano
            else if (MyGoverno.Popolazione.neri == numeroIndividui) {
                System.out.println("L'epidemia ha vinto, il genere umano si è estinto. Press F to pay respect: ");
                String F = sc.next();
                if(F.equals("F")) {
                    System.out.println("You paid respect for the human kind! <3");
                } else {
                    System.out.println("A 'nfame");
                }
                break;
            }
            //Condizione di vittoria simulazione
            else if (MyGoverno.Popolazione.gialli + MyGoverno.Popolazione.rossi == 0 && MyGoverno.Popolazione.blu >= 1) {
                System.out.println("Congratulazioni! L'epidemia è stata debellata!");
                break;
            }
        }

        System.out.println("\nVuoi simulare una nuova epidemia?\n1 ==> Si\n2 ==> No");
        int ricominicia = sc.nextInt();
        if (ricominicia == 1) {
            MyGoverno.isolatiVerdi = 0;
            MyGoverno.isolatiGialli = 0;
            MyVirus.giornoCorrente = 1;
            vasoDiPetunie();
        }
        else
            System.out.println("\nA presto!");
    }
}
