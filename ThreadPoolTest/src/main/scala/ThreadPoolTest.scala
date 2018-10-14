import java.util.concurrent.{Callable, ExecutorService, Executors, FutureTask}

object ThreadPoolTest {
  def main(args: Array[String]): Unit = {
    val threadPool:ExecutorService = Executors.newFixedThreadPool(5)
    try{
      for(i <-1 to 5){
        threadPool.execute(new ThreadDemo("thread"+i))
      }
    }finally {
       threadPool.shutdown()
    }
  }
}

class ThreadDemo(threadName:String) extends Runnable{
  override def run(): Unit = {
    for( i <- 0 to 5){
      println(threadName + i)
      Thread.sleep(500)
    }
  }
}

/*object ThreadPoolTest {
  def main(args: Array[String]) {
    val threadPool: ExecutorService = Executors.newFixedThreadPool(3)
    try {
      val future = new FutureTask[String](new Callable[String] {
        override def call(): String = {
          Thread.sleep(100)
          return "im result"
        }
      })
      threadPool.execute(future)
      println(future.get())
    } finally {
      threadPool.shutdown()
    }
  }
}*/
