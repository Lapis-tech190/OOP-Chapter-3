public class Ball {
    public static void main(String[] args) {

        Ball ball = new Ball(555, 555, 5, 55, 30);
        Container box = new Container(5, 5, 500, 500);

        for (int step = 0; step < 100; step++) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball);
        }
    }
    private double x, y, radius, xDelta, yDelta;

    public Ball(double x, double y, double radius, double speed, double direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;


        double radians = Math.toRadians(direction);
        this.xDelta = speed * Math.cos(radians);
        this.yDelta = -speed * Math.sin(radians);
    }


    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }
    public double getXDelta() { return xDelta; }
    public double getYDelta() { return yDelta; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setRadius(double radius) { this.radius = radius; }
    public void setXDelta(double xDelta) { this.xDelta = xDelta; }
    public void setYDelta(double yDelta) { this.yDelta = yDelta; }


    public void move() {
        x += xDelta;
        y += yDelta;
    }


    public void reflectHorizontal() {
        xDelta = -xDelta;
    }


    public void reflectVertical() {
        yDelta = -yDelta;
    }


    @Override
    public String toString() {
        return String.format("Ball at (%.2f, %.2f) of velocity (%.2f, %.2f)", x, y, xDelta, yDelta);
    }
}
