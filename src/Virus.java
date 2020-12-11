public interface Virus {
/*
Popolazione:


-Verdi
S(n+1) = S(n) − γI(n)*S(n) //VERDI MENO NUOVI INFETTI

-Gialli
I(n+1) = I(n) + γI(n)*S(n) − qI(n) - S*I(n) //GIALLI DI PRIMA + NUOVI GIALLI - [GIALLI-->(BLU + ROSSI)]

-Rossi
M(n+1) = M(n) + S*I(n) - L*M(n) - q*M(n) //ROSSI DI PRIMA + NUOVI ROSSI - MORTI - GUARITI

-Blu
B(n+1) = B(n) + q*I(n) + q*M(n) //BLU DI PRIMA + NUOVI BLU

-Neri
R(n+1) = R(n) + L*M(n) //MORTI DI PRIMA + NUOVI MORTI


Nell'interfaccia virus inizializziamo un metodo avanzamento che ci permette
di applicare le formule soprastanti per vedere come cambiano i parametri della
popolazione al variare dei giorni in base alle strategie.
Se l'utente continuasse ad andare avanti senza modificare nessun parametro, il virus continuerebbe ad
espandersi giorno dopo giorno senza incontrare ostacoli.
*/
    public void avanzamento(MyGoverno.Popolazione p);
}
