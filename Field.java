class Field {
    private double width, height;

    public Field(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void checkBoundary(Ball ball) {
        if (ball.getX() - ball.getRadius() < 0 || ball.getX() + ball.getRadius() > width) {
            ball.reflectHorizontal();
        }
        if (ball.getY() - ball.getRadius() < 0 || ball.getY() + ball.getRadius() > height) {
            ball.reflectVertical();
        }
    }

    @Override
    public String toString() {
        return String.format("Field with width %.2f and height %.2f", width, height);
    }
}
