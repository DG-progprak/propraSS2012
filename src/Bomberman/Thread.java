import java.util.concurrent.*;

public class Thread {
public class Sound{
}
}

class MyThreadPoolExecutor
 

{
 

    //Parallel running Threads(Executor) on System
 
    int corePoolSize = 2;
 
 

    //Maximum Threads allowed in Pool
 

    int maxPoolSize = 4;
 

 

    //Keep alive time for waiting threads for jobs(Runnable)
 

    long keepAliveTime = 10;
 

 
 

    //This is the one who manages and start the work
 

    ThreadPoolExecutor threadPool = null;
 

    //Working queue for jobs (Runnable). We add them finally here
 

final ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue </runnable> <runnable> (5);
    
	public MyThreadPoolExecutor() {
 

        threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
 

                keepAliveTime, TimeUnit.SECONDS, workQueue);

    }
 
    /**
 
28.
     * Here we add our jobs to working queue
 
29.
     * 

30.
     * @param task a Runnable task
 
31.
     */
 

    public void runTask(Runnable task) {  


        threadPool.execute(task);
 

        System.out.println("Tasks in workQueue.." + workQueue.size());
    }
    

    /**
 
38.
     * Shutdown the Threadpool if it's finished
 
39.
     */
 

    public void shutDown() {
 

        threadPool.shutdown();
 

    }
 

    public static void main(String args[]) {
 

        MyThreadPoolExecutor mtpe = new MyThreadPoolExecutor();
 

        for (int i= 0; i <6; i++ ) {
 

            mtpe.runTask(new WorkerRunnable(i));
 
    }
 

        


        mtpe.shutDown();
 

        System.out.println("Finished! ");
 

    }
 

    /**
	 
	67.
	         * This is for understanding only
	 
	68.
	         * 
	
	69.
	         * @param jobNr number for displaying
	 
	70.
	         */
	 
	
	        public WorkerRunnable(int jobNr) {
	 
	
	            this.jobNr = jobNr;
	 
	
	        }


	/**
 
57.
     * This is the one who do the work
 
58.
     * 

59.
     * This one is static for accessing from main class
 
60.
     */
 
private static class WorkerRunnable implements Runnable {
 

        //so we can see which job is running
 
   private int jobNr;
 

 

        public void run() {
 

            for(int i  = 0; i <10; i++) {
 


                try {
 

                    System.out.println("Thread "+jobNr+" calculated "+ i);
 

                    Thread.currentThread().sleep(1000);
 

                } catch (InterruptedException ie) {
 

                    ie.printStackTrace();
                 }
 

            }
 

        }
 

    }
 

} 
