package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import главный.ИгроваяПанель;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ОбъектПредмет implements Объект{
    public BufferedImage картинка;
    public String имя;
    public boolean этоСтолкновение = false;
    public int мирХ;
    public int мирУ;
    public Rectangle зонаВзаимодействия = new Rectangle(0,0,48,48);
    public int зонаВзаимодействияПоУмолчаниюХ = 0;
    public int зонаВзаимодействияПоУмолчаниюУ = 0;

    public boolean этоОткрыто = false;

    public void рисовать(Graphics2D g2, ИгроваяПанель игроваяПанель) {

        int экранХ = мирХ - игроваяПанель.игрок.x + игроваяПанель.игрок.экранХ;
        int экранУ = мирУ - игроваяПанель.игрок.y + игроваяПанель.игрок.экранУ;

        if (мирХ + игроваяПанель.размерПлитки > игроваяПанель.игрок.x - игроваяПанель.игрок.экранХ &&
                мирХ - игроваяПанель.размерПлитки < игроваяПанель.игрок.x + игроваяПанель.игрок.экранХ &&
                мирУ + игроваяПанель.размерПлитки > игроваяПанель.игрок.y - игроваяПанель.игрок.экранУ &&
                мирУ - игроваяПанель.размерПлитки < игроваяПанель.игрок.y + игроваяПанель.игрок.экранУ) {
            g2.drawImage(картинка, экранХ, экранУ, игроваяПанель.размерПлитки, игроваяПанель.размерПлитки, null);
        }
    }

    public void установитьКартинку(File файлКартинка){
        try {
            this.картинка = ImageIO.read(файлКартинка);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
