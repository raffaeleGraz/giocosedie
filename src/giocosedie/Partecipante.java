package giocosedie;

class Partecipante extends Thread

{
    Posto sedie[];

    public Partecipante(Posto sedie[]) {

        this.sedie = sedie;

    }

    public void run() {

        try {

            sleep((int) (Math.random() * 1000));
            
            Scrittore scrittore = new Scrittore("Risultati.txt");

            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    
                        System.out.println("Sono il Thread " + this.getName()
                                        + ". Sono riuscito a sedermi sul posto " + i);
                        
                        // Se non è l'ultima sedia
                        if(i < sedie.length - 1){
                            String risultato = "Giocatore " + this.getName() + " con ID " + this.getId()+ " posto => " +  i;
                            scrittore.scrivi(risultato);
                        }
                        else{
                            scrittore.scrivi("\n");
                        }

                        return;
                }
            }
            System.out.println("Sono il Thread " + this.getName()
                            + ". Ho perso :((((");

        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }
}
