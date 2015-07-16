package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Test."))
  }
  
  def hashtags(start: Integer, end: Integer) = Action {
    // url es = http://localhost:9000/
    Ok("Start: " +start+" End: "+end)
  }

}
