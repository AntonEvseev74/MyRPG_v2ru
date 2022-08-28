package плитки;

/* Создано: Евсеев АВ от 28.09.2022 */

import java.awt.image.BufferedImage;

public class Плитка {
    public BufferedImage картинка;
    public boolean этоСтолкновение = false;

    public Плитка() {}

    public Плитка(BufferedImage картинка, boolean этоСтолкновение) {
        this.картинка = картинка;
        this.этоСтолкновение = этоСтолкновение;
    }
}
