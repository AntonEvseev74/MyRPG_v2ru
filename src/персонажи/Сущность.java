package персонажи;

/* Создано: Евсеев АВ от 28.09.2022 */

import java.awt.*;
import java.awt.image.BufferedImage;

public class Сущность {
 //  public static final String ВЕРХ = "верх";
 //  public static final String НИЗ = "низ";
 //  public static final String ЛЕВО = "лево";
 //  public static final String ПРАВО = "право";

    public int x, y; // координаты
    public int скорость; // скорость
    public BufferedImage верх1, верх2, верх3, низ1, низ2, низ3, лево1, лево2, лево3, право1, право2, право3; // картинки
    public String направление; // направление движения персонажа
    public int счетчикКадров = 0;
    public int номерКадра = 1;

    public Rectangle зонаВзаимодействия; // прямоугольник (твердая часть сущности, которая упирается в объекты)
    public int зонаВзаимодейстияОригинальнаяX, зонаВзаимодейстияОригинальнаяY;
    public boolean этоСтолкновение = false;
}
