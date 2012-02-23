package controllers

import models.Visitor
import play.api.mvc.{ Controller, Action }

object HelloWorld extends Controller {
  def helloPlay(name: String) = Action {
    Visitor.add("Java")
    Visitor.add("Play Framework")
    Visitor.add("Scala")
    val recentNames = Visitor.recentNames()
    Visitor.add(name)
    Ok(views.html.simple(name, recentNames))
  }
}
