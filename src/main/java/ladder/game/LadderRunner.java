package ladder.game;

import ladder.model.LadderPosition;
import ladder.model.Position;
import ladder.model.Row;

public class LadderRunner {
    Row[] rows;
    public LadderRunner(Row[] rows){
        this.rows = rows;
    }

    public int run(Position position) {

        for(int i = 0; i < rows.length; i++) {
            StringBuilder sb = printLadderLine(LadderPosition.of(Position.fromValue(i),position));
            System.out.println(sb);
            position = rows[i].nextPosition(position);
            sb= printLadderLine(LadderPosition.of(Position.fromValue(i),position));
            System.out.println(sb);
        }

        return position.getPosition();
    }

    public StringBuilder printLadderLine(LadderPosition ladderPosition){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< rows.length;i++){
            rows[i].printRow(sb,Position.fromValue(i),ladderPosition);
        }
        return sb;
    }
}
