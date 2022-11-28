package skillonomy.models

import skillonomy.traits.{Coach, PlatformUser, Student}

import java.util
import java.util.{HashMap, UUID}

class User(
            private var _name: String,
            private var _surname: String
          ) extends Coach with Student with PlatformUser :
  require(nonEmpty(_name), "Invalid name")
  require(nonEmpty(_surname), "Invalid surname")

  val id: UUID = UUID.randomUUID()

  def name: String = _name

  def surname: String = _surname

  override def hashCode(): Int = id.hashCode()

  private def nonEmpty(string: String): Boolean =
    string.nonEmpty && !string.isBlank

end User
