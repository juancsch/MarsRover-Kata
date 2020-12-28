package es.juanc.katas.marsrover;

public class App {

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            System.out.println(
                paintWorld(10, 10)
            );
            Thread.sleep(1000);
        }
    }

    private static String paintWorld(int height, int width) {
        var world = "";
        for (int colunm = 0; colunm < height; colunm++) {
            world += "\n|";
            for (int file = 0; file < width; file++) {
                world += Math.round(Math.random()) == 0 ? " |" : "*|";
            }
        }
        return world;
    }
}
