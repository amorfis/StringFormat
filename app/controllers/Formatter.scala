package controllers

import play.api.mvc._

object Formatter extends Controller {

  def format = Action {
    Ok(views.html.format())
  }

}