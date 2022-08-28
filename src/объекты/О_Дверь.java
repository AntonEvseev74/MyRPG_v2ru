package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_Дверь extends ОбъектПредмет {
    File файлКартинкаЗакрытаяДверь = new File("src/ресурсы/объекты/door.png");
    File файлКартинкаОткрытаяДверь = new File("src/ресурсы/объекты/door_open.png");


    public О_Дверь() {
        имя = "Дверь";
        try {
            картинка = ImageIO.read(файлКартинкаЗакрытаяДверь);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_Дверь(int x, int y) {
        имя = "Дверь";
        this.мирХ = x;
        this.мирУ = y;
        this.этоСтолкновение = true;
        установитьКартинку(файлКартинкаЗакрытаяДверь);
    }

    public О_Дверь(int x, int y, boolean этоСтолкновение) {
        имя = "Дверь";
        this.мирХ = x;
        this.мирУ = y;
        this.этоСтолкновение = этоСтолкновение;

        if (этоСтолкновение) установитьКартинку(файлКартинкаЗакрытаяДверь); // если true - закрытая дверь
        else {
            установитьКартинку(файлКартинкаОткрытаяДверь);   // если false - окрытая дверь
            этоОткрыто = true;
        }
    }

}
