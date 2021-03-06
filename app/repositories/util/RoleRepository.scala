package repositories.util

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.connection.DataConnection
import domain.util.Roles

import scala.concurrent.Future

class RoleRepository extends CassandraTable[RoleRepository, Roles] {
  object id extends StringColumn(this) with PartitionKey[String]
  object rolename extends StringColumn(this)


  override def fromRow(r: Row): Roles = {
    Roles(
      id(r),
      rolename(r)
    )
  }
}

object RoleRepository extends RoleRepository with RootConnector {
  override lazy val tableName = "roles"
  override implicit def space: KeySpace = DataConnection.keySpace
  override implicit def session: Session = DataConnection.session
  def save(role: Roles): Future[ResultSet] = {
    insert
      .value(_.id, role.id)
      .value(_.rolename, role.rolename)
      .future()
  }

  def getRoleById(id: String): Future[Option[Roles]] = {
    select.where(_.id eqs id).one()
  }

  def getRoles: Future[Seq[Roles]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
}
