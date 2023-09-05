package com.radefffactory.warcardgame;

public class Card {

    int rank;
    String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getImage() {
        switch (suit) {

            case "Hearts":
                switch (rank) {
                    case 2:
                        return R.drawable.heartstwo;
                    case 3:
                        return R.drawable.heartsthree;
                    case 4:
                        return R.drawable.heartsfour;
                    case 5:
                        return R.drawable.heartsfive;
                    case 6:
                        return R.drawable.heartssix;
                    case 7:
                        return R.drawable.heartsseven;
                    case 8:
                        return R.drawable.heartseight;
                    case 9:
                        return R.drawable.heartsnine;
                    case 10:
                        return R.drawable.heartsten;
                    case 11:
                        return R.drawable.heartsjack;
                    case 12:
                        return R.drawable.heartsqueen;
                    case 13:
                        return R.drawable.heartsking;
                    case 14:
                        return R.drawable.heartsace;
                    default:
                        return R.drawable.ic_empty;
                }

            case "Diamonds":
                switch (rank) {
                    case 2:
                        return R.drawable.diamondstwo;
                    case 3:
                        return R.drawable.diamondsthree;
                    case 4:
                        return R.drawable.diamondsfour;
                    case 5:
                        return R.drawable.diamondsfive;
                    case 6:
                        return R.drawable.diamondssix;
                    case 7:
                        return R.drawable.diamondsseven;
                    case 8:
                        return R.drawable.diamondseight;
                    case 9:
                        return R.drawable.diamondsnine;
                    case 10:
                        return R.drawable.diamondsten;
                    case 11:
                        return R.drawable.diamondsjack;
                    case 12:
                        return R.drawable.diamondsqueen;
                    case 13:
                        return R.drawable.diamondsking;
                    case 14:
                        return R.drawable.diamondsace;
                    default:
                        return R.drawable.ic_empty;
                }

            case "Clubs":
                switch (rank) {
                    case 2:
                        return R.drawable.clubstwo;
                    case 3:
                        return R.drawable.clubsthree;
                    case 4:
                        return R.drawable.clubsfour;
                    case 5:
                        return R.drawable.clubsfive;
                    case 6:
                        return R.drawable.clubssix;
                    case 7:
                        return R.drawable.clubsseven;
                    case 8:
                        return R.drawable.clubseight;
                    case 9:
                        return R.drawable.clubsnine;
                    case 10:
                        return R.drawable.clubsten;
                    case 11:
                        return R.drawable.clubsjack;
                    case 12:
                        return R.drawable.clubsqueen;
                    case 13:
                        return R.drawable.clubsking;
                    case 14:
                        return R.drawable.clubsace;
                    default:
                        return R.drawable.ic_empty;
                }

            case "Spades":
                switch (rank) {
                    case 2:
                        return R.drawable.spadestwo;
                    case 3:
                        return R.drawable.spadesthree;
                    case 4:
                        return R.drawable.spadesfour;
                    case 5:
                        return R.drawable.spadesfive;
                    case 6:
                        return R.drawable.spadessix;
                    case 7:
                        return R.drawable.spadesseven;
                    case 8:
                        return R.drawable.spadeseight;
                    case 9:
                        return R.drawable.spadesnine;
                    case 10:
                        return R.drawable.spadesten;
                    case 11:
                        return R.drawable.spadesjack;
                    case 12:
                        return R.drawable.spadesqueen;
                    case 13:
                        return R.drawable.spadesking;
                    case 14:
                        return R.drawable.spadesace;
                    default:
                        return R.drawable.ic_empty;
                }

            default:
                return R.drawable.ic_empty;
        }
    }
}
