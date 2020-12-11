public interface Governo {

    public void isolamento(boolean b, long nIV, long nIG);                                //Strumento 1
    //L'isolamento diminuisce il numero di contatti di ogni persona
    // Diminuisce il parametro velocità
    //modifica il parametro popolazioneInMovimento, parametro inizialmente uguale a popolazione e che si modifica con il tempo

    public void tampone(long tampone);                   //Strumento 2
    //diminuisce le risorse in base al costo C*persone
    //trova altri x contagiati che dà in output
}
