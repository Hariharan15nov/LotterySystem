package com.Hariharan.Assignment;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class Main {
    public static long Lotterynumber = 100000000000L;
    public static UsersRegistered user = null;
    public static TreeMap<Long, String> Users = new TreeMap<>();

    public static void main(String[] args) {
        addUser();
        LotteryWinners winners = new LotteryWinners();
        winners.printResult();
    }
            public static void addUser () {
               Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run () {
                        String userName;
                        for (int i = 0; i < 10000000; i++) {
                            userName = generateName();
                            Lotterynumber++;
                            Users.put(Lotterynumber, userName);
                            user = new UsersRegistered(userName, Lotterynumber);
                        }
                    }
                    },0,3600000);

            }
            private static String generateName () {
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 5;
                Random random = new Random();

                String generatedName = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                return generatedName;
            }
        }

