import javax.persistence._
import java.util


/**
 * author: dengsibao
 * Date： 2014/9/3.
 */
@Entity
class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  var id: Long = _
  var name:String = _

  @OneToMany
  var sameName: util.Set[Student] = new util.HashSet[Student]()

  def this(name: String) = {
    this
    this.name = name
  }
  override def toString = s"student id: $id  name: $name"
}
