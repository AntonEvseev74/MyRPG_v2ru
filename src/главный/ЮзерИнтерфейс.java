package главный;

import объекты.О_Ключ;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ЮзерИнтерфейс {
    ИгроваяПанель игроваяПанель;
    Font arial_40_PLAIN;
    Font arial_80_BOLD;

    BufferedImage картинкаКлюча;
    public boolean messageOn = false;
    public String сообщение = "";
    int сообщениеТаймер = 0;

    public boolean этоКонецИгры = false;

    public ЮзерИнтерфейс(ИгроваяПанель игроваяПанель) {
        this.игроваяПанель = игроваяПанель;
        arial_40_PLAIN = new Font("Arial", Font.PLAIN, 32);
        arial_80_BOLD = new Font("Arial", Font.BOLD, 80);
        О_Ключ ключ = new О_Ключ();
        картинкаКлюча = ключ.картинка;
    }

    public void showMessage(String text) {
        сообщение = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        if (этоКонецИгры) { // Если кнец игры
            g2.setFont(arial_40_PLAIN);
            g2.setColor(Color.white);

            String text = "!!!!!!!!!!!!!!Вы нашли сундук!!!!!!!!!!!!!!!";
            int textLength= (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x = игроваяПанель.ширинаЭкрана / 2 - textLength / 2;
            int y = игроваяПанель.высотаЭкрана / 2 - (игроваяПанель.размерПлитки * 3);
            g2.drawString(text, x, y);

            g2.setFont(arial_80_BOLD);
            g2.setColor(Color.red);
            text = "ИГРА ОКОНЧЕНА";
            textLength= (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = игроваяПанель.ширинаЭкрана / 2 - textLength / 2;
            y = игроваяПанель.высотаЭкрана / 2 + (игроваяПанель.размерПлитки * 2);
            g2.drawString(text, x, y);

            игроваяПанель.музыка.выкл();
            игроваяПанель.потокИгры = null;
        } else { // если игра не окончена
            g2.setFont(arial_40_PLAIN);
            g2.setColor(Color.white);

            // верхний левый угол. Инфо о ключах
            g2.drawImage(картинкаКлюча, игроваяПанель.размерПлитки / 2, игроваяПанель.размерПлитки / 2, игроваяПанель.размерПлитки / 2, игроваяПанель.размерПлитки / 2, null);
            g2.drawString("x" + игроваяПанель.игрок.собраныеКлючи, игроваяПанель.размерПлитки, игроваяПанель.размерПлитки);

            // Сообщение
            if (messageOn) {
                g2.drawString(сообщение, игроваяПанель.размерПлитки, игроваяПанель.размерПлитки * 5);
                g2.setFont(g2.getFont().deriveFont(16f));

                // Таймер показа сообщения при взаимодействии с предметами
                сообщениеТаймер++;
                if (сообщениеТаймер > 120) {
                    сообщениеТаймер = 0;
                    messageOn = false;
                }
            }
        }
    }
}
