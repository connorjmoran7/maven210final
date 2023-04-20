package edu.guilford.basicwordle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameUser { // Creates a new player class -> draws from textfield for data.

    // Attributes for each user
    private static String username;
    private static int gamesWon;
    private static double winPercentage; // gamesWon / totalGamesPlayed
    private static int threeGamesPlayed;
    private static int fourGamesPlayed;
    private static int fiveGamesPlayed;
    private static int sixGamesPlayed;
    private static int sevenGamesPlayed;
    private static int totalGamesPlayed;

    ArrayList<GameUser> userList = new ArrayList<>();

    // constructor
    public GameUser() {

    }

    public GameUser(String username) {

    }

    public GameUser(String username, int totalGamesPlayed, int gamesWon, double winPercentage,
            int threeGamesPlayed, int fourGamesPlayed, int fiveGamesPlayed,
            int sixGamesPlayed, int sevenGamesPlayed) {
        GameUser.username = username;
        GameUser.gamesWon = gamesWon;
        GameUser.winPercentage = winPercentage;
        GameUser.threeGamesPlayed = threeGamesPlayed;
        GameUser.fourGamesPlayed = fourGamesPlayed;
        GameUser.fiveGamesPlayed = fiveGamesPlayed;
        GameUser.sixGamesPlayed = sixGamesPlayed;
        GameUser.sevenGamesPlayed = sevenGamesPlayed;
        GameUser.totalGamesPlayed = totalGamesPlayed;
    }

    // getters and setters for all attributes
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        GameUser.username = username;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        GameUser.gamesWon = gamesWon;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(double winPercentage) {
        GameUser.winPercentage = winPercentage;
    }

    public int getThreeGamesPlayed() {
        return threeGamesPlayed;
    }

    public void setThreeGamesPlayed(int threeGamesPlayed) {
        GameUser.threeGamesPlayed = threeGamesPlayed;
    }

    public int getFourGamesPlayed() {
        return fourGamesPlayed;
    }

    public void setFourGamesPlayed(int fourGamesPlayed) {
        GameUser.fourGamesPlayed = fourGamesPlayed;
    }

    public int getFiveGamesPlayed() {
        return fiveGamesPlayed;
    }

    public void setFiveGamesPlayed(int fiveGamesPlayed) {
        GameUser.fiveGamesPlayed = fiveGamesPlayed;
    }

    public int getSixGamesPlayed() {
        return sixGamesPlayed;
    }

    public void setSixGamesPlayed(int sixGamesPlayed) {
        GameUser.sixGamesPlayed = sixGamesPlayed;
    }

    public int getSevenGamesPlayed() {
        return sevenGamesPlayed;
    }

    public void setSevenGamesPlayed(int sevenGamesPlayed) {
        GameUser.sevenGamesPlayed = sevenGamesPlayed;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        GameUser.totalGamesPlayed = totalGamesPlayed;
    }

    public void PlayerFileManager() {
        try {
            File playerData = new File(username + "PlayerData.txt");
            if (playerData.createNewFile()) {
                System.out.println("File created: " + playerData.getName());
                CreateUserFile();
                System.out.println("User profile created.");
            } else {
                System.out.println("File already exists: " + username + "PlayerData.txt");
                UpdateUserFile();
                //CreateUserFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void CreateUserFile() { // Creates player files
        try {
            FileWriter statWriter = new FileWriter(username + "PlayerData.txt");
            statWriter.write(totalGamesPlayed + " " + gamesWon
                    + " " + String.format("%.2f", (Double.valueOf(gamesWon) / totalGamesPlayed) * 100)
                    + " " + threeGamesPlayed + " " + fourGamesPlayed + " "
                    + fiveGamesPlayed + " " + sixGamesPlayed + " " + sevenGamesPlayed);
            statWriter.close();
            try {
                String tempName = username + "PlayerData.txt";
                File tempFile = new File(tempName);
                try ( Scanner fileScan = new Scanner(tempFile)) {
                    while (fileScan.hasNext()) {
                        int totalGamesPlayed1 = fileScan.nextInt();
                        int gamesWon1 = fileScan.nextInt();
                        double winPercentage1 = fileScan.nextDouble();
                        int threeGamesPlayed1 = fileScan.nextInt();
                        int fourGamesPlayed1 = fileScan.nextInt();
                        int fiveGamesPlayed1 = fileScan.nextInt();
                        int sixGamesPlayed1 = fileScan.nextInt();
                        int sevenGamesPlayed1 = fileScan.nextInt();
                        GameUser tempUser = new GameUser(username, totalGamesPlayed1, gamesWon1, winPercentage1,
                                threeGamesPlayed1, fourGamesPlayed1, fiveGamesPlayed1,
                                sixGamesPlayed1, sevenGamesPlayed1);
                        userList.add(tempUser);
                    }
                    fileScan.close();
                }

                // Grabs data from the file
                int GP = userList.get(0).getTotalGamesPlayed();
                int gW = userList.get(0).getGamesWon();
                int threeGP = userList.get(0).getThreeGamesPlayed();
                int fourGP = userList.get(0).getFourGamesPlayed();
                int fiveGP = userList.get(0).getFiveGamesPlayed();
                int sixGP = userList.get(0).getSixGamesPlayed();
                int sevenGP = userList.get(0).getSevenGamesPlayed();

                int newGP = GP + 1;
                if (GamePanel.getWinIndicator() == 1) {
                    gW = gW + 1;
                    System.out.println("games won up");
                } else if (GamePanel.getWinIndicator() == 0) {
                    System.out.println("games won not changed");
                }
                String newWP = String.format("%.2f", (Double.valueOf(gW) / newGP) * 100);

                int gameType = GamePanel.getGameIndicator();
                if (gameType == 3) {
                    threeGP = threeGP + 1;
                    System.out.println(3);
                } else if (gameType == 4) {
                    fourGP = fourGP + 1;
                    System.out.println(4);
                } else if (gameType == 5) {
                    fiveGP = fiveGP + 1;
                    System.out.println(5);
                } else if (gameType == 6) {
                    sixGP = sixGP + 1;
                    System.out.println(6);
                } else if (gameType == 7) {
                    sevenGP = sevenGP + 1;
                    System.out.println(7);
                }

                int newThreeGP = threeGP;
                int newFourGP = fourGP;
                int newFiveGP = fiveGP;
                int newSixGP = sixGP;
                int newSevenGP = sevenGP;

                FileWriter updateWriter = new FileWriter(tempName);
                updateWriter.write(newGP + " " + gW + " " + newWP
                        + " " + newThreeGP + " " + newFourGP + " " + newFiveGP
                        + " " + newSixGP + " " + newSevenGP);
                updateWriter.close();
                userList.remove(0);
                System.out.println("File updated and closed.");
                String playerDataString = "User: " + username
                        + "\nGames Played: " + newGP
                        + "\nGames Won: " + gW
                        + "\nWin Percentage: " + newWP
                        + "\nThree Letter Games: " + newThreeGP
                        + "\nFour Letter Games: " + newFourGP
                        + "\nFive Letter Games: " + newFiveGP
                        + "\nSix Letter Games: " + newSixGP
                        + "\nSeven Letter Games: " + newSevenGP;
                GamePanel.setPlayerDataString(playerDataString);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Wrote to file: " + username + "PlayerData.txt");
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void UpdateUserFile() { // In cases where a user is returning, this happens
        try {
            String tempName = username + "PlayerData.txt";
            File tempFile = new File(tempName);
            try ( Scanner fileScan = new Scanner(tempFile)) {
                while (fileScan.hasNext()) {
                    int totalGamesPlayed1 = fileScan.nextInt();
                    int gamesWon1 = fileScan.nextInt();
                    double winPercentage1 = fileScan.nextDouble();
                    int threeGamesPlayed1 = fileScan.nextInt();
                    int fourGamesPlayed1 = fileScan.nextInt();
                    int fiveGamesPlayed1 = fileScan.nextInt();
                    int sixGamesPlayed1 = fileScan.nextInt();
                    int sevenGamesPlayed1 = fileScan.nextInt();
                    GameUser tempUser = new GameUser(username, totalGamesPlayed1, gamesWon1, winPercentage1,
                            threeGamesPlayed1, fourGamesPlayed1, fiveGamesPlayed1,
                            sixGamesPlayed1, sevenGamesPlayed1);
                    userList.add(tempUser);
                }
                fileScan.close();
            }

            // Grabs data from the file
            int GP = userList.get(0).getTotalGamesPlayed();
            int gW = userList.get(0).getGamesWon();
            int threeGP = userList.get(0).getThreeGamesPlayed();
            int fourGP = userList.get(0).getFourGamesPlayed();
            int fiveGP = userList.get(0).getFiveGamesPlayed();
            int sixGP = userList.get(0).getSixGamesPlayed();
            int sevenGP = userList.get(0).getSevenGamesPlayed();

            int newGP = GP + 1;
            if (GamePanel.getWinIndicator() == 1) {
                gW = gW + 1;
                System.out.println("games won up");
            } else if (GamePanel.getWinIndicator() == 0) {
                System.out.println("games won not changed");
            }
            String newWP = String.format("%.2f", (Double.valueOf(gW) / newGP) * 100);

            int gameType = GamePanel.getGameIndicator();
            if (gameType == 3) {
                threeGP = threeGP + 1;
                System.out.println(3);
            } else if (gameType == 4) {
                fourGP = fourGP + 1;
                System.out.println(4);
            } else if (gameType == 5) {
                fiveGP = fiveGP + 1;
                System.out.println(5);
            } else if (gameType == 6) {
                sixGP = sixGP + 1;
                System.out.println(6);
            } else if (gameType == 7) {
                sevenGP = sevenGP + 1;
                System.out.println(7);
            }

            int newThreeGP = threeGP;
            int newFourGP = fourGP;
            int newFiveGP = fiveGP;
            int newSixGP = sixGP;
            int newSevenGP = sevenGP;

            FileWriter updateWriter = new FileWriter(tempName);
            updateWriter.write(newGP + " " + gW + " " + newWP
                    + " " + newThreeGP + " " + newFourGP + " " + newFiveGP
                    + " " + newSixGP + " " + newSevenGP);
            updateWriter.close();
            userList.remove(0);
            System.out.println("File updated and closed.");
            String playerDataString = "User: " + username
                    + "\nGames Played: " + newGP
                    + "\nGames Won: " + gW
                    + "\nWin Percentage: " + newWP
                    + "\nThree Letter Games: " + newThreeGP
                    + "\nFour Letter Games: " + newFourGP
                    + "\nFive Letter Games: " + newFiveGP
                    + "\nSix Letter Games: " + newSixGP
                    + "\nSeven Letter Games: " + newSevenGP;
            GamePanel.setPlayerDataString(playerDataString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
