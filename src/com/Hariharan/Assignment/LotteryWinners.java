package com.Hariharan.Assignment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryWinners extends Main {
    public void printResult() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                System.out.println("List of users  :  " + Users);
                TreeSet<Long> ThousandWinners = new TreeSet<>();
                TreeSet<Long> TenThousandWinners = new TreeSet<>();
                ArrayList<Long> hundredWinnerList = new ArrayList<>();
                ArrayList<Long> fiveWinnerList = new ArrayList<>();

                //one luckiest winner

                Long LuckiestWinner = ThreadLocalRandom.current().nextLong(100000000001L, 100000001000L);
                System.out.println("One Luckiest Winner : \n\n" + Users.get(LuckiestWinner) + " - " + LuckiestWinner + "  ->  Won 1 Million Rupees\n");

                Users.remove(LuckiestWinner,Users.get(LuckiestWinner));

                //five lucky winners

                for (int i = 0; i < 5; i++) {
                    Long fiveluckyUsers = ThreadLocalRandom.current().nextLong(100000000001L, 100000100000L);
                    TenThousandWinners.add(fiveluckyUsers);
                }
                fiveWinnerList.addAll(TenThousandWinners);
                System.out.println("*******************************************\n");
                System.out.println("Five Lucky Winners :\n");
                fiveWinnerList.forEach(s -> {
                    System.out.println(Users.get(s) + " - " + s + " -> " + " 10000 Rupees");
                    Users.remove(s, Users.get(s));
                });

                //hundred lucky winners

                for (int i = 0; i < 100; i++) {
                    Long hundredluckyUsers = ThreadLocalRandom.current().nextLong(100000000001L, 100000010000L);
                    ThousandWinners.add(hundredluckyUsers);
                }
                hundredWinnerList.addAll(ThousandWinners);
                System.out.println("*****************************************************\n");
                System.out.println("Hundred Lucky Winners :\n");
                hundredWinnerList.forEach(s -> {
                    System.out.println(Users.get(s) + " - " + s + " -> " + " 1000 Rupees");
                    Users.remove(s, Users.get(s));
                });

                //Happy credits for all users
                System.out.println("\n********************************************\n");
                System.out.println("Remaining users : Happy credits\n");
                Users.keySet().stream().map(s -> Users.get(s) + " - " + s + " -> " + ThreadLocalRandom.current().nextInt(1, 10) + " rupees\n").forEach(System.out::print);
            }
        }, 1000, 3600000);
    }
}
