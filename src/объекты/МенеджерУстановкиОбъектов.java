package объекты;

/* Создано: Евсеев АВ от 28.09.2022 */

import главный.ИгроваяПанель;

public class МенеджерУстановкиОбъектов {
    ИгроваяПанель gp;

    public МенеджерУстановкиОбъектов(ИгроваяПанель gp) {
        this.gp = gp;
    }

    public void setObject(){
       // int i = 0;
      //  gp.obj[i] = new O_Key(2 * gp.tileSize, 6 * gp.tileSize);
      //  i++;
      //  gp.obj[i] = new O_Key(12 * gp.tileSize, 6 * gp.tileSize);
      //  i++;

        addObject(0, new О_Ключ(13 * gp.размерПлитки, 16 * gp.размерПлитки));
        addObject(1, new О_Ключ(15 * gp.размерПлитки, 16 * gp.размерПлитки));
        addObject(2, new О_Дверь(14 * gp.размерПлитки, 13 * gp.размерПлитки));
        addObject(3, new О_Сундук(13 * gp.размерПлитки, 12 * gp.размерПлитки));
        addObject(4, new О_ЗельеУскорения(14 * gp.размерПлитки, 12 * gp.размерПлитки));
    }

    private void addObject(int index, Объект obj){
        gp.списокОбъектов[index] = obj;
    }
}
