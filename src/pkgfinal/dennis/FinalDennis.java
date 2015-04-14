/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.dennis;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Jake Dennis
 */
public class FinalDennis {
private static boolean x;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter printWinLoss = new PrintWriter("WinLose.txt");
        //DISPLAYS MY NAME 
        System.out.println("This game was created by Jake Dennis \n");
        
        //access the method that creates random cards
        Hands newCard = new Hands();
        CardName cardString = new CardName();
        
        
        //declares the variable for the players chip total and prints it out (10)
        int PC = 10;
        System.out.println("your chip count is " + PC);
        //declares and lets the player know how many chips it takes to play a game of BlackJack (2)
        int TB = 2;
        System.out.println("you need to bet " + TB + " chips to play");
        //does the math for the player to let them know how many chips they will have after betting
        PC = PC - TB;
        System.out.println("after betting you would have " + PC + " left ");
        //add back the bet to give the player the correct starting amount if they decide not to play and bet
        PC = PC + TB; 
        
        System.out.println("By winnning you will double the amount of chips you have in the pot \n");
        
        
        //declares a variable that will be used to stop the loop asking if the player wants to keep playing 
        int gameloopstop = 0;
        
        //while loop that continues if a player chooses yes to continue playing
        //NESTING WHILE
        while ((gameloopstop < 1) && (PC > 0)){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to play another game of Blackjack? (type Y or N)");
        //ACCEPTS STRING INPUTS
        String YorNplay = keyboard.nextLine();
        
        
        //if the player does not want to keep playing the betloopstop changes to 1 which stops the while loop
        if ("N".equals(YorNplay)){
            
        gameloopstop = 1;
        //shows results of chips and possibly games won after player decides they want to stop playing
        System.out.println("Your chip count is now " + PC);
        
        }
        
        //if the player types Y the code continues on to play the game
        if ("Y".equals(YorNplay)){
            
        //sutracts the total bet from the players chips for real and prints out their chip total

        
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
            int changebetloop = 0;
            //NESTED WHILE
            while (changebetloop < 1){
            System.out.println("Would you like to wager more than 2 chips?");
            
            String YorNbetmore = keyboard.next();
                
            switch (YorNbetmore) {
                    case "Y":
                        System.out.println("Please enter the amount you want to bet");
                        int  newTB = keyboard.nextInt();
                        if (newTB <= PC){             
                            
                            TB = newTB;
                            changebetloop = 1;
                        }
                        else if (newTB > PC){
                            
                            System.out.println("You do not have enough chips to make that bet");
                            
                        }
                        break;
                    case "N":
                        changebetloop = 1;
                        break;
                }
            }
  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++      
        PC = PC - TB;
        
        System.out.println("After you bet " + TB + " chip(s) your chip count is " + PC);
        
        int PT = 0;
        int DT = 0;
        
        final int maxHand = 21;
        int [] dealerArray = new int [maxHand];
        int [] playerArray = new int [maxHand];
        //create random hands for the dealer and player
        
        //use the randomCard method to create a random card and check the hand total to decide how an ace is used intially (see method notes for details)
        int HD = newCard.randomCard(DT);
        //declares the correct dealer total
        DT = DT + HD;
        dealerArray [1] = HD;
        newCard.holdHand(dealerArray);

        int SD = newCard.randomCard(DT);
        String stringSD = cardString.cardType(SD);
        DT = DT + SD;
        dealerArray [2] = SD;
        newCard.holdHand(dealerArray);
        
        int HP = newCard.randomCard(PT);
        String stringHP = cardString.cardType(HP);
        PT = PT + HP;
        playerArray [1] = HP;
        newCard.holdHand(playerArray);
        
        int SP = newCard.randomCard(PT);
        String stringSP = cardString.cardType(SP);
        PT = PT + SP;
        playerArray [2] = SP;
        newCard.holdHand(playerArray);

        
        //shows the player's current hand
        //++++++++need to make an if statement for if the hand contains 11 and the total is over 21 subtract 10 
        //probably do this in later card statement
        int playerHand[] = newCard.holdHand(playerArray);
            System.out.print("Here is your current hand ");
            for(int a = 0; a < playerHand.length; a++){
            
            if (playerHand[a]>0){
               
               System.out.print(" " + playerHand[a] + " "); 
            }
            }
        System.out.println("\n"); 
        //prints out the two cards the player has individually
        System.out.println("your hidden card is a " + stringHP);
        System.out.println("your shown card is a " + stringSP + "\n");
        
        //add the player's two cards together and prints them out 
        //PT = HP + SP;
        System.out.println("your total hand is " + PT + "\n");
        
        //Lets the player know that the dealer's show card is to better determine if they want to bet
        System.out.println("the dealer's show card is a " + stringSD + "\n");
        
        //adds the two cards in the dealer's had behind the scenes 
        //DT = HD + SD;
        

        
        //declares a variable that will be used to stop the loop asking if the player wants another card
        int cardloopstop = 0;
        //counter starting at three related to the "Y I want a card" answer to change with a ++ to add 1 to the next array point and save the next number within the array
        int count = 3;
        //creates a while loop that continues to ask a player if they would like another card if their total is less than 21
        //loopstop is compared to 1 to act as a stop point in case the player stops asking for cards before their total exceeds 21
        
        while ((PT < 21) && (cardloopstop < 1)){
            
            
            System.out.println("would you like another card? ");
            String YorNcard = keyboard.next();
            
            //if the player chooses yes to wanting another card the card is print and so is their new total
            //after this code runs the while loop continues because the cardloopstop is still 0
            if ("Y".equals(YorNcard)){
                 //use the randomCard method to create a random card and check the hand total to decide how an ace is used intially (see method notes for details)
                int newSP = newCard.randomCard(PT);
                String stringnewSP = cardString.cardType(newSP);
                //adds the new shown card from the player to the player total
                PT = PT + newSP;
                // 
                //the player array starts counting from 3 to continue where the array left off
                playerArray [count++] = newSP;
                //the player array is input to the method to save the random inputs
                newCard.holdHand(playerArray);
                //
                System.out.print("Here is your current hand ");
                for(int a = 0; a < playerHand.length; a++){

                if (playerHand[a]>0){

                   System.out.print(" " + playerHand[a] + " "); 
                }
                }
                
                //
                System.out.println("Your new card is a " + stringnewSP);
                System.out.println("Your hand total is now " + PT);
                
                //the had needs to be analyzed if this card is a 21 for the player+++++++++++++++++++++++++++++++++++++++++++
                //NESTED IF
                if (PT == 21){
                while (DT < 17){
                    
                    int card = newCard.randomCard(DT);
                    DT = DT + card;
                    System.out.println("The dealers new shown card is " + card);
                    System.out.println("The dealers show total is now  " + DT);  
                }  
                
                
                    if ((DT > 21) && (PT <= 21)){
                        
                        System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". You win!");
                        PC = PC + (TB * 2);
                        System.out.println("Your chip count is now " + PC);
                        //PRINTS TO TEXT FILE
                        printWinLoss.println("Win");
                              
                        
                    }
                    //ELSE IF STATEMENT
                    else if ((DT >= PT) && !(DT > 21)){

                        System.out.println("The dealers has " + DT + " You have " + PT + " You lose.");
                        System.out.println("Your chip count is now " + PC);
                        
                        printWinLoss.println("Lose");
                        
                    }
                    else if (DT < PT){

                        System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". You win!");
                        PC = PC + (TB * 2);    
                        System.out.println("Your chip count is now " + PC);
                        
                        printWinLoss.println("Win");
                        
                        
                    }
                }
            }
            if ("N".equals(YorNcard)){
                //cardloopstop changed to 1 stopping the while loop that asks if the user wants another card
                cardloopstop = 1;
                System.out.println("okay lets find out who won");
                while (DT < 17){
                 
                    int card = newCard.randomCard(DT);
                    DT = DT + card;
                    System.out.println("The dealers new shown card is " + card);
                    System.out.println("The dealers show total is now  " + DT);  
                }  
                
                
                    if ((DT > 21) && (PT <= 21)){
                        
                        System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". You win!");
                        PC = PC + (TB * 2);
                        System.out.println("Your chip count is now " + PC);
                        
                        printWinLoss.println("Win");
                        
                        
                    }
                    else if ((DT > PT) && !(DT > 21)){

                        System.out.println("The dealers has " + DT + " You have " + PT + " You lose.");
                        System.out.println("Your chip count is now " + PC);
                        
                        printWinLoss.println("Lose");
                        
                    }
                    else if (DT < PT){

                        System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". You win!");
                        PC = PC + (TB * 2);    
                        System.out.println("Your chip count is now " + PC);
                        
                        printWinLoss.println("Win");
                        
                        
                    }
                    else if (DT == PT){

                        System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". it's a tie");
                        PC = PC + 2;    
                        System.out.println("Your chip count is now " + PC);
                        
                        printWinLoss.println("Tie");
                        
                        
                    }
                
            }
           
        }
        if (PT > 21){

            newCard.holdHand(playerArray);
            System.out.println("The dealers has " + DT + " You have " + PT + " You busted you lose!!!!");
            System.out.println("Your chip count is now " + PC);
            
        }
        
        if (PT == 21){
        while (DT < 17){

            int card = newCard.randomCard(DT);
            DT = DT + card;
            System.out.println("The dealers new shown card is " + card);
            System.out.println("The dealers show total is now  " + DT);  
        }  


            if ((DT > 21) && (PT <= 21)){

                System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". You win!");
                PC = PC + (TB * 2);
                System.out.println("Your chip count is now " + PC);
                
                printWinLoss.println("Win");
                
                
            }
            else if ((DT > PT) && !(DT > 21)){

                System.out.println("The dealers has " + DT + " You have " + PT + " You lose.");
                System.out.println("Your chip count is now " + PC);
                
                printWinLoss.println("Lose");
                
            }
            else if (DT < PT){

                System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". You win!");
                PC = PC + (TB * 2);    
                System.out.println("Your chip count is now " + PC);
                
                printWinLoss.println("Win");
                
                
            }
            else if (DT == PT){

                System.out.println("Your total is " + PT + ". The dealer's total is " + DT + ". it's a tie");
                PC = PC + 2;    
                System.out.println("Your chip count is now " + PC);
                
                printWinLoss.println("Win");
                
                
            }            
            
        }

        }
        
        }
        //shows results of chips and possibly games won after player decides they want to stop playing
        printWinLoss.close();
        System.out.println("Your chip count after playing is " + PC);
        
        //reads data from the WinLose file to display the outcome of the games played for that sitting
        File file = new File("WinLose.txt");
        Scanner inputFile = new Scanner(file);
        String record;
        System.out.println("Your wins and losses by game: ");
        while (inputFile.hasNext()){
            
        record = inputFile.nextLine();
        //OUTPUT FROM TEXT file
        System.out.println(record + " ");
            
        }
        
    }
    
}
//null issue
//21 off bat


//PT total chips do not get added in the methods?
//aces 
/* if the hand would bust && has an ace subtract 10
 * 
    need to use an array to keep track of how many 
    aces a player has */