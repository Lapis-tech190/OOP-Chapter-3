class Player {
    private String name;
    private double x, y;

    public Player(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    // Phương thức đá bóng
    public void kick(Ball ball) {
        System.out.println(name + " kicks the ball!");
        ball.move();
    }

    @Override
    public String toString() {
        return "Player " + name + " at (" + x + ", " + y + ")";
    }
}
