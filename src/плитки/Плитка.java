package плитки;

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
