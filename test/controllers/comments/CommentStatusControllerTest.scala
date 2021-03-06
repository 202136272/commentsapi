package controllers.comments
import domain.comments.CommentStatus
import org.joda.time.DateTime
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by Bonga on 12/16/2016.
  */
class CommentStatusControllerTest extends PlaySpec with OneAppPerTest{


  val commentStatus = CommentStatus("100", "200",DateTime)

  "Routes" should {


    "CommentStatus" should {

      "Create CommentStatus Object in Controller" in {
        val request =  route(app, FakeRequest(POST, "/CommentStatus/create")
          .withJsonBody(Json.toJson(CommentStatus)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get CommentStatus From Controller" in {
        val request = route(app, FakeRequest(GET, "/CommentStatus/get/date")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }

      "Get CommentStatus From Controller" in {
        val request = route(app, FakeRequest(GET, "/CommentStatus/get/all")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }

      "Delete Abuse From Controller" in {
        val request = route(app, FakeRequest(DELETE, "/CommentStatus/del/all")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }


}
