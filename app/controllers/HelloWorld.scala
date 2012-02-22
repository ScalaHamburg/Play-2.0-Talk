package controllers

import play.api.mvc.{Controller, Action}

object HelloWorld extends Controller {
	def helloPlay = Action {
	  Ok(views.html.simple())
	}
}
