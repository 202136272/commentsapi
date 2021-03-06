package services.comments

import com.datastax.driver.core.ResultSet
import domain.comments.Abuse
import services.Service
import services.comments.Impl.AbuseServiceImpl

import scala.concurrent.Future

/**
  * Created by Bonga on 11/12/2016.
  */
trait AbuseService {


  def getAbuseBySubjectId(id:String): Future[Option[Abuse]]
  def save(abuse: Abuse):Future[ResultSet]
  def getAllAbuse: Future[Seq[Abuse]]
  def deleteAll:Future[ResultSet]

}

object AbuseService extends Service {
  def apply(): AbuseService = new AbuseServiceImpl
}