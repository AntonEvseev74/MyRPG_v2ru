package объекты;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_ЗельеУскорения extends Объект {
    File imageFile = new File("src/ресурсы/зелья/potion_speed.png");

    public О_ЗельеУскорения() {
        имя = "Ускорение";
        try {
            картинка = ImageIO.read(imageFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_ЗельеУскорения(int worldX, int worldY) {
        имя = "Ускорение";
        this.worldX = worldX;
        this.worldY = worldY;
        установитьКартинку(imageFile);
    }
}
