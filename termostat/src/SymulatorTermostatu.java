import java.util.Scanner;

public class SymulatorTermostatu {
    public static void main(String[] args) {
        Termostat ts = new Termostat();
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("Podaj temperature do ustawienia: ");
            try {
                ts.ustawionaTemperatura = s.nextByte();
                if (ts.ustawionaTemperatura > 40 || ts.ustawionaTemperatura < -10){
                    System.out.println("Upewnij sie ze wpisujesz pelna liczbe w zakresie od -10 do 40.");
                    continue;
                }
                ts.sprawdzTemperature();
            } catch(Exception e) {
                System.out.println("Upewnij sie ze wpisujesz pelna liczbe w zakresie od -10 do 40.");
            }
        }
    }
}
