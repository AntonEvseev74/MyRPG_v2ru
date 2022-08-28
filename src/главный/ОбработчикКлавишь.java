package главный;

/* Создано: Евсеев АВ от 28.09.2022 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ОбработчикКлавишь implements KeyListener {

    public boolean этоНажатоВВерх, этоНажатоВНиз, этоНажатоВЛево, этоНажатоВПраво;

    ИгроваяПанель игроваяПанель;

    public ОбработчикКлавишь(ИгроваяПанель игроваяПанель) {
        this.игроваяПанель = игроваяПанель;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int кодНажатойКлавиши = e.getKeyCode();
        if (кодНажатойКлавиши == KeyEvent.VK_W) {
            этоНажатоВВерх = true;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_S) {
            этоНажатоВНиз = true;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_A) {
            этоНажатоВЛево = true;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_D) {
            этоНажатоВПраво = true;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_SHIFT) {
            игроваяПанель.игрок.скорость += 7;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int кодНажатойКлавиши = e.getKeyCode();
        if (кодНажатойКлавиши == KeyEvent.VK_W) {
            этоНажатоВВерх = false;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_S) {
            этоНажатоВНиз = false;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_A) {
            этоНажатоВЛево = false;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_D) {
            этоНажатоВПраво = false;
        }
        if (кодНажатойКлавиши == KeyEvent.VK_SHIFT) {
            игроваяПанель.игрок.скорость = 4;
        }
    }
}
