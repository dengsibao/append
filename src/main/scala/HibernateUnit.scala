
import org.hibernate.HibernateException
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration

/**
 * author: dengsibao
 * Date： 2014/9/3.
 */
object HibernateUnit {
  val sessionFactory = {
    try {
      val cfg = new Configuration().configure("hibernate.cfg.xml")
      val srb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties).build()
      cfg.buildSessionFactory(srb)
    } catch {
      case e: HibernateException =>
        e.printStackTrace()
        throw new ExceptionInInitializerError(e)
    }
  }
}
