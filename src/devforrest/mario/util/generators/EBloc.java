package devforrest.mario.util.generators;

public enum EBloc {
	PLAYER('Z'),
    GOOMBA('G'),
    KOOPA('K'),
    TILE_V('V'),
    ROTATING_BLOCK('R'),
    TILE_3('3'),
    TILE_4('4'),
    TILE_2('2'),
    QUESTION_BLOCK_Q('Q'),
    QUESTION_BLOCK_W('W'),
    RED_SHELL('S'),
    COIN('C'),
    PLATFORM('P'),
    SLOPED_TILE('9'),
    GRASS_EDGE('8'),
    GRASS_CENTER('7'),
    EMPTY(' ');

    private final char symbol;

    EBloc(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static EBloc fromChar(char c) {
        for (EBloc bloc : EBloc.values()) {
            if (bloc.symbol == c) return bloc;
        }
        return EMPTY;
    }
}
