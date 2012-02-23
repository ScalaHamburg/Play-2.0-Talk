package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Visitor(id: Long, name: String)

object Visitor {

  def add(name: String) = DB.withConnection { implicit conn =>
    SQL("INSERT INTO visitor (name) VALUES ({name})")
    .on('name -> name).execute()
  }

  def recentNames(): Option[List[String]] = DB.withTransaction { implicit conn =>
    val count: Long = SQL("SELECT COUNT(*) FROM visitor")
                      .as(scalar[Long].single)
    if (count == 0) None
    else Some(SQL("SELECT name FROM visitor ORDER BY seen DESC LIMIT 3")
              .as(scalar[String].*))
  }

}
