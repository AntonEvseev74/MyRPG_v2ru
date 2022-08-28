package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_Сундук extends Объект {
    File файлКартинка = new File("src/ресурсы/объекты/chest.png");

    public О_Сундук() {
        имя = "Сундук";
        try {
            картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_Сундук(int x, int y) {
        имя = "Сундук";
        this.мирХ = x;
        this.мирУ = y;
        this.этоСтолкновение = true;
        установитьКартинку(файлКартинка);
    }
}
