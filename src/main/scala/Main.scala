import org.hibernate.criterion.Restrictions
import scala.collection.JavaConverters._

/**
 * author: dengsibao
 * Date： 2014/9/3.
 */
object Main extends App{
  try {
/*    val session = HibernateUnit.sessionFactory.openSession()
    val tx = session.beginTransaction()
    val t1 = new Teacher("lisi",false)
    val t2 = new Teacher("zhangke",false)
    session.save(t1)
    session.save(t2)
    tx.commit()
    session.close()*/

    val session1 = HibernateUnit.sessionFactory.openSession()
    val tx1 = session1.beginTransaction()
    val s1 = new Student("liuming")
    val s2 = new Student("liuyongming")
    val s3 = new Student("lihong")
    val s4 = new Student("xieweihui")
    val teacher = session1.get(classOf[Teacher], 1.asInstanceOf[Long]).asInstanceOf[Teacher]
    teacher.constr = true
    teacher.getContacts += s1
    teacher.getContacts += s2
    teacher.getContacts += s3
    teacher.getContacts += s4
    session1.save(s1)
    session1.save(s2)
    session1.save(s3)
    session1.save(s4)
    session1.update(teacher)
    teacher.getContacts.map(x => println(x))
    tx1.commit()
    session1.close()

/*    val session2 = HibernateUnit.sessionFactory.openSession()
    val tx2 = session2.beginTransaction()
    val teacher1 = session2.get(classOf[Teacher], 1.asInstanceOf[Long]).asInstanceOf[Teacher]
    teacher1.getContacts.map(x => println(x))
    tx2.commit()
    session2.close()*/
  }catch {
    case e: Exception => throw new Exception("运行失败")
  }

}
