# SimulatoreEpidemiologico
Il seguente Simulatore Epidemiologico è stato scritto in Java in cooperazione di *Morebaconstrips*. 

È un progetto nato come esercizio per casa per l'esame di Metodologie di Programmazione. Si hanno a disposizione dei virus di base (Covid 19, Peste, HIV ed Ebola) e degli
stati di default (Italia, UK, USA, Cina) nei quali tentare di gestire il virus, ma si può anche decidere i dati di stato e virus.

Ogni stato ha, infatti quattro valori da inserire, e cioè:
  - Numero di individui 
  - Quantità di risorse 
  - Costo di un tampone 
  - Numero di contatti giornalieri per persona
  
Ogni virus, invece ha sempre quattro valori da inserire: 
  - Infettività   (valore da 0 a 100 che indica quanto è probabile che un contatto tra un malato e un sano generi un infetto)
  - Sintomaticità (Valore da 0 a 100 che indica la probabilità che un contagiato sviluppi sintomi)
  - Letalità      (Valore da 0 a 100 che indica la probabilità che un malato sintomatico muoia)
  - Durata        (Numero di giorni che intercorrono fra momento del contagio e quello della guarigione)

Il simulatore è mancante di una GUI, ma si può vedere da terminale come decorra il virus, e decidere giorno per giorno se:
  - 1 ==> Avanzare al giorno successivo
  - 2 ==> Isolare/togliere dall'isolamento un numero di individui
  - 3 ==> Eseguire il test del tampone

Isolamento e tampone possono essere eseguiti solo quando il primo sintomatica è stato identificato.

L'isolamento, in generale, diminuisce il numero di contatti di ogni persona. Si può decidere il numero di persone da mettere in isolamento

Il tampone invece diminuisce le risorse del paese e trova altri x contagiati che dà in output. Il numero di persone a cui effettuare il tampone è da inserire manualmente.

Se il numero di infetti && il numero di sintomatici sono 0, e la popolazione non è completamente morta, si vince. 
Attenzione alla bancarotta del paese e all'estinzione del genere umano!
Have fun!
