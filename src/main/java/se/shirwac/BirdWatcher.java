package se.shirwac;

import java.util.Arrays;
import java.util.Scanner;

public class BirdWatcher {
    private int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        super();
        this.birdsPerDay = birdsPerDay;
        

    }
    public void mellanrum(){
        System.out.println("");
    }

    public void run(){
        Scanner input = new Scanner(System.in);
        boolean run = true;
        String senastevecka;

        while(run){
        System.out.println("***Välkommen till BirdWatcher***");
        System.out.println("");
        System.out.println("(1) För att se senaste veckan ");
        System.out.println("(2) Lägg till dagens fåglar ");
        System.out.println("(3) Öka med dagens fåglar");
        System.out.println("(4) Titta upp om det finns någon dag utan fåglar");
        System.out.println("(5) Titta hur många dagar det har varit med många fåglar");
        System.out.println("(6) Exit");
        int val = input.nextInt();

        if(val == 1){
            senastevecka = getLastWeek(birdsPerDay);
            System.out.println(senastevecka);
            mellanrum();
        } 
        else if(val == 2){
            System.out.println("Hur många fåglar har du sett hittils?");
            int birdsToday = input.nextInt();
            getToday(birdsPerDay, birdsToday);
            mellanrum();  
        }
        if(val == 3){
            System.out.println("Hur många fåglar vill du öka med?");
            int increment = input.nextInt();
            incrementDayCount(birdsPerDay, increment);
            mellanrum();    
        }
        if(val == 4){
            hasDayWithoutBirds(birdsPerDay);
            if(hasDayWithoutBirds(birdsPerDay)){
                System.out.println("Ja en dag var utan fåglar");
                mellanrum();
            }
            else
            System.out.println("Nej alla dagar har det varit fåglar");
            mellanrum();
            
        }
        if(val == 5){
            System.out.println("Det var " + getBusyDays(birdsPerDay) + " dagar som var ganska mycket fåglar");
            mellanrum();
        }
        if(val == 6){
            System.out.println("Tack för din tid;");
            mellanrum();
            run = false;
            input.close();
        }
    }
       
    }
    public String getLastWeek(int [] birdsPerDay) {
        String lastWeek =Arrays.toString(birdsPerDay);
        return lastWeek;
    }

    public int getToday(int [] birdsPerDay, int birdsToday){
        int n = 1;
        for(int i = 0; i < n; i++){
            int j;
            for( j = 0; j < birdsPerDay.length - 1; j++ ){
                birdsPerDay[j] = birdsPerDay[j+1];
            }
            birdsPerDay[6] = birdsToday;
        }
        int today = birdsPerDay[6];
        return today;
    }

    public int incrementDayCount(int [] birdsPerDay, int increment){
        birdsPerDay[6] = birdsPerDay[6] + increment;       
        return birdsPerDay [6];
    
    }

    public boolean hasDayWithoutBirds(int [] birdsPerDay){
        boolean dayWithoutBirds = false; 
        for (int i : birdsPerDay) {
            if(i == 0){
               dayWithoutBirds = true;
               break;
            }
            else
            dayWithoutBirds = false;
        }
            return dayWithoutBirds;
        }


    
    public int getBusyDays(int [] birdsPerDay){
        int busydays = 0;
        for(int i : birdsPerDay){
            if(i >= 5){
                busydays++;
            }
        }
        return busydays;

    }
}

    

