class Ball2 {
    private double x, y, radius, xDelta, yDelta;


    public Ball2(double x, double y, double radius, double speed, double direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        double radians = Math.toRadians(direction);
        this.xDelta = speed * Math.cos(radians);
        this.yDelta = -speed * Math.sin(radians); // Đảo ngược trục y
    }


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
        return String.format("Ball at (%.2f, %.2f)", x, y);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getRadius() { return radius; }
}