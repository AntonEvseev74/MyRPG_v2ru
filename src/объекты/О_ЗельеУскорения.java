package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_ЗельеУскорения extends Объект {
    File файлКартинка = new File("src/ресурсы/зелья/potion_speed.png");

    public О_ЗельеУскорения() {
        имя = "Ускорение";
        try {
            картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_ЗельеУскорения(int x, int y) {
        имя = "Ускорение";
        this.мирХ = x;
        this.мирУ = y;
        установитьКартинку(файлКартинка);
    }
}
