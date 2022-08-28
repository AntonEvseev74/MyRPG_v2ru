package плитки;

/* Создано: Евсеев АВ от 28.09.2022 */

import главный.ИгроваяПанель;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class МенеджерПлиток {
    ИгроваяПанель игроваяПанель;
    public Плитка[] плитка;
    public int списокПлитокКарты[][];

    File t = new File("src/ресурсы/фон/grass.png"); // трава
    File t1 = new File("src/ресурсы/фон/water.png"); // вода
    File t2 = new File("src/ресурсы/фон/wall.png"); // стена
    File t3 = new File("src/ресурсы/фон/sand.png"); // песок
    File t4 = new File("src/ресурсы/фон/cobble.png"); // брусчатка
    File t5 = new File("src/ресурсы/фон/tree1.png"); // дерево 1
    File t6 = new File("src/ресурсы/фон/tree2.png"); // дерево 2
    File t7 = new File("src/ресурсы/фон/tree3.png"); // дерево 3
    File t8 = new File("src/ресурсы/фон/floor_h.png"); // пол горизонтальный
    File t9 = new File("src/ресурсы/фон/floor_v.png"); // пол вертикальный

    public МенеджерПлиток(ИгроваяПанель игроваяПанель) {
        this.игроваяПанель = игроваяПанель;
        плитка = new Плитка[10]; // массив на 10 тайлов
        списокПлитокКарты = new int[игроваяПанель.ширинаМираМакс][игроваяПанель.высотаМираМакс];

        установитьПлиткеКартинку();
        // loadMap("/ресурсы/карты/map01.txt");
        загрузитьКарту("/ресурсы/карты/world01.txt");
    }

    private void установитьПлиткеКартинку() {
        try {
            плитка[0] = new Плитка(ImageIO.read(t), false);
            плитка[1] = new Плитка(ImageIO.read(t1), true);
            плитка[2] = new Плитка(ImageIO.read(t2), true);
            плитка[3] = new Плитка(ImageIO.read(t3), false);
            плитка[4] = new Плитка(ImageIO.read(t4), false);
            плитка[5] = new Плитка(ImageIO.read(t5), true);
            плитка[6] = new Плитка(ImageIO.read(t6), true);
            плитка[7] = new Плитка(ImageIO.read(t7), true);
            плитка[8] = new Плитка(ImageIO.read(t8), false);
            плитка[9] = new Плитка(ImageIO.read(t9), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void загрузитьКарту(String путьКФайлу) {
        try {
            InputStream is = getClass().getResourceAsStream(путьКФайлу);
            BufferedReader буферДляЧтения = new BufferedReader(new InputStreamReader(is));

            int столбец = 0;
            int строка = 0;

            while (столбец < игроваяПанель.ширинаМираМакс && строка < игроваяПанель.высотаМираМакс) {
                String строкаКарты = буферДляЧтения.readLine();
                while (столбец < игроваяПанель.ширинаМираМакс) {
                    String списокКодовДляПлиток[] = строкаКарты.split(" ");
                    int кодПлитки = Integer.parseInt(списокКодовДляПлиток[столбец]);
                    списокПлитокКарты[столбец][строка] = кодПлитки;
                    столбец++;
                }
                if (столбец == игроваяПанель.ширинаМираМакс) {
                    столбец = 0;
                    строка++;
                }
            }

            буферДляЧтения.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int мирСтолбец = 0;
        int мирСтрока = 0;

        while (мирСтолбец < игроваяПанель.ширинаМираМакс && мирСтрока < игроваяПанель.высотаМираМакс) {
            int индексПлитки = списокПлитокКарты[мирСтолбец][мирСтрока];

            int мирХ = мирСтолбец * игроваяПанель.размерПлитки;
            int мирУ = мирСтрока * игроваяПанель.размерПлитки;
            int экранХ = мирХ - игроваяПанель.игрок.x + игроваяПанель.игрок.экранХ;
            int экранУ = мирУ - игроваяПанель.игрок.y + игроваяПанель.игрок.экранУ;

            if (мирХ + игроваяПанель.размерПлитки > игроваяПанель.игрок.x - игроваяПанель.игрок.экранХ &&
                    мирХ - игроваяПанель.размерПлитки < игроваяПанель.игрок.x + игроваяПанель.игрок.экранХ &&
                    мирУ + игроваяПанель.размерПлитки > игроваяПанель.игрок.y - игроваяПанель.игрок.экранУ &&
                    мирУ - игроваяПанель.размерПлитки < игроваяПанель.игрок.y + игроваяПанель.игрок.экранУ) {
                g2.drawImage(плитка[индексПлитки].картинка, экранХ, экранУ, игроваяПанель.размерПлитки, игроваяПанель.размерПлитки, null);
            }

            мирСтолбец++;

            if (мирСтолбец == игроваяПанель.ширинаМираМакс) {
                мирСтолбец = 0;
                мирСтрока++;
            }
        }
    }
}
