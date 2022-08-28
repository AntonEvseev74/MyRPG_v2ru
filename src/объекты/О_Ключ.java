package объекты;

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

    public О_Ключ(int worldX, int worldY) {
        имя = "Ключ";
        this.worldX = worldX;
        this.worldY = worldY;
        установитьКартинку(файлКартинка);
    }
}
