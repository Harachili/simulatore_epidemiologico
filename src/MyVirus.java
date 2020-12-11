
public class MyVirus implements Virus {

    // Dati del virus
    static int giornoCorrente = 1;
    final int durata;
    final double infettivita;
    final double sintomaticita;
    final double letalita;


    public MyVirus(double infettivita, double sintomaticita, double letalita, int durata) {

        this.durata = durata;
        this.infettivita = infettivita;
        this.letalita = letalita;
        this.sintomaticita = sintomaticita;
    }

    // I nuovi contagi sono i gialli in movimento moltiplicati per R0 e per una variabile double contagiabili che varia tra 0 e 1 e cambia in base al numero di verdi
    public long nuoviContagi(double R0, double contagiabili) {
        return Math.min((long) Math.ceil(R0 * (MyGoverno.Popolazione.gialli - MyGoverno.isolatiGialli) * contagiabili), MyGoverno.Popolazione.verdi - MyGoverno.isolatiVerdi);
    }
    // I nuovi sintomatici sono i gialli moltiplicati alla sintomaticità in percentuale! x: sintomaticità = gialli: 100
    public long nuoviSintomatici() {
        return (long) ((sintomaticita / 100) * MyGoverno.Popolazione.gialli);
    }
    // I nuovi morti sono i rossi moltiplicati alla letalità in percentuale! x: letalità = rossi: 100
    public long nuoviMorti() {
        return (long) ((letalita / 100) * MyGoverno.Popolazione.rossi);
    }
    // I nuovi guariti gialli sono tutti i gialli correnti meno i nuovi sintomatici
    public long nuoviGuaritiGialli(long nuoviSintomatici) {
        return (giornoCorrente>durata)? MyGoverno.Popolazione.gialli - nuoviSintomatici : 0;
    }
    // I nuovi guariti rossi sono tutti i rossi correnti meno i nuovi morti
    public long nuoviGuaritiRossi(long nuoviMorti) {
        return (giornoCorrente>durata)? MyGoverno.Popolazione.rossi - nuoviMorti : 0;
    }

    // Questo metodo mostra l'avanzamento del virus giorno dopo giorno
    @Override
    public void avanzamento(MyGoverno.Popolazione p) {

        if (giornoCorrente > durata/6) {
            // Le perone in movimento sono i verdi più i gialli, sottratti gli isolati di entrambi
            MyGoverno.Popolazione.personeInMovimento = MyGoverno.Popolazione.verdi + MyGoverno.Popolazione.gialli - MyGoverno.isolatiVerdi - MyGoverno.isolatiGialli;

            // Velocità dinamica = velocità : popolazione = x : persone in movimento
            double Vd = (double) (MyGoverno.Popolazione.velocita * MyGoverno.Popolazione.personeInMovimento) / MyGoverno.Popolazione.numeroIndividui;

            // Fattore di contagiosità
            double R0 = Vd * (infettivita / 100);               // Non moltiplico per la durata per avere l'indice di contagi giornaliero

            // contagiabili --> popolazione : 100 = p.verdi : x
            double contagiabili = (double) (MyGoverno.Popolazione.verdi - MyGoverno.isolatiVerdi) / MyGoverno.Popolazione.numeroIndividui;
            // indice che va da 1 (quando i verdi sono uguali all'intera popolazione) a 0 ( quando i verdi sono = 0)

            long nuoviContagi = nuoviContagi(R0, contagiabili);
            long nuoviSintomatici = nuoviSintomatici();
            long nuoviMorti = nuoviMorti();
            long nuoviGuaritiGialli = nuoviGuaritiGialli(nuoviSintomatici);
            long nuoviGuaritiRossi = nuoviGuaritiRossi(nuoviMorti);

            // Aggiornamento individui sani
            MyGoverno.Popolazione.verdi = MyGoverno.Popolazione.verdi - nuoviContagi;

            // Aggiornamento individui asintomatici
            MyGoverno.Popolazione.gialli = MyGoverno.Popolazione.gialli + nuoviContagi - nuoviSintomatici - nuoviGuaritiGialli;

            // Aggiornamento individui sintomatici
            MyGoverno.Popolazione.rossi = MyGoverno.Popolazione.rossi + nuoviSintomatici - nuoviMorti - nuoviGuaritiRossi;

            // Aggiornamento individui morti
            MyGoverno.Popolazione.neri = MyGoverno.Popolazione.neri + nuoviMorti;

            // Aggiornamento individui guariti
            MyGoverno.Popolazione.blu = MyGoverno.Popolazione.blu + nuoviGuaritiRossi + nuoviGuaritiGialli;

            // Dato che i gialli diminuiscono diventando rossi o blu nel corso del tempo, allora anche gli isolati gialli devono diminuire (non possono essere > gialli)
            MyGoverno.isolatiGialli = Math.min(MyGoverno.Popolazione.gialli, MyGoverno.isolatiGialli);
            // Aggiorno la popolazione totale
            MyGoverno.Popolazione.numeroIndividui -= nuoviMorti;
            // Attivazione booleano che permette tampone e isolamento
            if (MyGoverno.Popolazione.rossi > 0) MyGoverno.inizioIsolamento = true;

            if(giornoCorrente > durata && MyGoverno.Popolazione.gialli == 1) {
                MyGoverno.Popolazione.gialli--;
                MyGoverno.Popolazione.blu++;
            }

            giornoCorrente+=3;
        }

        else giornoCorrente+=3;

        MyGoverno.risorse -= (MyGoverno.isolatiVerdi + MyGoverno.isolatiGialli + MyGoverno.Popolazione.rossi * 3 * MyGoverno.costo);

    }
}