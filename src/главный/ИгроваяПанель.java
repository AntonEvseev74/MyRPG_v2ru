package главный;
/* Создано: Евсеев АВ от 28.09.2022 */

/* Все что происходит на игровом экране */

import персонажи.Игрок;
import объекты.МенеджерУстановкиОбъектов;
import объекты.Объект;
import плитки.МенеджерПлиток;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ИгроваяПанель extends JPanel implements Runnable {
    /* Параметры игрового экрана */
    final int оригинальныйРазмерПлитки = 16;
    final int масштаб = 3;
    public final int размерПлитки = оригинальныйРазмерПлитки * масштаб; // 3 * 16
    public final int ширинаЭкранаМакс = 16; // 16 плиток по горизонтали
    public final int высотаЭкранаМакс = 12; // 12 плиток по вертикали
    public final int ширинаЭкрана = размерПлитки * ширинаЭкранаМакс; // размер экрана по горизонтали 768 = (16 * 3) * 16
    public final int высотаЭкрана = размерПлитки * высотаЭкранаМакс; // размер экрана по горизонтали 576 = (16 * 3) * 12

    // Параметры игрового мира
    public final int ширинаМираМакс = 90; // к-во плиток по горизонтали
    public final int высотаМираМакс = 50; // к-во плиток по вертикали

    int FPS = 60;

    ОбработчикКлавишь обработчикКлавишь = new ОбработчикКлавишь(this);

    public Звук музыка = new Звук();
    Звук звукЭффект = new Звук();

    public МенеджерПроверкиСтолкновений менеджерПроверкиСтолкновений = new МенеджерПроверкиСтолкновений(this);
    public МенеджерУстановкиОбъектов менеджерУстановкиОбъектов = new МенеджерУстановкиОбъектов(this);
    public ЮзерИнтерфейс юзерИнтерфейс = new ЮзерИнтерфейс(this);

    Thread потокИгры;

    public Игрок игрок = new Игрок(this, обработчикКлавишь);
    МенеджерПлиток менеджерПлиток = new МенеджерПлиток(this);
    public Объект списокОбъектов[] = new Объект[10];

    public ИгроваяПанель() throws IOException {
        this.setPreferredSize(new Dimension(ширинаЭкрана, высотаЭкрана));

        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(обработчикКлавишь);
        this.setFocusable(true); // фокус на персонаже
    }

    // настройки игры (создание и расстановка игровых объектов: плитки, персонажи и т.д.)
    public void настройкаИгры() {
        менеджерУстановкиОбъектов.setObject();
        вклМузыка(0);
    }

    // запуск игры
    public void стартИгровогоПотока() {
        потокИгры = new Thread(this);
        потокИгры.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (потокИгры != null) {
            update(); // обновить
            repaint(); // перерисовать

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                if (remainingTime < 0) remainingTime = 0;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        игрок.обновить();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        менеджерПлиток.draw(g2); // TILE

        // OBJECTS
        for (int i = 0; i < списокОбъектов.length; i++) {
            if (списокОбъектов[i] != null){
                списокОбъектов[i].рисовать(g2, this);
            }
        }

        игрок.draw(g2); // PLAYER

        // UI
        юзерИнтерфейс.draw(g2);

        g2.dispose();
    }

    public void вклМузыка(int индекс){
        музыка.установитьФайл(индекс);
        музыка.вкл();
        музыка.цикл();
    }

    public void выклМузыка(){
        музыка.выкл();
    }

    public void вклЗвукЭффект(int индекс){
        звукЭффект.установитьФайл(индекс);
        звукЭффект.вкл();
    }
}
