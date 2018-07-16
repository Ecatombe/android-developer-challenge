package com.marvel.fabioinsolia.streetbees.utils

import com.marvel.fabioinsolia.streetbees.BuildConfig
import java.security.MessageDigest

class MD5Converter : IMD5Converter {

  companion object {
    var algorith = "MD5"
  }


  override fun convert(timestamp: String): String {

    var password = timestamp + BuildConfig.MarvelPrivateKey + BuildConfig.MarvelPublicKey

    val md = MessageDigest.getInstance(algorith)
    md.update(password.toByteArray())

    val byteData = md.digest()

    val hexString = StringBuffer()
    for (i in 0 until byteData.size) {
      val hex = Integer.toHexString(0xff and byteData[i].toInt())
      if (hex.length == 1) hexString.append('0')
      hexString.append(hex)
    }
    return hexString.toString()
  }

}