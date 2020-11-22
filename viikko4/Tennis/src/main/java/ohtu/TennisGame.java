package ohtu;

import static java.lang.Math.abs;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String[] pointNames;
    private String score;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        this.score = "";

        this.pointNames = new String[4];
        this.pointNames[0] = "Love";
        this.pointNames[1] = "Fifteen";
        this.pointNames[2] = "Thirty";
        this.pointNames[3] = "Forty";

    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        int tempScore = 0;

        if (isTie()) {
            setTieScore();
        } else if (playerHasWinOrAdvantage()) {
            
            int minusResult = m_score1 - m_score2;
            
            if (abs(minusResult) <= 1) {
                setAdvantageScore();
            } else {
                setWinningScore();
            }
            
        } else {
            setBasicScore();
        }
        return score;
    }

    public boolean isTie() {
        return this.m_score1 == this.m_score2;
    }

    public void setTieScore() {
        if (m_score1 < 4) {
            score = this.pointNames[m_score1] + "-All";
        } else {
            score = "Deuce";
        }
    }

    public boolean playerHasWinOrAdvantage() {
        if (m_score1 >= 4 || m_score2 >= 4) {
            return true;
        }

        return false;
    }

    public void setAdvantageScore() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        }
    }

    public void setWinningScore() {
        int minusResult = m_score1 - m_score2;
        if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
    }

    public void setBasicScore() {
        score = pointNames[m_score1] + "-" + pointNames[m_score2];
    }
}
