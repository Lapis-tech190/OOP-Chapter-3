public class SoccerGame {
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Player player1 = new Player("Player 1", 10, 10);
        Player player2 = new Player("Player 2", 20, 20);
        Field field = new Field(100, 100);


        for (int step = 0; step < 10; step++) {
            player1.kick(ball);
            field.checkBoundary(ball);
            System.out.println(ball);
            player2.kick(ball);
            field.checkBoundary(ball);
            System.out.println(ball);
        }
    }
}