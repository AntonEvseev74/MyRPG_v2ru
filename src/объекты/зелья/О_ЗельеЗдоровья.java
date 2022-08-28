package объекты.зелья;

/* Создано: Евсеев АВ от 28.09.2022 */

import объекты.ОбъектПредмет;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static константы.Константа.ЗЕЛЬЕ_ЗДОРОВЬЯ;

public class О_ЗельеЗдоровья extends ОбъектПредмет {

    File файлКартинка = new File("src/ресурсы/зелья/potion_hp.png");

    public О_ЗельеЗдоровья() {
        имя = ЗЕЛЬЕ_ЗДОРОВЬЯ;
        try {
            картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_ЗельеЗдоровья(int x, int y) {
        имя = ЗЕЛЬЕ_ЗДОРОВЬЯ;
        this.мирХ = x;
        this.мирУ = y;
        установитьКартинку(файлКартинка);
    }
}
