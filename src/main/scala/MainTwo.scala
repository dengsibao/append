/**
 * author: dengsibao
 * Date： 2014/9/9.
 */

import scala.collection.mutable.{SortedSet,ArrayBuffer}
object MainTwo extends App{
  val arr = ArrayBuffer[Student]()
  val sortSet:SortedSet[String] = SortedSet.empty
  val s1 = new Student("wong")
  val s2 = new Student("name")
  val s3 = new Student("age")
  val s4 = new Student("height")
  val s5 = new Student("long")
  val s6 = new Student("int")
  val list = List(s1,s2,s3,s4,s5,s6)
  val sort = list.map(x => sortSet += x.name)
  val array = sortSet.toArray
  for(i <- 0 until array.size;eme <- list){
    if(array(i) == eme.name){
      arr += eme
    }
  }
  arr.foreach(x => println(x.name))
}
