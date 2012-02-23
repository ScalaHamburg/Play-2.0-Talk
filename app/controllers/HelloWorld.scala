package controllers

import models.Visitor
import play.api.mvc.{ Controller, Action }

object HelloWorld extends Controller {
  def helloPlay(name: String) = Action {
    val recentNames = Visitor.recentNames()
    Visitor.add(name)
    Ok(views.html.simple(name, recentNames))
  }
}
