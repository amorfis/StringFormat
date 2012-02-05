package controllers

import play.api.data._
import play.api.mvc._

object Application extends Controller {
  
  val inputForm = Form(
    of(
      "inputString" -> text,
      "arg1" -> number,
      "arg2" -> number,
      "arg3" -> number
    )
  )

  def input = Action {
    Ok(views.html.input(inputForm))
  }

  def format = Action { implicit request =>
    val input = inputForm.bindFromRequest().get._1
    val arg1: java.lang.Long = inputForm.bindFromRequest().get._2
    val arg2: java.lang.Long = inputForm.bindFromRequest().get._3
    val arg3: java.lang.Long = inputForm.bindFromRequest().get._4
    
    val f = java.lang.String.format(input, arg1, arg2, arg3);
    
    Ok(views.html.format(f))
//    Ok(views.html.format("Request: " + request.queryString.get("inputString").flatMap(_.headOption)))
  }
  
}