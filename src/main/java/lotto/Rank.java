package lotto;

public enum Rank {
    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(6, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return SIX;
        if (matchCount == 5 && hasBonus) return FIVE_BONUS;
        if (matchCount == 5) return FIVE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 3) return THREE;
        return NONE;
    }
}
