import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(){
//    (1..10000).forEach{
//        GlobalScope.launch {
//            val threadName = Thread.currentThread().name
//            println("$it printed on thread $threadName")
//        }
//    }
//    Thread.sleep(1000)

   GlobalScope.launch{
       execute()

    }



}
suspend fun execute(){
    GlobalScope.launch(Dispatchers.Main) {
        println("24")
    }
}