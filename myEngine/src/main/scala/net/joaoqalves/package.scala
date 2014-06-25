package net

import java.util.UUID

package object joaoqalves {
  def randomId = UUID.randomUUID().toString

  def now = System.currentTimeMillis()
}
