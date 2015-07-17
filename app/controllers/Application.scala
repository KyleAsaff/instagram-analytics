package controllers

import play.api._
import play.api.mvc._

import scala.concurrent._
import wabisabi._
import com.ning.http.client._

import play.api.libs.concurrent.Execution.Implicits.defaultContext

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Test."))
  }
  
  def hashtags(start: Integer, end: Integer) = Action {
    
    val client = new Client("http://localhost:9200")
    val result = client.search(index = "popular", query = "{\"query\": { \"match_all\": {} }").map(_.getResponseBody)
    println(result)
    
    Client.shutdown()
    Ok("Start Date: "+start+" End Date:"+end)
  }
}
