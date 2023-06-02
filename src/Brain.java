import java.util.*;
    public class Brain {
        public Stack<String> track = new Stack<String>();
        public boolean[][] visited = new boolean[41][41];

        public int posX = 20;
        public int posY = 20;

        public Brain() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                visited[i][j] = false;
            }
        }

        visited[posX][posY] = true;
    }

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        String direction = "";
        if (north && !visited[posX - 1][posY]) {
            direction = "north";
            visited[posX - 1][posY] = true;
            track.push("south");
            posX--;
        } else if (south && !visited[posX + 1][posY]) {
            direction = "south";
            visited[posX + 1][posY] = true;
            track.push("north");
            posX++;
        } else if (east && !visited[posX][posY + 1]) {
            direction = "east";
            visited[posX][posY + 1] = true;
            track.push("west");
            posY++;
        } else if (west && !visited[posX][posY - 1]) {
            direction = "west";
            visited[posX][posY - 1] = true;
            track.push("east");
            posY--;
        } else {
            direction = track.pop();
            if (direction.equals("north")) {
                posX--;
            } else if (direction.equals("south")) {
                posX++;
            } else if (direction.equals("east")) {
                posY++;
            } else if (direction.equals("west")) {
                posY--;
            }
        }
        return direction;
            }

}

