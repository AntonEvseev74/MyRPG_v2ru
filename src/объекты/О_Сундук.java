package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_Сундук extends Объект {
    File imageFile = new File("src/ресурсы/объекты/chest.png");

    public О_Сундук() {
        имя = "Сундук";
        try {
            картинка = ImageIO.read(imageFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_Сундук(int worldX, int worldY) {
        имя = "Сундук";
        this.worldX = worldX;
        this.worldY = worldY;
        this.этоСтолкновение = true;
        установитьКартинку(imageFile);
    }
}
