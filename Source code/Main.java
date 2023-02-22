import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Quiz q = new Quiz();
        
        q.logic();

    }
}


class Quiz{
    
    Scanner sc = new Scanner(System.in);
    
    int correctAnsCount=0;
    int wrongAnsCount=0;
    
    //here I wrote every question with 4 options 
    public void logic(){
        
        Questions q1 = new Questions("Which of the following is not an OOPS concept in Java?", "A. Polymorphism ", "B. Inheritance ", "C. Compilation ", "D. Encapsulation ");
        Questions q2 = new Questions("What is the extension of java code files?", " A. .txt", "B. .pdf", "C. .sql", "D. .java");
        Questions q3 = new Questions("Which of the following is a type of polymorphism in Java Programming? ", "A. Multiple polymorphism", "B. Compile time polymorphism", "C. Multilevel polymorphism", "D. Execution time polymorphism");
        Questions q4 = new Questions("Which one of the following is not a Java feature?", "A. Object-oriented", "B. Use of pointers", "C. Portable", "D. Dynamic and Extensible");
        Questions q5 = new Questions("Which of these are selection statements in Java?", "A. break", "B. continue", "C. for()", "D. if()");

        //here I used the map function to store every question with the right answer 
        Map<Questions,Character> hmap=new HashMap<>();
        hmap.put(q1,'C');
        hmap.put(q2,'D');
        hmap.put(q3,'B');
        hmap.put(q4,'B');
        hmap.put(q5,'D');

        // here I used for loop to check if the user entered the right answer or not if the answer was correct it will print (correct) otherwise it will print (Wrong)
        for(Map.Entry<Questions,Character> map:hmap.entrySet()){
            
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());

            System.out.println("Enter Your Answer: ");
            Character ans = sc.next().charAt(0);

            int cans = Character.compare(ans,map.getValue());
            if(cans==0){
                System.out.println("Correct");
                correctAnsCount++;
            }
            else{
                System.out.println("Wrong");
                wrongAnsCount++;
            }

        }
        
        //here I made an extra feature to the project which will give you the percentage and the grade depending on your answers above
        System.out.println();
        System.out.println("-------------------------Result-------------------------");
        System.out.println("Total Questions: " + hmap.size());
        System.out.println("Correct Answered Questions : " + correctAnsCount);
        System.out.println("Wrong Answered Questions : " + wrongAnsCount);
        
        int percentage = (100*correctAnsCount)/hmap.size();
        
        System.out.println("Percentage : " + percentage);
        
        if(percentage>90){
            System.out.println("Performance : High");
        }
        
        else if(percentage<30){
            System.out.println("Performance : Very Low");
        }
        
        else{
            System.out.println("Performance : Medium");
        }


    }
}