import java.util
import javax.persistence._
import scala.collection.JavaConverters._
/**
 * author: dengsibao
 * Date： 2014/9/3.
 */
@Entity
class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  var id: Long = _
  var name: String = _
  var constr: Boolean = false

  @OneToMany(cascade = Array(CascadeType.ALL))
  @JoinColumn(name = "teacher_id")
  private var contacts:util.Set[Student] =  new util.HashSet[Student]() //联系人
  def getContacts = contacts.asScala
  def setContacts(_contacts: Set[Student]) = {contacts = _contacts.asJava}

  def this(name: String,constr:Boolean) = {
    this
    this.name = name
    this.constr = constr
  }

  override def toString = s"teacher id: $id  name: $name"
}
