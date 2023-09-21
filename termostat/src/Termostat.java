public class Termostat {

    public double aktualnaTemperatura = 20;
    public double ustawionaTemperatura = 22;
    private boolean chlodzenie = false;
    private boolean ogrzewanie = false;
    private void wlaczOgrzewanie() {
        if (!ogrzewanie){
            System.out.println("Wlaczono Ogrzewanie.");
            ogrzewanie = true;
        }
        if (chlodzenie){
            wylaczChlodzenie();
        }
        System.out.println("Ogrzewanie...");
        aktualnaTemperatura++;
    }
    private void wylaczOgrzewanie() {
        System.out.println("Wylaczono Ogrzewanie.");
        ogrzewanie = false;
    }
    private void wlaczChlodzenie() {
        if (!chlodzenie) {
            chlodzenie = true;
            System.out.println("Wlaczono Chlodzenie.");
        }
        if (ogrzewanie){
            wylaczOgrzewanie();
        }
        System.out.println("Chlodzenie...");
        aktualnaTemperatura--;
    }
    private void wylaczChlodzenie() {
        System.out.println("Wylaczono Chlodzenie.");
        chlodzenie = false;
    }

    public void sprawdzTemperature() {
        try {
            while(aktualnaTemperatura != ustawionaTemperatura) {
                if(aktualnaTemperatura > ustawionaTemperatura){ //chlodzenie
                    wlaczChlodzenie();
                    System.out.println("Aktualna Temperatura: "+aktualnaTemperatura);
                } else { //ogrzewanie
                    wlaczOgrzewanie();
                    System.out.println("Aktualna Temperatura: "+aktualnaTemperatura);
                }
                Thread.sleep(1000);
            }
            if (ogrzewanie){
                wylaczOgrzewanie();
            } else if (chlodzenie) {
                wylaczChlodzenie();
            }
        } catch (Exception e) {
            System.out.println("Blad.");
        }
    }
}
