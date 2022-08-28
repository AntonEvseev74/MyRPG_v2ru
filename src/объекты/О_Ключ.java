package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_Ключ extends Объект {
    File файлКартинка = new File("src/ресурсы/объекты/key.png");

    public О_Ключ() {
        имя = "Ключ";
        try {
            картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_Ключ(int x, int y) {
        имя = "Ключ";
        this.мирХ = x;
        this.мирУ = y;
        установитьКартинку(файлКартинка);
    }
}
