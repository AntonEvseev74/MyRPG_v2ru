package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class О_Дверь extends Объект {
    File imageFile = new File("src/ресурсы/объекты/door.png");
    File imageFileOpenDoor = new File("src/ресурсы/объекты/door_open.png");


    public О_Дверь() {
        имя = "Дверь";
        try {
            картинка = ImageIO.read(imageFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public О_Дверь(int worldX, int worldY) {
        имя = "Дверь";
        this.worldX = worldX;
        this.worldY = worldY;
        this.этоСтолкновение = true;
        установитьКартинку(imageFile);
    }

    public О_Дверь(int worldX, int worldY, boolean collision) {
        имя = "Дверь";
        this.worldX = worldX;
        this.worldY = worldY;
        this.этоСтолкновение = collision;

        if (collision) установитьКартинку(imageFile); // если true - закрытая дверь
        else {
            установитьКартинку(imageFileOpenDoor);   // если false - окрытая дверь
            этоОткрыто = true;
        }
    }

}
