public class Position {
    // Node class
    private float[][] board;
    private Position[] children;

    public Position(float[][] board, Position[] children) {
        this.board = board;
        this.children = children;
    }

    public float[][] get_board() { return board; }
    public Position[] get_children() { return children; }
    public void set_board(float[][] board) { this.board = board; }
    public void set_left(Position[] children) { this.children = children; }
}
