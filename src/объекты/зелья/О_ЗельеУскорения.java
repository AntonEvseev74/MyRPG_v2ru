package объекты.зелья;

/* Создано: Евсеев АВ от 28.09.2022 */

import объекты.ОбъектПредмет;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static константы.Константа.ЗЕЛЬЕ_УСКОРЕНИЯ;

public class О_ЗельеУскорения extends ОбъектПредмет {
    File файлКартинка = new File("src/ресурсы/зелья/potion_speed.png");

    public О_ЗельеУскорения() {
        имя = ЗЕЛЬЕ_УСКОРЕНИЯ;
        try {
            картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_ЗельеУскорения(int x, int y) {
        имя = ЗЕЛЬЕ_УСКОРЕНИЯ;
        this.мирХ = x;
        this.мирУ = y;
        установитьКартинку(файлКартинка);
    }
}
