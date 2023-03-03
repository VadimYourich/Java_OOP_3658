package seminar_1.hw2;

/**
 * Описать в ООП стиле, логику взаимодействия объектов реального мира между собой: 
 * шкаф-человек. Какие члены должны быть у каждого из классов (у меня на семинаре 
 * студенты пришли к тому, чтобы продумать логику взаимодействия жена разрешает 
 * открыть дверцу шкафа мужу, после чего эту дверцу можно открыть)
 */

public class ObjectsInteraction {
    public static void main(String[] args) {
        Wife wife = new Wife();
        Husband husband = new Husband();
        Closet closet = new Closet();

        husband.openCloset(closet);
        husband.getPermission(wife, closet);
        husband.openCloset(closet);
        husband.openCloset(closet);
    }
}
