package com.bit.connect.demo;

public class EnumDEmo {
    public static void main(String[] args) {
        printWeekDay(Week.THURSDAY);
    }
    public static void printWeekDay(Week week){
        switch (week){
            case MONDAY:
                System.out.println("第一天");
                break;
            case TUESDAY:
                System.out.println("第二天");
                break;
            case WEDNESDAY:
                System.out.println("第三天");
                break;
            case THURSDAY:
                System.out.println("第四天");
                break;
            case FRIDAY:
                System.out.println("第五天");
                break;
            case SATURDAY:
                System.out.println("第六天");
                break;
            case SUNDAY:
                System.out.println("第七天");
                break;
        }
    }
}
