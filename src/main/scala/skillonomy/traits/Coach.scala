package skillonomy.traits

import java.util

trait Coach extends PlatformUser {
  protected val _students: util.HashMap[Student, Int] = new util.HashMap()

  def students: util.HashMap[Student, Int] = _students

  def addStudent(coach: Student): Unit =
    _students.put(coach, 0)

  def setPoints(): Unit =
    val random = new util.Random()
    _students
      .keySet()
      .forEach(student =>
        _students.put(student, random.nextInt(1, 6))
      )

  def distributeTokens(): Unit =
    _students
      .keySet()
      .forEach(student => {
        val points: Double = _students.get(student)
        val amount: Double = points / 5
        transferTokens(student, amount)
      })
}
