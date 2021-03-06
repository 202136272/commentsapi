package controllers.comments
import play.api.routing.Router._
import play.api.routing.sird._
import javax.inject.Inject
import play.api.routing.SimpleRouter

/**
  * Created by Bonga on 12/2/2016.
  */

class AbuseRouter  @Inject() (abuse: AbuseController) extends SimpleRouter{

  override def routes: Routes = {
    case GET(p"/get/abuse") =>
      abuse.getAbuse(subjectId="100")
    case GET(p"/get/all") =>
      abuse.getAllAbuse
    case POST(p"/create") =>
      abuse.createOrUpdate
  }

}

