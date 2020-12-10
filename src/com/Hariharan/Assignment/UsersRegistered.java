package com.Hariharan.Assignment;

public class UsersRegistered {
    private String userName;
    private long userLotteryNumber;

    public UsersRegistered(String userName,long userLotteryNumber) {
        this.userName = userName;
        this.userLotteryNumber=userLotteryNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserLotteryNumber() {
        return userLotteryNumber;
    }

    public void setUserLotteryNumber(long userLotteryNumber) {
        this.userLotteryNumber=userLotteryNumber;
    }

    @Override
    public String toString() {
        return "UsersRegistered { " +
                "UserName = " + userName + '\'' +
                " , UserLotteryNumber = " + userLotteryNumber +
                '}';
    }
}
