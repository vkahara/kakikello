import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import javax.sound.sampled.*;

public class kakiKello {

    public static void main(String[] args) throws InterruptedException {

        while (true) {

            LocalTime aika = LocalTime.now();

            DateTimeFormatter ajanFormatoija = DateTimeFormatter.ofPattern("hh:mm ");
            String formatoituAika = aika.format(ajanFormatoija);

            String vainMinuutit = formatoituAika.substring(3, 5);
            String vainTunnit = formatoituAika.substring(0, 2);

            int tunnitInteger = Integer.parseInt(vainTunnit);
            int minuutitInteger = Integer.parseInt(vainMinuutit);

            int i = tunnitInteger;

            if (minuutitInteger == 00) {

                System.out.println("Kello on: " + formatoituAika);

                while (i > 0) {
                    System.out.println("Kukkuu");
                    try {
                        File yourFile = new File("/home/valtteri/ohjelmointi/kakikello/cuckoo.wav");
                        AudioInputStream stream;
                        AudioFormat format;
                        DataLine.Info info;
                        Clip clip;

                        stream = AudioSystem.getAudioInputStream(yourFile);
                        format = stream.getFormat();
                        info = new DataLine.Info(Clip.class, format);
                        clip = (Clip) AudioSystem.getLine(info);
                        clip.open(stream);
                        clip.start();
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }

                    i--;

                }

                Thread.sleep(60000);
            }
        }

    }

}
