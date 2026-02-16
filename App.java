import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Instrument> instruments = new ArrayList<>();

        while (true) {

            System.out.println("1) Lisää soitin");
            System.out.println("2) Listaa soittimet");
            System.out.println("3) Viritä kielisoittimet");
            System.out.println("4) Soita rumpuja");
            System.out.println("0) Lopeta ohjelma");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) {
                System.out.println("Kiitos ohjelman käytöstä.");
                break;
            }

            switch (choice) {

                case 1:
                    System.out.println("Minkä soittimen haluat lisätä? 1) Kitara, 2) Viulu, 3) Rummut");
                    int instrumentChoice = Integer.parseInt(scanner.nextLine());

                    System.out.println("Anna valmistajan nimi:");
                    String manufacturer = scanner.nextLine();

                    System.out.println("Anna hinta euroina:");
                    int price = Integer.parseInt(scanner.nextLine());

                    if (instrumentChoice == 1) {
                        instruments.add(new Guitar(manufacturer, price));
                        System.out.println("Soitin lisätty listaan! ");
                    } else if (instrumentChoice == 2) {
                        instruments.add(new Violin(manufacturer, price));
                        System.out.println("Soitin lisätty listaan! ");
                    } else if (instrumentChoice == 3) {
                        instruments.add(new Drum(manufacturer, price));
                        System.out.println("Soitin lisätty listaan!");
                    } else {
                        System.out.println("Virheellinen soitinvalinta.");
                    }
                    break;

                case 2:
                    if (instruments.isEmpty()) {
                        System.out.println("Ei lisättyjä soittimia.");
                    } else {
                        for (Instrument instrument : instruments) {
                            System.out.println(instrument.getDetails());
                        }
                    }
                    break;

                case 3:
                    for (Instrument instrument : instruments) {
                        if (instrument instanceof StringInstrument) {
                            StringInstrument stringInstrument = (StringInstrument) instrument;
                            stringInstrument.tune();
                        }
                    }
                    break;

                case 4:
                    for (Instrument instrument : instruments) {
                        if (instrument instanceof Drum) {
                            Drum drum = (Drum) instrument;
                            drum.playBeat();
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }
}
