package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import главный.ИгроваяПанель;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Объект {
    public BufferedImage картинка;
    public String имя;
    public boolean этоСтолкновение = false;
    public int worldX;
    public int worldY;
    public Rectangle зонаВзаимодействия = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public boolean этоОткрыто = false;

    public void draw(Graphics2D g2, ИгроваяПанель игроваяПанель) {

        int экранХ = worldX - игроваяПанель.игрок.x + игроваяПанель.игрок.экранХ;
        int экранУ = worldY - игроваяПанель.игрок.y + игроваяПанель.игрок.экранУ;

        if (worldX + игроваяПанель.размерПлитки > игроваяПанель.игрок.x - игроваяПанель.игрок.экранХ &&
                worldX - игроваяПанель.размерПлитки < игроваяПанель.игрок.x + игроваяПанель.игрок.экранХ &&
                worldY + игроваяПанель.размерПлитки > игроваяПанель.игрок.y - игроваяПанель.игрок.экранУ &&
                worldY - игроваяПанель.размерПлитки < игроваяПанель.игрок.y + игроваяПанель.игрок.экранУ) {
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
