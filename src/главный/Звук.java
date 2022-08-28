package главный;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Звук {

    Clip клип;
    File[] списокЗвуков = new File[30];

    public Звук() {
        списокЗвуков[0] = new File("src/ресурсы/звук/gameb.wav");
        списокЗвуков[1] = new File("src/ресурсы/звук/coin.wav");
        списокЗвуков[2] = new File("src/ресурсы/звук/powerup.wav");
        списокЗвуков[3] = new File("src/ресурсы/звук/dooropen.wav");
        списокЗвуков[4] = new File("src/ресурсы/звук/fanfare.wav");
    }

    public void установитьФайл(int индекс){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(списокЗвуков[индекс]);
            клип = AudioSystem.getClip();
            клип.open(ais);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void вкл(){
        клип.start();
    }

    public void цикл(){
        клип.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void выкл(){
        клип.stop();
    }
}
