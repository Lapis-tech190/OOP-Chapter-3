public class Container {
    public static void main(String[] args) {

        Ball ball = new Ball(555, 555, 5, 55, 30);

        Container box = new Container(5, 5, 500, 500);
        for (int step = 0; step < 100; step++) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball);
        }
    }

    private double x1, x2, y1, y2;
     public Container(double x, double y, double width, double height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width - 1;
        this.y2 = y + height - 1;
    }


    @Override
    public String toString() {
        return String.format("Container at (%.2f, %.2f) to (%.2f, %.2f)", x1, y1, x2, y2);
    }


    public boolean collidesWith(Ball ball) {
        boolean collision = false;
        if (ball.getX() - ball.getRadius() < x1 || ball.getX() + ball.getRadius() > x2) {
            ball.reflectHorizontal();
            collision = true;
        }
        if (ball.getY() - ball.getRadius() < y1 || ball.getY() + ball.getRadius() > y2) {
            ball.reflectVertical();
            collision = true;
        }

        return collision;
    }
}
