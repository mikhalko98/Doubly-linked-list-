import java.util.Scanner;

public class Main {
    private Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        PriorityQueue queue = null;
        boolean check = true;
        while (check) {
            System.out.println("\t\t***Create***");
            System.out.println("1 - Queue on array");
            System.out.println("2 - Queue on list");
            System.out.print("Enter: ");
            int n = in.nextInt();
            switch (n){
                case 1:
                    queue = new PriorityQueueOnArray();
                    check = false;
                    break;
                case 2:
                    queue = new PriorityQueueOnList();
                    check = false;
                    break;
                default:
                    System.out.println("***Incorrect***");
            }
        }
        menu(queue);

    }

    private void menu(PriorityQueue queue){
        boolean check = true;
        while (check){
            text();
            int n = in.nextInt();
            switch (n){
                case 1:
                    System.out.print("Enter number: ");
                    queue.offer(in.nextInt());
                    break;
                case 2:
                    if(queue.isEmpty()) System.out.println("Empty");
                    else queue.remove();
                    break;
                case 3:
                    if(queue.isEmpty())
                        System.out.println("Empty");
                    else
                        System.out.println("Don't empty");
                    break;
                case 4:
                    System.out.println("Size = " +queue.size());
                    break;
                case 5:
                    queue.show();
                    break;
                case 6:
                    timeLimit(queue);
                    break;
                case 7:
                    check=false;
                    break;
                default:
                    System.out.println("***Incorrect***");
            }

        }
    }
    private void text(){
        System.out.println("\t\t***Menu***");
        System.out.println("1 Offer");
        System.out.println("2 Remove");
        System.out.println("3 Is empty");
        System.out.println("4 Size");
        System.out.println("5 Show");
        System.out.println("6 Time limited");
        System.out.println("7 Exit");
        System.out.print("Enter: ");
    }

    private void timeLimit(PriorityQueue tqueue){
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 1000 ; i++){
            tqueue.offer(1+(int)(Math.random()*1000));
        }
        for(int i = 0 ; i < 3 ; i++){
            tqueue.remove();
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time = " +(finish-start) +" mS");
    }
}

