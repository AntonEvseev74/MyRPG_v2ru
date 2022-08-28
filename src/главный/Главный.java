package главный;

/* Создано: Евсеев АВ от 28.09.2022 */

import javax.swing.*;
import java.io.IOException;

public class Главный {
    private String имя = "Моя РПГ 2 на рус";

    public static void main(String[] args) throws IOException {
        Главный главный = new Главный();
        главный.старт();
    }

    private void старт() throws IOException {
        JFrame окно = new JFrame();
        окно.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        окно.setResizable(false);
        окно.setTitle(имя);

        ИгроваяПанель игроваяПанель = new ИгроваяПанель();
        окно.add(игроваяПанель);
        окно.pack();

        окно.setLocationRelativeTo(null);
        окно.setVisible(true);

        игроваяПанель.настройкаИгры();
        игроваяПанель.стартИгровогоПотока();
    }

}
