package es.juanc.katas

import org.scalamock.scalatest.MockFactory
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

abstract class UnitSpec extends FlatSpec
  with Matchers
  with MockFactory
  with TableDrivenPropertyChecks {
}
