package объекты.персонажи.орки;

import объекты.ОбъектПерсонаж;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Орк extends ОбъектПерсонаж {

    File файлКартинка = new File("src/ресурсы/персонажи/орк/orc.png");

    public Орк() {
        имя = "Орк";
        try {
            картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Орк(int x, int y) {
        имя = "Орк";
        this.мирХ = x;
        this.мирУ = y;
        атака = 3;
        установитьКартинку(файлКартинка);
    }
}
