package org.opentreemap.modeling

import geotrellis.vector._
import geotrellis.vector.io._
import geotrellis.vector.io.json._
import geotrellis.spark._

import java.util.zip.GZIPInputStream

trait Masks {
  var _zipCodes:Map[String, String] = null

  lazy val zipCodes:Map[String, String] = {
    if (_zipCodes == null) {
      var zipCodeMap = scala.collection.mutable.Map[String, String]()
      val zipCodeStream = getClass.getResourceAsStream("/masks/zip-codes.tsv")
      val source = scala.io.Source.fromInputStream(zipCodeStream)
      try {
        for (line <- source.getLines) {
          val columns = line.split("\t")
          zipCodeMap += (columns(0) -> columns(1))
        }
      } finally {
        source.close
      }
      _zipCodes = zipCodeMap.toMap
    }
    _zipCodes
  }
}
