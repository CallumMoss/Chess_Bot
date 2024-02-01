public class Minimax {

    private float[][] best_move_white;
    private float[][] best_move_black;

    public float[][] get_best_move_white() { return best_move_white; }
    public float[][] get_best_move_black() { return best_move_black; }

    // maximizing player is true if white, black if false. Takes it in turns
    public float minimax(Position position, int depth, Boolean maximizing_player) {
        if (depth == 0) { // base case
            return evaluate_position(position.get_board());
        }
        if (maximizing_player) {
            // rate of pruning increases if moves are evaled from best to worst
            // can weight this, for example if it is taking a piece 
            float max_eval = Float.MIN_VALUE;
            for (Position child_position : position.get_children()) {
                float eval = minimax(child_position, depth - 1, false); // Switch to the next player
                if(eval >= max_eval) {
                    best_move_white = child_position.get_board();
                    max_eval = eval;
                }
            }
            return max_eval;
        } else {
            float min_eval = Float.MAX_VALUE;
            for (Position child_position : position.get_children()) {
                float eval = minimax(child_position, depth - 1, true); // Switch to the next player
                if(eval <= min_eval) {
                    best_move_black = child_position.get_board();
                    min_eval = eval;
                }
            }
            return min_eval;
        }
    }
    

    public static float evaluate_position(float[][] position) {
        float eval = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                eval+= position[i][j];
            }
        }
        return eval;
    }
}
