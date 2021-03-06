package services.comments

import com.datastax.driver.core.ResultSet
import domain.comments.Comment
import services.Service
import services.comments.Impl.CommentServiceImpl

import scala.concurrent.Future

/**
  * Created by Bonga on 11/12/2016.
  */
trait CommentService {

  def getCommentBySubjectId(id:String): Future[Option[Comment]]
  def save(comment: Comment):Future[ResultSet]
  def getAllComment: Future[Seq[Comment]]
  def deleteAll:Future[ResultSet]
}

object CommentService extends Service {
  def apply(): CommentService = new CommentServiceImpl
}