//Eddie Kochman
//Semaphore implementation and thread in main class comes from class code
//**Philosopher names come from the first 5 if you search "famous philosophers" on google"
import java.util.concurrent.*;
import java.util.*;
/*
 ph00ilosophers[0] = "Thomas Aquinas";
         philosophers[1] = "Aristotle";
         philosophers[2] = "Confucius";
         philosophers[3] = "René Descartes";
         philosophers[4] = "Ralph Waldo Emerson";
*/
   public class DiningPhilosophers1 extends Thread {
    static List<String> list = new ArrayList<String>();
        Semaphore sem;
        String Philosopher;


    public DiningPhilosophers1(Semaphore sem, String Philosopher)
        {
            super(Philosopher);
            this.sem = sem;
            this.Philosopher = Philosopher;
        }

     public void up_Forks() {
        Object rightfork;
        Object leftfork;

        System.out.println(Philosopher + " picks up leftfork and rightfork");

    }

    public void down_Forks() {
        Object rightfork;
        Object leftfork;

        System.out.println(Philosopher + " puts down both the leftfork and rightfork");

    }


        @Override
        public void run() {

            // run by thread Thomas Aquinas
            if(this.getName().equals("Thomas Aquinas")) {
                try
                {
                    // waiting for permit until release
                    // acquiring the lock
                    sem.acquire();
                    if (true){
                        up_Forks();
                    }
                        //time for next philosopher to get the sem and current to eat
                        Thread.sleep(1000);
                   /// }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                // Release the permit and both forks.
                if (true ) {
                    down_Forks();
                }
                sem.release();
                System.out.println(Philosopher);

                //System.out.println(Philosopher);
                list.add(Philosopher);
            }

            // run by thread Aristotle
            if(this.getName().equals("Aristotle")) {

                try
                {
                    // waiting for permit until release

                    // acquiring sem
                    sem.acquire();

                    if (true){
                        up_Forks();
                    }

                    // thread release
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                // Release the permit.
                if (true ) {
                    down_Forks();
                }

                sem.release();
                System.out.println(Philosopher);

                list.add(Philosopher);
            }
            if(this.getName().equals("René Descartes")) {

                try
                {
                    // waiting for permit until release with join

                    // getting permit
                    sem.acquire();
                    if (true){
                        up_Forks();
                    }
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                // Release the permit.
                if (true ) {
                    down_Forks();
                }
                sem.release();
                System.out.println(Philosopher);

                list.add(Philosopher);
            }
            //run thread Ralph Waldo Emerson
            if(this.getName().equals("Ralph Waldo Emerson")) {
                try
                {
                    // waiting for permit until release with join

                    sem.acquire();
                    if (true){
                        up_Forks();
                    }
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                // Release the permit.
                if (true ) {
                    down_Forks();
                }
                sem.release();
                System.out.println(Philosopher);

                list.add(Philosopher );
            }
            if(this.getName().equals("Confucius")) {
                try
                {
                    sem.acquire();
                    if (true){
                        up_Forks();
                    }

                    // other waiting threads wait until they recieve permit or relasea
                    // thread release prermit
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                // Release the permit
                if (true ) {
                    down_Forks();
                }
                sem.release();
                System.out.println(Philosopher);

                list.add(Philosopher);
            }

        }


//main class
        public static void main(String args[]) throws InterruptedException
        {
            Semaphore sem = new Semaphore(1);
            //Threads
            DiningPhilosophers1 phil1 = new DiningPhilosophers1(sem, "Thomas Aquinas");
            DiningPhilosophers1 phil2 = new DiningPhilosophers1(sem, "Aristotle");
            DiningPhilosophers1 phil3 = new DiningPhilosophers1(sem, "Confucius");
            DiningPhilosophers1 phil4 = new DiningPhilosophers1(sem, "René Descartes");
            DiningPhilosophers1 phil5 = new DiningPhilosophers1(sem, "Ralph Waldo Emerson");
            // starting threads
            phil1.start();
            phil2.start();
            phil3.start();
            phil4.start();
            phil5.start();
            // waiting for threads
            phil1.join();
            phil2.join();
            phil3.join();
            phil4.join();
            phil5.join();

            System.out.println("" +
                    "" +
                    "" +
                    "");

            System.out.println("Final Order which all Philosophers ate:       " + list);


        }
    }

